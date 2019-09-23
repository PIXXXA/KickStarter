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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentService commentService;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/home")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        commentService.findAll ( filter, model );
        return "home";
    }

    @PostMapping("/home")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam("file") MultipartFile file,
            @Valid Comment comment,
            BindingResult bindingResult,
            Model model
    ) throws IOException {
        comment.setAuthor ( user );

        if ( bindingResult.hasErrors ( ) ) {
            Map<String, String> errorsMap = ControllersUtils.getErrors ( bindingResult );
            model.mergeAttributes ( errorsMap );
            model.addAttribute ( "comment", comment );
        } else {
            if ( file != null && ! file.getOriginalFilename ( ).isEmpty ( ) ) {
                File uploadDir = new File ( uploadPath );

                if ( ! uploadDir.exists ( ) ) {
                    uploadDir.mkdir ( );
                }

                String uuidFile = UUID.randomUUID ( ).toString ( );
                String resultFilename = uuidFile + "." + file.getOriginalFilename ( );

                file.transferTo ( new File ( uploadPath + "/" + resultFilename ) );

                comment.setFilename ( resultFilename );
            }

            model.addAttribute ( "comments", null );
            commentRepository.save ( comment );
        }
        Iterable<Comment> comments = commentRepository.findAll ( );
        model.addAttribute ( "comments", comments );
        return "home";
    }
}
