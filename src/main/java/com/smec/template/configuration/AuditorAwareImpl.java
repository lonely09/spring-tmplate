package com.smec.template.configuration;

import com.google.common.base.Splitter;
import com.smec.template.util.SecurityUtil;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;
public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        String upn = (String) SecurityUtil.getUserDetail()
                .getAdfsInfo().get("upn");

        return Optional.ofNullable(Splitter.on("@").splitToList(upn)
                .get(0));
    }
}
