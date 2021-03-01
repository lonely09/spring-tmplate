package com.smec.template.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.http.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
//获取token 作用于需要token验证的测试方法，只允许测试用例所需token的时候使用
public class Token {
    public static Object getToken(String cuser) {

        String user = String.format("%s\\%s","smec-cn.com",cuser);

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("https://adfs.smec-cn.com/adfs/oauth2/token");
        CloseableHttpResponse response = null;
        try {
            httpPost.addHeader("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
            httpPost.addHeader("x-ms-client-application", user);

            List<BasicNameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("grant_type", "client_credentials"));
            params.add(new BasicNameValuePair("client_id", "32450b04-d02b-49a1-aebe-0a32be0d78b8"));
            params.add(new BasicNameValuePair("client_secret", "ZHiN1XMUVXgZzc61xF_MwbRzlbA9owkrF0tCtKaP"));
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, StandardCharsets.UTF_8);
            httpPost.setEntity(formEntity);

            response = httpClient.execute(httpPost);
            org.apache.http.HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                String responseStr = EntityUtils.toString(responseEntity, StandardCharsets.UTF_8);
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonNode=mapper.readTree(responseStr);
                return jsonNode.get("access_token");
            }
        } catch (IOException | ParseException e) {

        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
