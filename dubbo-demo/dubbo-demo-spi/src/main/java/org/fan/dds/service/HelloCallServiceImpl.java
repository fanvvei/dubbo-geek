package org.fan.dds.service;

/**
 * @author vizz
 * @since 2022/8/1 14:12
 */
public class HelloCallServiceImpl implements CallService{
    @Override
    public void showInfo() {
        System.out.println("hello call");
    }
}
