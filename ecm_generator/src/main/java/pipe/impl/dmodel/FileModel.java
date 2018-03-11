package pipe.impl.dmodel;

/**
 * Created by baolong on 2017/1/25.
 */
public class FileModel extends ValidateModel  {
    {
        type = TYPE.file.toString();
    }

    /**
     * 生成一个FileModel
     * @param power             权限，有三种写法：
     *                          1、query-condition:Y,query-result:Y,add:Y,detail:Y,update-show:Y,update-update:Y
     *                          2、YYYYYN
     *                          3、yyyynn
     * @param notEmptyMsg      非空消息提示，为空则允许为空
     * @return
     */
    public static FileModel getInstance(String power,String notEmptyMsg){
        FileModel fileModel = new FileModel();
        fileModel.setPower(power);
        fileModel.setNotEmpty(notEmptyMsg);
        return fileModel;
    }
}
