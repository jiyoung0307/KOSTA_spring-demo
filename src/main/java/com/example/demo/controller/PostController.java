package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
  //  2. 필드 주입
//  @Autowired
//  private final PostService postService;
  private PostService postService;

  //  1. 생성자 주입
//  @Autowired
  public PostController(PostService postService) {
    this.postService = postService;
  }

  //  3. setter주입
//  @Autowired
//  public void setPostService(PostService postService) {
//    this.postService = postService;
//  }

  @GetMapping("/posts")
  public List<Post> viewAllPosts() {
    List<Post> allPosts = postService.getAllPosts();
    System.out.println(allPosts);
    return allPosts;
  }

  @PostMapping("/posts")
  public Post registPost(@RequestBody Post post) {
    System.out.println("before ==> " + post);
    postService.setPost(post);
    System.out.println("after ==> " + post);
    return post;
  }

  @PutMapping("/posts/{postId}")
  public Post updatePost(@PathVariable("postId") int postId,
                         @RequestBody Post post) {
    System.out.println("update before ==> " + post);
    postService.updatePost(postId, post);
    System.out.println("update after ==> " + post);
    return post;
  }

  @GetMapping("/posts/delete/{postId}")
  public Post deletePost(@RequestParam("postId") int postId,
                         @RequestBody Post post) {
    System.out.println("delete before ==> " + post);
    postService.deletePost(postId, post);
    System.out.println("delete after ==> " + post);
    return post;
  }
}
