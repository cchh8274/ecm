package cn.kanmars.ecm.utils;

import cn.com.xbase.frame.logger.HLogger;
import cn.com.xbase.frame.logger.LoggerManager;
import cn.com.xbase.frame.util.StringUtils;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.MessageQueueSelector;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageQueue;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by baolong on 2016/4/14.
 */
public class TaskTrigerUtils {

    public static final HLogger logger = LoggerManager.getLoger("TaskTrigerUtils");

    protected static ConcurrentHashMap<String,DefaultMQProducer> producerMap  = new ConcurrentHashMap<String,DefaultMQProducer>();

    public static final String charset = "utf-8";

    public synchronized static boolean trigerTask(String mqProducerGroup,String instanceName,String nameServerAddr,String mqNotifyGroup,String businessObjName,String globalTaskName,String key,String message){
        try{
            DefaultMQProducer producer = producerMap.get(mqProducerGroup);
            if(producer == null){
                producer = new DefaultMQProducer(mqProducerGroup);
                producer.setInstanceName(instanceName);
                producer.setNamesrvAddr(nameServerAddr);
                producer.start();
                producerMap.put(mqProducerGroup,producer);
            }
            if(StringUtils.isEmpty(message)){
                message= "NULLMESSAGE";
            }
            for(int i = 0; i<1;i++){
                String topic = "TASK_TRIGER_TOPIC_"+mqNotifyGroup;
                String tags = globalTaskName.replaceAll("\\.","_");
                Message msg = new Message(topic,// topic
                        tags,// tags
                        key,// key
                        message.getBytes(charset));// body
                SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                    public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                        Integer id = (Integer) arg;
                        return mqs.get(id);
                    }
                },0);
            }
            return true;
        }catch (Exception e){
            logger.error("任务触发异常",e);
            return false;
        }
    }


    private static int selectoridx = 0;
    /**
     * 简单轮询算法发送消息
     * @param mqProducerGroup
     * @param instanceName
     * @param nameServerAddr
     * @param mqNotifyGroup
     * @param businessObjName
     * @param zkAddr
     * @param key
     * @param message
     */
    public static void trigerTaskByZk(String mqProducerGroup,
                                      String instanceName,
                                      String nameServerAddr,
                                      String mqNotifyGroup,
                                      String businessObjName,
                                      String zkAddr,
                                      String key,
                                      String message){
        logger.debug("尝试发送mqProducerGroup["+mqProducerGroup+"]" +
                "instanceName["+instanceName+"]" +
                "nameServerAddr["+nameServerAddr+"]" +
                "mqNotifyGroup["+mqNotifyGroup+"]" +
                "businessObjName["+businessObjName+"]" +
                "zkAddr["+zkAddr+"]key["+key+"]message["+message+"]");
        ZkClient zkClient = new ZkClient(zkAddr);
        List<String> list = zkClient.getChildren("/"+BasisConstants.ZOOKEEPER_BASE_PATH+"/"+businessObjName+"/"+mqNotifyGroup);
        logger.debug("获取到的任务触发器有["+list+"]");
        zkClient.close();

        //简单轮询发送
        int index = selectoridx;
        if(index > list.size()-1){
            index = 0;
            selectoridx=0;
        }
        selectoridx++;
        String globalTaskName = list.get(index);
        boolean trigerIsSuccess = TaskTrigerUtils.trigerTask(mqProducerGroup,instanceName,nameServerAddr,mqNotifyGroup,businessObjName,globalTaskName,key,message);
        logger.debug("发送结果为["+trigerIsSuccess+"]");
    }


    public static void main(String[] args) throws MQClientException {
        sendByZk();
    }
    private static void send(){
        String mqProducerGroup = "finance-payment";
        String instanceName = "finance-payment-instance_001";
        String nameServerAddr = "10.58.50.204:9876;10.58.50.205:9876";
        String mqNotifyGroup = "UAT_GROUP";
        String globalTaskName = "CPSRateSuccessOrderSyncTask_HOSTNAMEBAOLONG_IP10_144_33_185_PID9112_TASKNAME37_0";
        String businessObjName = globalTaskName.substring(0,globalTaskName.indexOf("_"));

        String key = "k";
        String message = "msg";
        boolean trigerIsSuccess = TaskTrigerUtils.trigerTask(mqProducerGroup,instanceName,nameServerAddr,mqNotifyGroup,businessObjName,globalTaskName,key,message);
        logger.info("触发结果"+(trigerIsSuccess?"[成功]":"[失败]"));
    }

    private static void sendByZk(){
        String businessObjName = "sellOutAssetConfirmStep";
        String group = "UAT_GROUP";
        String registerAddr = "10.58.57.58:2181,10.58.57.54:2181,10.58.57.48:2181";
        String mqProducerGroup = "finance-payment";
        String instanceName = "finance-payment-instance_001";
        String nameServerAddr = "10.58.50.204:9876;10.58.50.205:9876";
        String mqNotifyGroup = "UAT_GROUP";

        ZkClient zkClient = new ZkClient(registerAddr);
        List<String> list = zkClient.getChildren("/JRFINANCE_TASKREGISTER/"+businessObjName+"/"+group);
        for(String s : list){
            System.out.println("可选择的任务有["+s+"]");
        }
        String globalTaskName = list.get(0);
        String key = "a";
        String message = "b";

        boolean trigerIsSuccess = TaskTrigerUtils.trigerTask(mqProducerGroup,instanceName,nameServerAddr,mqNotifyGroup,businessObjName,globalTaskName,key,message);
        zkClient.close();
        logger.info("触发结果"+(trigerIsSuccess?"[成功]":"[失败]"));
    }
}
