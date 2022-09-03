package org.vubbo.zhouyu.consumer;

import org.vubbo.zhouyu.api.HelloService;
import org.vubbo.zhouyu.framework.proxy.ProxyFactory;

/**
 * @author vizz
 * @since 2022/8/20 23:52
 */
public class ProxyConsumerApp {
    public static void main(String[] args) {

        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        String result = helloService.say("proxy is handsome");
        System.out.println(result);
    }
}
