package cn.kanmars.ecm.dyndata.impl;

import cn.kanmars.ecm.dyndata.DynamicDataSourceRouter;
import org.springframework.stereotype.Component;

/**
 * Created by kanmars on 2017/5/9.
 */
@Component("MyDataSourceRouter")
public class MyDataSourceRouter implements DynamicDataSourceRouter {
    @Override
    public String router(Object ... partionKeys) {
        return "ecm-DataSource-ds1";
    }
}
