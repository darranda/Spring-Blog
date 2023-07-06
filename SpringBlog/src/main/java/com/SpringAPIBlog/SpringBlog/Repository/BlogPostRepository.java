package com.SpringAPIBlog.SpringBlog.Repository;

import com.SpringAPIBlog.SpringBlog.Model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}
