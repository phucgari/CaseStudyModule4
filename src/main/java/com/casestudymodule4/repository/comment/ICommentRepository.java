package com.casestudymodule4.repository.comment;

import com.casestudymodule4.model.home.rating.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long> {
}
