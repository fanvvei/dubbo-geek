package org.vubbo.zhouyu.framework;

import org.vubbo.zhouyu.framework.register.URL;

import java.util.List;

/**
 * @author vizz
 * @since 2022/8/21 17:37
 */
public class LoadBalance {

    public static URL getFirst(List<URL> urls) {
        if (urls.size() >= 1) {
            return urls.get(0);
        } else {
            throw new RuntimeException("no provider");
        }
    }
}
