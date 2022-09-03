package org.vubbo.zhouyu.framework.protocol;

import org.vubbo.zhouyu.framework.entity.Invocation;
import org.vubbo.zhouyu.framework.register.URL;

/**
 * @author vizz
 * @since 2022/8/21 20:58
 */
public interface Protocol {
    void start(URL url);

    String send(URL url, Invocation invocation);
}
