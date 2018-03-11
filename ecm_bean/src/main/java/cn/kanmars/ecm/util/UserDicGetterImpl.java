package cn.kanmars.ecm.util;

import cn.com.xbase.frame.logger.HLogger;
import cn.com.xbase.frame.logger.LoggerManager;
import cn.com.xbase.frame.util.DateUtils;
import cn.kanmars.ecm.dao.TblSysuserInfoMapper;
import cn.kanmars.ecm.entity.TblSysDic;
import cn.kanmars.ecm.entity.TblSysuserInfo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by kanmars on 2017/6/14.
 */
public class UserDicGetterImpl implements SysDicUtils.UserDicGetter,ApplicationContextAware {

    protected HLogger logger = LoggerManager.getLoger("UserDicGetterImpl");

    private Integer liveCount = 20;

    private ApplicationContext ac = null;

    @Autowired
    public TblSysuserInfoMapper tblSysuserInfoMapper;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ac = applicationContext;
    }

    @Override
    public TblSysDic getUserDic(String l1Code, String l2Code, String codeParam) {
        logger.debug("UserDicGetterImpl.getUserDic([l1Code="+l1Code+"],[l2Code="+l2Code+"],[codeParam="+codeParam+"])--start");
        TblSysDic tblSysDic = null;
        //l1Code : tbl_sysuser_info    l2Code : user_no    数据字典，缓存60秒
        if(l1Code.equalsIgnoreCase("tbl_sysuser_info")){
            if(l2Code.equalsIgnoreCase("user_no")){
                TblSysuserInfo tblSysuserInfo = new TblSysuserInfo();
                tblSysuserInfo.setUserNo(codeParam);
                try{
                    tblSysuserInfo = tblSysuserInfoMapper.select(tblSysuserInfo);
                }catch (Exception e){
                    logger.debug("查询数据异常",e);
                    tblSysuserInfo = null;
                }
                if(tblSysuserInfo!=null){
                    tblSysDic = new TblSysDic();
                    tblSysDic.setId(new Random().nextInt());
                    tblSysDic.setL1Code(l1Code);
                    tblSysDic.setL1Desc(l1Code);
                    tblSysDic.setL2Code(l2Code);
                    tblSysDic.setL2Desc(l2Code);
                    tblSysDic.setCodeParam(codeParam);
                    tblSysDic.setCodeValue(tblSysuserInfo.getUserName());
                    tblSysDic.setCodeIdx(tblSysuserInfo.getUserName().hashCode());
                    tblSysDic.setLiveCount(liveCount);//60秒有效
                    tblSysDic.setCreateTime(tblSysuserInfo.getCreateTime());
                    tblSysDic.setUpTime(tblSysuserInfo.getUpTime());
                }
            }
        }
        logger.debug("UserDicGetterImpl.getUserDic([l1Code="+l1Code+"],[l2Code="+l2Code+"],[codeParam="+codeParam+"])--end");
        return tblSysDic;
    }

    @Override
    public List<TblSysDic> getUserDicList(String l1Code, String l2Code) {
        logger.debug("UserDicGetterImpl.getUserDicList([l1Code="+l1Code+"],[l2Code="+l2Code+"])--start");
        List<TblSysDic> result = null;
        //l1Code : tbl_sysuser_info    l2Code : user_no    数据字典，缓存60秒
        if(l1Code.equalsIgnoreCase("tbl_sysuser_info")){
            if(l2Code.equalsIgnoreCase("user_nm")){
                TblSysuserInfo tblSysuserInfo = new TblSysuserInfo();
                tblSysuserInfo.setUserStatus("010");
                List<TblSysuserInfo> list = null;
                try{
                    list = tblSysuserInfoMapper.selectList(tblSysuserInfo);
                }catch (Exception e){
                    logger.debug("查询数据异常",e);
                    tblSysuserInfo = null;
                }
                if(list!=null&&list.size()!=0){
                    result = new ArrayList<TblSysDic>();
                    for(TblSysuserInfo sysuserInfo:list){
                        TblSysDic tblSysDic = new TblSysDic();
                        tblSysDic.setId(new Random().nextInt());
                        tblSysDic.setL1Code(l1Code);
                        tblSysDic.setL1Desc(l1Code);
                        tblSysDic.setL2Code(l2Code);
                        tblSysDic.setL2Desc(l2Code);
                        tblSysDic.setCodeParam(sysuserInfo.getUserNo());
                        tblSysDic.setCodeValue(sysuserInfo.getUserName());
                        tblSysDic.setCodeIdx(sysuserInfo.getUserName().hashCode());
                        tblSysDic.setLiveCount(liveCount);//60秒有效
                        tblSysDic.setCreateTime(sysuserInfo.getCreateTime());
                        tblSysDic.setUpTime(sysuserInfo.getUpTime());
                        result.add(tblSysDic);
                    }
                }
            }
        }
        logger.debug("UserDicGetterImpl.getUserDic([l1Code="+l1Code+"],[l2Code="+l2Code+"])--end");

        return result;
    }


}
