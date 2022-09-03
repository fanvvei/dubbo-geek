package org.vubbo.zhouyu.consumer;

import org.vubbo.zhouyu.api.HelloService;
import org.vubbo.zhouyu.framework.entity.Invocation;
import org.vubbo.zhouyu.framework.protocol.http.HttpClient;

/**
 * @author vizz
 * @since 2022/8/20 22:14
 */
public class HttpConsumerApp {
    public static void main(String[] args) {

        Invocation invocation = new Invocation(HelloService.class.getName(),
                "say",
                new Class[]{String.class},
                new Object[]{"http is handsome"});


        HttpClient httpClient = new HttpClient();
        String res = httpClient.send("localhost", 8080, invocation);
        System.out.println(res);
    }
}
