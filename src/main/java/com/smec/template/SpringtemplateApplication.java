package com.smec.template;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.smec.pri.client.EnableSmecWebAuthClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@EnableSmecWebAuthClient
@EnableApolloConfig
public class SpringtemplateApplication {
    private static final Logger LOG = LoggerFactory.getLogger(SpringtemplateApplication.class);
    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(SpringtemplateApplication.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        LOG.info("\n----------------------------------------------------------\n\t" +
                "Application SpringTemplateService is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + "/\n\t" +
                "External: \thttp://" + ip + ":" + port + "/\n\t" +
                "swagger-ui: \t\thttp://" + ip + ":" + port + "/swagger-ui.html\n" +
                "----------------------------------------------------------");
    }

}
