package cn.kanmars.ecm.utils;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import cn.com.xbase.frame.logger.HLogger;
import cn.com.xbase.frame.logger.LoggerManager;
import cn.com.xbase.frame.util.ServerInfoUtils;
import cn.com.xbase.frame.util.StringUtils;
import cn.kanmars.ecm.bean.TaskBasicConfig;

public class QueryServerInfo {

	private static HLogger logger = LoggerManager.getLoger("QueryServerInfo");

    /** IP */
    private static String LOCAL_IP_HOST = "";

    /**
    * @Title: checkIp
    * @Description: 判断此任务需要单台机器执行
    * 当serverIp为空时，创建此任务，返回true;
    * 当serverIp与当前服务器IP相符时，创建此任务，返回true;
    * 当serverIp与当前服务器IP不相符时，不创建此任务，返回false;
    * @param config
    * @return boolean    返回类型
    * @throws
     */
    public static boolean checkIp(TaskBasicConfig config){
        if(StringUtils.isEmpty(config.getServerIp())){
            //如果任务没有配置serverIp，则直接返回true
            return true;
        }else{
            //如果任务设置了serverIp
            if(StringUtils.isEmpty(config.getInternetName())){
                //如果任务没有设置网卡名称，则返回false
                return false;
            }
            if(StringUtils.isEmpty(LOCAL_IP_HOST)){
                ServerInfoUtils.initLocalIp(config.getInternetName());
                String serverIp = ServerInfoUtils.getIp();
                if(serverIp.equalsIgnoreCase("UnknownHost")){
                    //如果返回值为UnknownHost，则返回false;
                    throw new RuntimeException("调用定时任务时，需要以IP为准设置唯一机器标识，根据hostname查询IP失败，请检查机器/etc/hostname与/etc/hosts配置");
                }
                //serverIp校验通过，则设置QueryServerInfo中的Local_ip_host为查询到的serverIp
                LOCAL_IP_HOST = serverIp;
            }
			//指定IP运行，且获取到了当前机器的IP
			List<String> targetIps = Arrays.asList(config.getServerIp().split(","));
			if(targetIps.contains(LOCAL_IP_HOST)){
				return true;
			}
			return false;
		}
	}

	public static String getHostName() {
		return ServerInfoUtils.getHostName();
	}

	public static String getIp(){
        if(StringUtils.isNotEmpty(LOCAL_IP_HOST)){
            //已被有网卡名称的程序初始化
            return LOCAL_IP_HOST;
        }else{
            return ServerInfoUtils.getIp();
        }
	}
	public static String getPid(){
        return ServerInfoUtils.getPid();
	}
}
