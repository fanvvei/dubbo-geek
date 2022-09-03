package org.vubbo.zhouyu.framework.protocol.http;

import org.apache.commons.io.IOUtils;
import org.vubbo.zhouyu.framework.entity.Invocation;
import org.vubbo.zhouyu.framework.register.LocalRegister;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author vizz
 * @since 2022/8/20 22:31
 */
public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp){
        try {
            //TODO：这一步看不懂的话去补Java基础，我现在就不是很懂
            //其实关于req和resp的读写流很重要，之前http导出excel也是用到了读写流，有空复习一下这方面的知识
            Invocation invocation = (Invocation) new ObjectInputStream(req.getInputStream()).readObject();

            //如何准确执行到这个impl呢？
            Class clazz = LocalRegister.get(invocation.getInterfaceName());
            Method method = clazz.getMethod(invocation.getMethodName(), invocation.getParamTypes());
            Object result = method.invoke(clazz.newInstance(), invocation.getParams());

            //利用一个工具类将字符串写到结果类里面去,这个String假设我暂时知道，
            // TODO 后续引入序列化工具来改进
            IOUtils.write((String) result,resp.getOutputStream());

        } catch (IOException | ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


        System.out.println("handler success!");
    }
}
