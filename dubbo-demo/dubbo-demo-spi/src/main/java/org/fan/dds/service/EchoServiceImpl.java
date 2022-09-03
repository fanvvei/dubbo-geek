package org.fan.dds.service;

/**
 * @author vizz
 * @since 2022/8/24 10:58
 */
public class EchoServiceImpl implements EchoService{
    @Override
    public String say() {
        System.out.println("echo");
        return "echo hello";
    }
}
