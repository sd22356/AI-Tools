package com.sd22356.aidemo2.utils;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

public class AIUtils {

    //设置APPID/AK/SK
    public static final String APP_ID = "25481455";
    public static final String API_KEY = "i0zaiWOKMZoDoWRHwaBAmGVp";
    public static final String SECRET_KEY = "jbynRTvPAVWx0OpmibXdQ1jLmOKnU6El";

    public static String PicToWords(MultipartFile file) throws IOException {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
//        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
//        String path = "F:/JAVA_Something/AI-Demo/test.jpg";

        JSONObject res = client.basicGeneral(file.getBytes(), new HashMap<String, String>());
        JSONArray words_result = res.getJSONArray("words_result");
        String result = "";
        for (int i = 0; i < words_result.length(); i++) {
            JSONObject jsonObject = words_result.getJSONObject(i);
            Object words = jsonObject.get("words");
            String s = (String) words;
            result += s + "";

        }
        return result;

    }
}
