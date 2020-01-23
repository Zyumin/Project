package net;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2019-09-30 5:12 PM
 */
public class URLDemo {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.baidu.com");

        URLConnection c = url.openConnection();

        InputStream in = c.getInputStream();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = in.read(buffer)) != -1)
        {
            output.write(buffer, 0, len);
        }
        System.err.println(new String(output.toByteArray()));


    }
}
