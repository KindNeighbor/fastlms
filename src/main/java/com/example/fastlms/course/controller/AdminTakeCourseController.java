package com.example.fastlms.course.controller;

import com.example.fastlms.course.dto.CourseDto;
import com.example.fastlms.course.dto.TakeCourseDto;
import com.example.fastlms.course.model.ServiceResult;
import com.example.fastlms.course.model.TakeCourseParam;
import com.example.fastlms.course.service.CourseService;
import com.example.fastlms.course.service.TakeCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminTakeCourseController extends BaseController {

    private final TakeCourseService takeCourseService;
    private final CourseService courseService;

    @GetMapping("/admin/takecourse/list.do")
    public String list(Model model, TakeCourseParam parameter) {

        parameter.init();
        List<TakeCourseDto> takeCourseList = takeCourseService.list(parameter);

        long totalCount = 0;

        if (!CollectionUtils.isEmpty(takeCourseList)) {
            totalCount = takeCourseList.get(0).getTotalCount();
        }

        String queryString = parameter.getQueryString();
        String pagerHtml = getPagerHtml(totalCount, parameter.getPageSize(), parameter.getPageIndex(), queryString);

        model.addAttribute("list", takeCourseList);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("pager", pagerHtml);

        List<CourseDto> courseList = courseService.listAll();
        model.addAttribute("courseList", courseList);

        return "admin/takecourse/list";
    }

    @PostMapping("/admin/takecourse/status.do")
    public String status(Model model, TakeCourseParam parameter) {

        parameter.init();
        ServiceResult result = takeCourseService.updateStatus(parameter.getId(), parameter.getStatus());
        if (!result.isResult()) {
            model.addAttribute("message", result.getMessage());
            return "common/error";
        }

        return "redirect:/admin/takecourse/list.do";
    }
}
