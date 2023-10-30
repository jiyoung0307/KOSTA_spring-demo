package com.example.demo.viewController;

import com.example.demo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {
  @GetMapping("/text")
  public String method1(Model model) {
//    여기에서 String은 html로 인식(화면단)
//    Model을 통해서 html로 전달(Spring)
    model.addAttribute("data", "Hello, world!");
    return "text";
  }

  @GetMapping("/object")
  public String method2(Model model) {
    Student student = new Student();
    student.setName("testName");
    model.addAttribute("student", student);
    return "obj";
  }
}
