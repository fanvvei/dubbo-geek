package org.vubbo.zhouyu.framework.register;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vizz
 * @since 2022/8/20 22:53
 */
public class LocalRegister {

    private static Map<String, Class> providerCache = new HashMap<>();

    public static void regis(String interfaceName, Class implClazz) {
        providerCache.put(interfaceName, implClazz);
    }

    public static Class get(String interfaceName) {
        return providerCache.get(interfaceName);
    }
}
