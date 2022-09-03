package org.vubbo.zhouyu.provider;

import org.vubbo.zhouyu.api.HelloService;
import org.vubbo.zhouyu.framework.protocol.http.HttpServer;
import org.vubbo.zhouyu.framework.register.LocalRegister;

/**
 * @author vizz
 * @since 2022/8/20 22:15
 */
public class ProviderApp {

    public static void main(String[] args) {

        //理论上应该高级一点，比如扫描xml文件或者注解等
        LocalRegister.regis(HelloService.class.getName(), HelloServiceImpl.class);

        HttpServer server = new HttpServer();
        server.start("localhost", 8080);
    }
}
