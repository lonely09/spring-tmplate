package com.smec.template.configuration;

import com.smec.template.util.MpaasSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;

public class MyAuditorAware  implements AuditorAware<String>{

    @Autowired
    private HttpServletRequest request;

    @Override
    public Optional<String> getCurrentAuditor() {
        // 获得token
        Map attributeMap = MpaasSession.getUserProfile().getAttributes();
        //获取工号
        String employeeId = (String) attributeMap.get("upn");
        if(employeeId!=null){
            return Optional.ofNullable(employeeId);
        }
        return Optional.of("");
    }
}
