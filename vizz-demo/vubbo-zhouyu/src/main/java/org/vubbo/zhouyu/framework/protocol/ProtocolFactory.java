package org.vubbo.zhouyu.framework.protocol;

import org.vubbo.zhouyu.framework.protocol.http.HttpProtocol;
import org.vubbo.zhouyu.framework.protocol.netty.DubboProtocol;

/**
 * @author vizz
 * @since 2022/8/21 21:20
 */
public class ProtocolFactory {

    public static Protocol getProtocol() {
        // use like -DprotocolName=dubbo
        String name = System.getProperty("protocolName");

        if (name == null || "".equals(name)) name = "dubbo";

        switch (name) {
            case "http":
                return new HttpProtocol();
            case "dubbo":
                return new DubboProtocol();
            default:
                break;
        }
        return new DubboProtocol();
    }
}
