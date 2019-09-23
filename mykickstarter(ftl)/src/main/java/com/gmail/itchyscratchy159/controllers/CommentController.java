package com.gmail.itchyscratchy159.controllers;

import com.gmail.itchyscratchy159.entities.Company;
import com.gmail.itchyscratchy159.entities.User;
import com.gmail.itchyscratchy159.services.CommentService;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/home")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        commentService.findAll ( filter, model );
        return "home";
    }

    @PostMapping("/home")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam("file") MultipartFile file,
            @Valid Company company,
            BindingResult bindingResult,
            Model model) throws IOException {
        company.setAuthor ( user );
        if ( bindingResult.hasErrors () ){
            Map<String, String> errorsMap = ControllersUtils.getErrors( bindingResult );
            model.mergeAttributes ( errorsMap );
        }else {
            commentService.saveComment ( user, message, file, model );
        }
        return "home";
    }
}
