package org.fan.dds;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.fan.dds.service.CallService;
import org.fan.dds.service.EchoService;
import org.fan.dds.service.SimpleAdapt;

import java.util.ServiceLoader;

/**
 * @author vizz
 * @since 2022/7/29 17:07
 */
public class DubboDemoSpiApp {
    public static void main(String[] args) {
//        ServiceLoader<CallService> callServices = ServiceLoader.load(CallService.class);
//        for (CallService callService : callServices) {
//            callService.showInfo();
//        }

//        CallService callService = ExtensionLoader.getExtensionLoader(CallService.class).getDefaultExtension();
//        callService.showInfo();
//        EchoService echoService = ExtensionLoader.getExtensionLoader(EchoService.class).getDefaultExtension();
//        echoService.say();

        SimpleAdapt adaptiveExtension = ExtensionLoader.getExtensionLoader(SimpleAdapt.class).getAdaptiveExtension();
        URL url = new URL("dubbo", "127.0.0.1", 2990, "path1");
        String hello = adaptiveExtension.echo(url, "hello");
        System.out.println(hello);
    }
}
