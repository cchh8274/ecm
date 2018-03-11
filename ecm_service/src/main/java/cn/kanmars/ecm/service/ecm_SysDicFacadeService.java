/**
 * ecm Generator 
 */
package cn.kanmars.ecm.service;

import cn.com.xbase.frame.logger.HLogger;
import cn.com.xbase.frame.logger.LoggerManager;
import cn.com.xbase.frame.logic.ResultEnum;
import cn.com.xbase.frame.util.*;
import cn.kanmars.ecm.logic.SysDicGetOneLogic;
import cn.kanmars.ecm.logic.SysDicGetListLogic;
import cn.kanmars.ecm.logic.SysDicGetAllLogic;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

/**
 * ecm_系统数据字典服务
 * 在此服务中手工增加了断路器，但是一般情况下，在以Feign为客户端的调用中，是自带Hystrix的
 * 可以通过在bootstrap.properties中修改配置来修改
 */
@Controller
@RequestMapping("/ecm_sysdic")
public class ecm_SysDicFacadeService {

    protected HLogger logger = LoggerManager.getLoger("ecm_SysDicFacadeService");

    @Autowired
    private SysDicGetOneLogic sysDicGetOneLogic;
    @Autowired
    private SysDicGetListLogic sysDicGetListLogic;
    @Autowired
    private SysDicGetAllLogic sysDicGetAllLogic;

    @HystrixCommand(
            groupKey="ecm_SysDicFacadeService.getAll"
            ,commandKey="ecm_SysDicFacadeService.getAll"
            ,threadPoolKey="ecm_SysDicFacadeService.getAll"
//            ,fallbackMethod = "fallbackSearchAll"
            ,commandProperties={
            @HystrixProperty(name= HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD,value="5")//10秒5次请求
            ,@HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS,value="5000")//熔断5秒
            ,@HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE,value="50")//出错率50%则熔断
            ,@HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_ENABLED,value="true")
            ,@HystrixProperty(name=HystrixPropertiesManager.REQUEST_CACHE_ENABLED,value="false")
            ,@HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_FORCE_OPEN,value="false")}//强制开启
            ,threadPoolProperties={
            @HystrixProperty(name= HystrixPropertiesManager.CORE_SIZE,value="10")
    }
    )
    @ResponseBody
    @RequestMapping(value="/getAll",method = RequestMethod.GET)
    public HashMap getAll() throws Exception {
        HashMap result = new HashMap();
        logger.info("ecm_SysDicFacadeService.getAll.start");
        if(!ResultEnum.PartOK.equals(sysDicGetAllLogic.exec(result))){
            return result;
        }
        result.put("resCode","0000");
        result.put("resDesc","成功");
        logger.info("ecm_SysDicFacadeService.getAll[获取全量数据字典].end");
        return result;
    }

    @HystrixCommand(
            groupKey="ecm_SysDicFacadeService.getList"
            ,commandKey="ecm_SysDicFacadeService.getList"
            ,threadPoolKey="ecm_SysDicFacadeService.getList"
//            ,fallbackMethod = "fallbackSearchAll"
            ,commandProperties={
            @HystrixProperty(name= HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD,value="5")//10秒5次请求
            ,@HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS,value="5000")//熔断5秒
            ,@HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE,value="50")//出错率50%则熔断
            ,@HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_ENABLED,value="true")
            ,@HystrixProperty(name=HystrixPropertiesManager.REQUEST_CACHE_ENABLED,value="false")
            ,@HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_FORCE_OPEN,value="false")}//强制开启
            ,threadPoolProperties={
            @HystrixProperty(name= HystrixPropertiesManager.CORE_SIZE,value="10")
    }
    )
    @ResponseBody
    @RequestMapping(value="/getList/{l1_code}/{l2_code}",method = RequestMethod.GET)
    public HashMap getList(@PathVariable("l1_code") String l1_code,@PathVariable("l2_code") String l2_code) throws Exception {
        HashMap result = new HashMap();
        logger.info("ecm_SysDicFacadeService.getList.start");
        result.put("l1_code", l1_code);
        result.put("l2_code", l2_code);
        if(!ResultEnum.PartOK.equals(sysDicGetListLogic.exec(result))){
            return result;
        }
        result.put("resCode","0000");
        result.put("resDesc","成功");
        logger.info("ecm_SysDicFacadeService.getList[根据l1_code、l2_code获取List].end");
        return result;
    }

    @HystrixCommand(
            groupKey="ecm_SysDicFacadeService.getOne"
            ,commandKey="ecm_SysDicFacadeService.getOne"
            ,threadPoolKey="ecm_SysDicFacadeService.getOne"
//            ,fallbackMethod = "fallbackSearchAll"
            ,commandProperties={
            @HystrixProperty(name= HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD,value="5")//10秒5次请求
            ,@HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS,value="5000")//熔断5秒
            ,@HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE,value="50")//出错率50%则熔断
            ,@HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_ENABLED,value="true")
            ,@HystrixProperty(name=HystrixPropertiesManager.REQUEST_CACHE_ENABLED,value="false")
            ,@HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_FORCE_OPEN,value="false")}//强制开启
            ,threadPoolProperties={
            @HystrixProperty(name= HystrixPropertiesManager.CORE_SIZE,value="10")
    }
    )
    @ResponseBody
    @RequestMapping(value="/getOne/{l1_code}/{l2_code}/{code_param}",method = RequestMethod.GET)
    public HashMap getOne(@PathVariable("l1_code") String l1_code,@PathVariable("l2_code") String l2_code,@PathVariable("code_param") String code_param) throws Exception {
        HashMap result = new HashMap();
        logger.info("ecm_SysDicFacadeService.getOne.start");
        result.put("l1_code", l1_code);
        result.put("l2_code", l2_code);
        result.put("code_param", code_param);
        if(!ResultEnum.PartOK.equals(sysDicGetOneLogic.exec(result))){
            return result;
        }
        result.put("resCode","0000");
        result.put("resDesc","成功");
        logger.info("ecm_SysDicFacadeService.getOne[根据l1_code、l2_code、paramCode获取Value].end");
        return result;
    }
}


