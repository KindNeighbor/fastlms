package com.example.fastlms.main.controller;

import com.example.fastlms.admin.log.RequestUtils;
import com.example.fastlms.component.MailComponents;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RequiredArgsConstructor
@Controller
@Slf4j
public class MainController {

    private final MailComponents mailComponents;

    @RequestMapping("/")
    public String index(HttpServletRequest request) {

        String userAgent = RequestUtils.getUserAgent(request);
        String clientIp = RequestUtils.getClientIp(request);

        log.info(userAgent);
        log.info(clientIp);

        return "index";
    }

//    @RequestMapping("/hello")
//    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//        response.setContentType("text/html;charset=UTF-8");
//
//        PrintWriter printWriter = response.getWriter();
//
//        String msg = "<html>" +
//                "<head>" +
//                "<meta charset=\"UTF-8\">" +
//                "</head>" +
//                "<body>" +
//                "<p>hello</p>" +
//                "<p>fastlms website!!!</p>" +
//                "<p> 안녕하세요!!!! ====> </p>" +
//                "</body>" +
//                "</html>";
//
//        printWriter.write(msg);
//        printWriter.close();
//    }

    @RequestMapping("/error/denied")
    public String errorDenied() {
        return "error/denied";
    }
}
