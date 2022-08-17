package org.fan.dds.service;

import org.apache.dubbo.common.extension.SPI;

/**
 * @author vizz
 * @since 2022/7/29 17:08
 */
@SPI("impl")
public interface CallService {

    void showInfo();
}
