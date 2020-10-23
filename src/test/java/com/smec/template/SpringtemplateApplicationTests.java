package com.smec.template;

import com.alibaba.druid.filter.config.ConfigTools;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringtemplateApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        //密码明文
        String password = "fusion3030";

        System.out.println("密码[ "+password+" ]的加密信息如下：\n");

        String [] keyPair = ConfigTools.genKeyPair(512);
        //私钥
        String privateKey = keyPair[0];
        //公钥
        String publicKey = keyPair[1];
        //用私钥加密后的密文
        password = ConfigTools.encrypt(privateKey, password);

        System.out.println("privateKey:"+privateKey);
        System.out.println("publicKey:"+publicKey);
        System.out.println("password:"+password);
        String decryptPassword=ConfigTools.decrypt(publicKey, password);
        System.out.println("decryptPassword："+decryptPassword);
    }

}
