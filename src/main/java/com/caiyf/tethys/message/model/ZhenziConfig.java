package com.caiyf.tethys.message.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * zhenzi config
 *
 * @author caiyf
 * @date 2020-01-04
 */
@Data
@ConfigurationProperties("zhenzi")
public class ZhenziConfig {

    private String apiUrl;
    private String appId;
    private String appSecret;

}
