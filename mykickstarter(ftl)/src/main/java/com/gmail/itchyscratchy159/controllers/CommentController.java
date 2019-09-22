package com.gmail.itchyscratchy159.controllers;

import com.gmail.itchyscratchy159.entities.Comment;
import com.gmail.itchyscratchy159.entities.User;
import com.gmail.itchyscratchy159.repositories.CommentRepository;
import com.gmail.itchyscratchy159.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRepository commentRepository;



    @GetMapping("/home")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        commentService.findAll(filter, model);
        return "home";
    }

    @PostMapping("/home")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam("file") MultipartFile file,
            @RequestParam String text, Model model) throws IOException {
        commentService.saveComment(user,text , file , model);
        return "home";
    }


}
