package org.fan.dds.service;

import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @author vizz
 * @since 2022/8/24 10:56
 */
@SPI("echo")
public interface EchoService {

    @Adaptive({"server","type"})
    String say();

}
