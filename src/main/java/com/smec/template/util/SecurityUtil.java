package com.smec.template.util;

import com.smec.pri.client.security.AuthUserDetail;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    public static AuthUserDetail getUserDetail() {

        SecurityContext context = SecurityContextHolder.getContext();
        return (AuthUserDetail) context.getAuthentication().getPrincipal();
    }
}
