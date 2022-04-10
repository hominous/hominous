package com.hominous.familiar.common.security;

import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

@NoArgsConstructor
public class SecurityUtil {

    private static final Logger logger = LoggerFactory.getLogger(SecurityUtil.class);

    public static Optional<String> getCurrentMemberId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication == null){
            logger.debug("Security Context에 인증 정보가 없습니다.");
            return Optional.empty();
        }

        String memberId = null;

        if(authentication.getPrincipal() instanceof UserDetails){
            UserDetails principal = (UserDetails) authentication.getPrincipal();
            memberId = principal.getUsername();
        } else if (authentication.getPrincipal() instanceof String) {
            memberId = (String) authentication.getPrincipal();
        }
        return Optional.ofNullable(memberId);
    }

}
