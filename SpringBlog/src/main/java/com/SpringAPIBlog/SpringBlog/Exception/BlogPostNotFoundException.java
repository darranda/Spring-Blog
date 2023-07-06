package com.SpringAPIBlog.SpringBlog.Exception;

public class BlogPostNotFoundException extends Throwable {
    public BlogPostNotFoundException(Long id) {
        super ("Blog Post not found with id: " + id);
    }
}
