package org.vubbo.zhouyu.framework.protocol.http;

import org.apache.commons.io.IOUtils;
import org.vubbo.zhouyu.framework.entity.Invocation;
import org.vubbo.zhouyu.framework.protocol.RpcException;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author vizz
 * @since 2022/8/20 23:24
 */
public class HttpClient {

    public String send(String hostname, Integer port, Invocation invocation) {

        //TODO：读取用户的配置，可以集成别的httpClient包
        try {
            URL url = new URL("http", hostname, port, "/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);

            ObjectOutputStream oos = new ObjectOutputStream(httpURLConnection.getOutputStream());

            oos.writeObject(invocation);
            oos.flush();
            oos.close();

            //TODO 这里也是写死的，如果可以多样化那就后面拓展吧
            InputStream is = httpURLConnection.getInputStream();
            String result = IOUtils.toString(is);
            return result;
        } catch (Exception e) {
            throw new RpcException();
        }
    }
}
