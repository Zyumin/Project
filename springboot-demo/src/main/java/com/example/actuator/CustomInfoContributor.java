package com.example.actuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义info endPoint信息
 *
 * @author zhengyumin
 * @create 2019-01-15 6:41 PM
 */
@Component
public class CustomInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {

        Map<String, String> userDetails = new HashMap<>();
        userDetails.put("customInfo","hello");
        builder.withDetail("users", userDetails);
    }
}
