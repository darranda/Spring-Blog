package com.SpringAPIBlog.SpringBlog.Service;

import com.SpringAPIBlog.SpringBlog.Exception.BlogPostNotFoundException;
import com.SpringAPIBlog.SpringBlog.Model.BlogPost;
import com.SpringAPIBlog.SpringBlog.Repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {
    private final BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostService(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    //get list of all blog posts
    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

// create new blog post
    public BlogPost createBlogPost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    // get blog post by id
    public Optional <BlogPost> getBlogPostById (Long id) {
        return blogPostRepository.findById(id);
    }

    //update blog post by id
    public BlogPost updateBlogPost(Long id, BlogPost updatedBlogPost) throws BlogPostNotFoundException {
        Optional<BlogPost> existingBlogPost = blogPostRepository.findById(id);
        if (existingBlogPost.isPresent()) {
            BlogPost blogPost = existingBlogPost.get();
            blogPost.setTitle(updatedBlogPost.getTitle());
            blogPost.setContent(updatedBlogPost.getContent());
            blogPost.setAuthor(updatedBlogPost.getAuthor());
            return blogPostRepository.save(blogPost);
        } else {
        throw new BlogPostNotFoundException(id);
    }
    }
//delete blog post
    public void deleteBlogPost(Long id) {
        blogPostRepository.deleteById(id);
    }
}

