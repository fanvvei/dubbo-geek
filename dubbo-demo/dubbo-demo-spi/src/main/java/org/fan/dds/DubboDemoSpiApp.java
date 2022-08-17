package org.fan.dds;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.fan.dds.service.CallService;

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

        CallService callService = ExtensionLoader.getExtensionLoader(CallService.class).getDefaultExtension();
        callService.showInfo();
    }
}
