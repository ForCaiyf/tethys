package com.caiyf.tethys.message.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * zhenzi config
 *
 * @author caiyf
 * @date 2020-01-04
 */
@Data
@Component
@ConfigurationProperties(prefix = "zhenzi")
public class ZhenziConfig {

    private String apiUrl;
    private String appId;
    private String appSecret;

}
