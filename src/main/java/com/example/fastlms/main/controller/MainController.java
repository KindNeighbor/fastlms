package com.example.fastlms.main.controller;

import com.example.fastlms.admin.dto.BannerDto;
import com.example.fastlms.admin.service.BannerService;
import com.example.fastlms.log.RequestUtils;
import com.example.fastlms.component.MailComponents;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@Controller
@Slf4j
public class MainController {

    private final MailComponents mailComponents;
    private final BannerService bannerService;

    @RequestMapping("/")
    public String index(Model model, HttpServletRequest request) {

        String userAgent = RequestUtils.getUserAgent(request);
        String clientIp = RequestUtils.getClientIp(request);

        log.info(userAgent);
        log.info(clientIp);

        List<BannerDto> bannerDtoList = bannerService.frontList();
        model.addAttribute("list",bannerDtoList);

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
