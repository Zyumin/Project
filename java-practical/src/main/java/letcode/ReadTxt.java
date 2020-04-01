package letcode;

import org.apache.commons.lang3.StringUtils;

import java.io.*;

/**
 * 转化权限系统代码
 */
public class ReadTxt {


    public static void main(String args[]) throws IOException {
        String path = "/Users/zhengyumin/Desktop/1.txt";
        FileInputStream fin = new FileInputStream(path);
        InputStreamReader reader = new InputStreamReader(fin);
        BufferedReader buffReader = new BufferedReader(reader);

        String result = "insert into BossErpUser value values";
        String strTmp = "";
        boolean flag = true;
        while ((strTmp = buffReader.readLine()) != null) {
            if(!flag){

            }
            String f = String.format("('%s'),", StringUtils.replaceAll(strTmp, "\t", "','"));
            result += f;

        }

        System.out.println(result);
        buffReader.close();
    }
}