package com.example.demo.model;

import lombok.Data;

@Data
//@AllArgsConstructor
public class Post {
  private int postId;
  private String title;
  private String body;
  private int likes;
}