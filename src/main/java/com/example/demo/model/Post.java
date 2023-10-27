package com.example.demo.model;
// DO

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class Post {
  private int postid;
  private String title;
  private String body;
  private int likes;
}
