package org.vubbo.zhouyu.provider;

import org.vubbo.zhouyu.api.HelloService;

/**
 * @author vizz
 * @since 2022/8/20 22:15
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String say(String name) {
        System.out.println("hello " + name);
        return name;
    }
}
