package com.example.fastlms.configuration;

import com.example.fastlms.admin.log.RequestUtils;
import com.example.fastlms.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class UserAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private MemberService memberService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        boolean result = memberService.log(authentication.getName(), LocalDateTime.now(), RequestUtils.getUserAgent(request), RequestUtils.getClientIp(request));

        super.onAuthenticationSuccess(request, response, authentication);
    }


}
