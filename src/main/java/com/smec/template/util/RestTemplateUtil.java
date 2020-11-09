package com.smec.template.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Copyright: Shanghai Smec Company.All rights reserved.
 * @Description:
 * @author: wenbo.liao
 * @since: 2020/10/17 12:20
 * @history: 1.2020/10/17 created by wenbo.liao
 */

@Component
public class RestTemplateUtil {
    private final RestTemplate restTemplate;
    private final HttpHeaders requestHeaders;

    public RestTemplateUtil(@Qualifier("tokenRestTemplate") RestTemplate restTemplate, HttpHeaders requestHeaders) {
        this.restTemplate = restTemplate;
        this.requestHeaders = requestHeaders;
    }

    /**
     * post请求
     *
     * @param url
     * @param params
     * @return
     */
    public String postJsonTemplate(String url, Object params) {
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity(params, requestHeaders);
        String result = restTemplate.postForObject(url, requestEntity, String.class);
        return result;
    }
}
