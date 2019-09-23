package com.gmail.itchyscratchy159.repositories;

import com.gmail.itchyscratchy159.entities.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findByText(String text);

}
