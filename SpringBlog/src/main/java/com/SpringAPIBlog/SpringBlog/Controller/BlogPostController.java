package com.SpringAPIBlog.SpringBlog.Controller;

import com.SpringAPIBlog.SpringBlog.Exception.BlogPostNotFoundException;
import com.SpringAPIBlog.SpringBlog.Model.BlogPost;
import com.SpringAPIBlog.SpringBlog.Service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class BlogPostController {
    private final BlogPostService blogPostService;

    @Autowired
    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<BlogPost>> getAllBlogPosts() {
        List<BlogPost> blogPosts = blogPostService.getAllBlogPosts();
        return ResponseEntity.ok(blogPosts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<BlogPost>> getBlogPostById(@PathVariable("id") Long id) {
        Optional<BlogPost> blogPost = blogPostService.getBlogPostById(id);
        if (blogPost != null) {
            return ResponseEntity.ok(blogPost);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPost blogPost) {
        BlogPost createdBlogPost = blogPostService.createBlogPost(blogPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBlogPost);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Long id, @RequestBody BlogPost updatedBlogPost) throws BlogPostNotFoundException {
        BlogPost updatedPost = blogPostService.updateBlogPost(id, updatedBlogPost);
        if (updatedPost != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedPost);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable Long id) {
        blogPostService.deleteBlogPost(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
