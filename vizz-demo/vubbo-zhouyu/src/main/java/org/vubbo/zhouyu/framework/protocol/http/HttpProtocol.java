package org.vubbo.zhouyu.framework.protocol.http;

import org.vubbo.zhouyu.framework.entity.Invocation;
import org.vubbo.zhouyu.framework.protocol.Protocol;
import org.vubbo.zhouyu.framework.register.URL;

/**
 * @author vizz
 * @since 2022/8/21 21:10
 */
public class HttpProtocol implements Protocol {
    @Override
    public void start(URL url) {
        new HttpServer().start(url.getHostname(), url.getPort());
    }

    @Override
    public String send(URL url, Invocation invocation) {
        return new HttpClient().send(url.getHostname(), url.getPort(), invocation);
    }
}
