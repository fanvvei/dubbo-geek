package org.vubbo.zhouyu.provider;

import org.vubbo.zhouyu.api.HelloService;
import org.vubbo.zhouyu.framework.protocol.Protocol;
import org.vubbo.zhouyu.framework.protocol.ProtocolFactory;
import org.vubbo.zhouyu.framework.register.LocalRegister;
import org.vubbo.zhouyu.framework.register.RemoteMapRegister;
import org.vubbo.zhouyu.framework.register.URL;

/**
 * @author vizz
 * @since 2022/8/21 21:13
 */
public class NettyProviderApp {
    public static void main(String[] args) {
        LocalRegister.regis(HelloService.class.getName(), HelloServiceImpl.class);

        URL url = new URL("localhost", 8080);
        RemoteMapRegister.regis(HelloService.class.getName(), url);

        Protocol protocol = ProtocolFactory.getProtocol();
        protocol.start(url);

    }
}
