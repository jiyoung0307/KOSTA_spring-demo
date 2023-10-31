package com.example.demo.apiController;

import com.example.demo.model.Post;
import com.example.demo.model.PostDTO;
import com.example.demo.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

  private PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }
  //@Autowired
//    public void setPostService(PostService postService) {
//        this.postService = postService;
//    }

  @GetMapping("/posts")
  public List<Post> viewAllPosts() {
    List<Post> allPosts = postService.getAllPosts();
    System.out.println(allPosts);
    return allPosts;
  }

  @PostMapping("/posts")
  public Post registPost(@RequestBody Post post){
    System.out.println("before == > " + post);
    postService.setPost(post);
    System.out.println("after == > " +post);
    return post;
  }

  @PutMapping("/posts/{postId}")
  public String updatePost(@PathVariable("postId") int postId,
                           @RequestBody PostDTO postDTO){
    System.out.println("before == > " + postDTO);
    postService.updatePost(postId, postDTO);
    System.out.println("after == > " +postDTO);
    return "update 완료";
  }

  @GetMapping("/posts/{postId}")
  public Post viewPostById(@PathVariable("postId") int postId){
    return postService.getPostById(postId);
  }

  @DeleteMapping("/posts/{postId}")
  public void removePost(@PathVariable int postId){
    postService.removePost(postId);
  }
}
