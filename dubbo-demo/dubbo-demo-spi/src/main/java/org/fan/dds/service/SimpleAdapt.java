package org.fan.dds.service;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @author vizz
 * @since 2022/8/30 17:04
 */
@SPI("simple")
public interface SimpleAdapt {
    @Adaptive
    String echo(URL url,String s);
}
