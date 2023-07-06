# Spring-Blog

The application will start running on http://localhost:8080.

Endpoints:

Get all blog posts: GET /posts

-Returns a list of all blog posts.

Get a specific blog post: GET /posts/{id}

-Returns the blog post with the specified ID.

Create a new blog post: POST /posts

-Creates a new blog post. The request body should contain the title, content, and author of the blog post.

Update an existing blog post: PUT /posts/{id}

-Updates the blog post with the specified ID. The request body should contain the new title, content, and/or author.

Delete a blog post: DELETE /posts/{id}

-Deletes the blog post with the specified ID.
