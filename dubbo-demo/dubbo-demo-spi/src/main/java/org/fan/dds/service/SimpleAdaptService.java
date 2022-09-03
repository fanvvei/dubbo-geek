package org.fan.dds.service;

import org.apache.dubbo.common.URL;

/**
 * @author vizz
 * @since 2022/8/30 17:04
 */
public class SimpleAdaptService implements SimpleAdapt{
    @Override
    public String echo(URL url, String s) {
        System.out.println("ok here is simple adapt service");
        return "ok";
    }
}
