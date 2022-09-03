package org.vubbo.zhouyu.framework.proxy;

import org.vubbo.zhouyu.framework.LoadBalance;
import org.vubbo.zhouyu.framework.entity.Invocation;
import org.vubbo.zhouyu.framework.protocol.Protocol;
import org.vubbo.zhouyu.framework.protocol.ProtocolFactory;
import org.vubbo.zhouyu.framework.protocol.RpcException;
import org.vubbo.zhouyu.framework.protocol.http.HttpClient;
import org.vubbo.zhouyu.framework.protocol.netty.DubboProtocol;
import org.vubbo.zhouyu.framework.register.RemoteMapRegister;
import org.vubbo.zhouyu.framework.register.URL;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @author vizz
 * @since 2022/8/20 23:46
 */
public class ProxyFactory {

    public static <T> T getProxy(Class interfaceClass) {
        //这里应该读取配置，选择性的使用jdk代理、cglib、javassist

        Object instance = Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(), new Class[]{interfaceClass}, (proxy, method, args) -> {

            String result = null;

            // mock here

            try {
                System.out.println("in jdk proxy");
                Invocation invocation = new Invocation(
                        interfaceClass.getName(),
                        method.getName(),
                        method.getParameterTypes(),
                        args);

                //方法1，通过直连的方式
//            HttpClient httpClient = new HttpClient();
//            String result = httpClient.send("localhost", 8080, invocation);

                //方法2，增加注册中心+负载均衡
//            HttpClient httpClient = new HttpClient();
//            List<URL> urls = RemoteMapRegister.get(interfaceClass.getName());
//            URL url = LoadBalance.getFirst(urls);
//            String result = httpClient.send(url.getHostname(), url.getPort(), invocation);

                //方法3，netty方式
//            DubboProtocol protocol = new DubboProtocol();
//            List<URL> urls = RemoteMapRegister.get(interfaceClass.getName());
//            URL url = LoadBalance.getFirst(urls);
//            String result = protocol.send(url, invocation);

                //方法4，工厂方式
                Protocol protocol = ProtocolFactory.getProtocol();
                List<URL> urls = RemoteMapRegister.get(interfaceClass.getName());
                URL url = LoadBalance.getFirst(urls);
                result = protocol.send(url, invocation);
            } catch (RpcException e) {
                System.out.println("容错信息，no provider");
            }

            return result;
        });

        return (T) instance;

    }
}
