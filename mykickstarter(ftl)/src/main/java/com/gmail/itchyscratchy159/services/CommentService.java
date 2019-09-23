package com.gmail.itchyscratchy159.services;

import com.gmail.itchyscratchy159.entities.Comment;
import com.gmail.itchyscratchy159.entities.User;
import com.gmail.itchyscratchy159.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public Iterable<Comment> findAll(String filter, Model model) {
        Iterable<Comment> comments;
        if ( filter != null && ! filter.isEmpty ( ) ) {
            comments = commentRepository.findByText ( filter );
        } else {
            comments = commentRepository.findAll ( );
        }
        model.addAttribute ( "comments", comments );
        model.addAttribute ( "filter", filter );
        return commentRepository.findAll ( );
    }

}
