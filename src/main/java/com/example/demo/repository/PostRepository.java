package com.example.demo.repository;

import com.example.demo.model.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostRepository {
  List<Post> selectAllPosts();

  Post selectPostById(int postId);

  void deletePost(int postId);

  int insertPost(Post post);

  void updatePost(Post post);
}
