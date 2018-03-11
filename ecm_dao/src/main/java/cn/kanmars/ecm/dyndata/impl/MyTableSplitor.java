package cn.kanmars.ecm.dyndata.impl;

/**
 * Created by kanmars on 2017/5/9.
 */

import cn.kanmars.ecm.dyndata.DynamicTableSplitor;
import org.springframework.stereotype.Component;

@Component("MyTableSplitor")
public class MyTableSplitor implements DynamicTableSplitor {
    @Override
    public String suffix(Object... splitKeys) {
        if(1==1)return"_201704";
        return "";
    }
}
