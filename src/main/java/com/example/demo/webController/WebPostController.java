package com.example.demo.webController;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class WebPostController {
    private final PostService postService;

    @Autowired
    public WebPostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String getAllPosts(Model model) {
        List<Post> allPosts = postService.getAllPosts();
        model.addAttribute("posts", allPosts);
        return "post/postList";
    }

    @GetMapping("/addPost")
    public String addPost() {
        return "post/postForm";
    }

    @PostMapping("/addPost")
    public String addPost(@ModelAttribute Post post) {
        postService.setPost(post);
        return "redirect:/posts";
    }

    @GetMapping("/postInfo/{postId}")
    public String getPostInfo(@PathVariable int postId,
                              Model model) {
        Post post = postService.getPostById(postId);
        model.addAttribute("post", post);
        return "post/postInfo";
    }

    @GetMapping("/updatePost/{postId}")
    public String updatePost(@PathVariable int postId,
                             Model model) {
        Post post = postService.getPostById(postId);
        model.addAttribute("post", post);
        return "post/postUpdateForm";
    }



    @GetMapping("/deletePost/{postId}")
    public String deletePost(@PathVariable int postId) {
        postService.removePost(postId);
        return "redirect:/posts";
    }
}