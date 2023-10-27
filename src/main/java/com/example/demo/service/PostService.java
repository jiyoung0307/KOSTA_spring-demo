package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
  @Autowired
  private PostRepository postRepository;
  public List<Post> getAllPosts() {
    return postRepository.selectAllPosts();
  }

  public Post setPost(Post post) {
    postRepository.insertPost(post);
    return post;
  }

  public Post updatePost(int postId, Post post) {
//    postRepository.selectPostById();
    postRepository.updatePost(post);
    return post;
  }

  public Post deletePost(int postId, Post post) {
    postRepository.deletePost(postId);
    return post;
  }
}
