package cn.kanmars.ecm;

import cn.com.xbase.frame.util.HttpUtils;

/**
 * 该类用于直接使用Http请求方式调用服务器端数据，目前仅支持HTTP协议，不支持HTTPS
 * Created by baolong on 2017/1/16.
 */
public class SimpleServiceTest {

    public static void main(String[] args) {
        String s = HttpUtils.submitGet("http://localhost");
        System.out.println(s);
    }
}
