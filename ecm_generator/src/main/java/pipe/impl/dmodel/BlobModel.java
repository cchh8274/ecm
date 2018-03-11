package pipe.impl.dmodel;

import org.apache.commons.lang.StringUtils;

/**
 * Created by baolong on 2017/1/23.
 */
public class BlobModel extends ValidateModel {
    {
        type = TYPE.blob.toString();
    }

    /**
     * 生成一个BlobModel
     * @param power             权限，有三种写法：
     *                          1、query-condition:Y,query-result:Y,add:Y,detail:Y,update-show:Y,update-update:Y
     *                          2、YYYYYN
     *                          3、yyyynn
     * @param notEmptyMsg      非空消息提示，为空则允许为空
     * @param min               字节最小值，-1为不限制
     * @param max               字节最大值，-1为不限制
     * @return
     */
    public static BlobModel getInstance(String power,String notEmptyMsg,int min,int max,String strLengthMsg){
        BlobModel blobModel = new BlobModel();
        blobModel.setPower(power);
        blobModel.setNotEmpty(notEmptyMsg);
        if(min>=0&&max>=0&&StringUtils.isNotEmpty(strLengthMsg)){
            blobModel.setStringLength(min,max,strLengthMsg);
        }
        return blobModel;
    }
}
