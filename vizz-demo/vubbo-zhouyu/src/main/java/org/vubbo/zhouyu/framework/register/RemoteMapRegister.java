package org.vubbo.zhouyu.framework.register;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author vizz
 * @since 2022/8/21 17:25
 */
public class RemoteMapRegister {

    private static Map<String, List<URL>> REGISTER = new HashMap<>();

    public static void regis(String interfaceName, URL url) {
        List<URL> urls = REGISTER.get(interfaceName);
        if (urls == null) {
            urls = new ArrayList<>();
        }
        urls.add(url);
        REGISTER.put(interfaceName, urls);
        System.out.println("register success,and the interfaceName is   " + interfaceName +
                "   the url is" + url.toString());
        saveFile();
    }

    public static List<URL> get(String interfaceName) {
        System.out.println("finding interface name by " + interfaceName);
        REGISTER = getFile();
        List<URL> urls = REGISTER.get(interfaceName);
        return urls;
    }

    //这个注册中心必须消费者和提供者都访问到、都一致的数据，于是我采用文件的方式来写
    public static void saveFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("/temp.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(REGISTER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, List<URL>> getFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/temp.txt"));
            return (Map<String, List<URL>>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
