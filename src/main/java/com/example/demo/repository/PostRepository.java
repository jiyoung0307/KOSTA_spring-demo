package com.example.demo.repository;

import com.example.demo.model.Post;

import java.util.List;

// CRUD
// 구현체이므로 어노테이션 달지 않음
public interface PostRepository {
  List<Post> selectAllPosts();

  Post selectPostById(int postId);

  void deletePost(int postId);

  int insertPost(Post post);

  void updatePost(Post post);
}
