package org.vubbo.zhouyu.provider;

import org.vubbo.zhouyu.api.HelloService;
import org.vubbo.zhouyu.framework.protocol.http.HttpServer;
import org.vubbo.zhouyu.framework.register.LocalRegister;
import org.vubbo.zhouyu.framework.register.RemoteMapRegister;
import org.vubbo.zhouyu.framework.register.URL;

/**
 * @author vizz
 * @since 2022/8/21 17:32
 */
public class RemoteProviderApp {
    public static void main(String[] args) {

        //理论上应该高级一点，比如扫描xml文件或者注解等
        LocalRegister.regis(HelloService.class.getName(), HelloServiceImpl.class);

        URL url = new URL("localhost", 8080);
        RemoteMapRegister.regis(HelloService.class.getName(), url);

        HttpServer server = new HttpServer();
        server.start(url.getHostname(), url.getPort());
    }
}
