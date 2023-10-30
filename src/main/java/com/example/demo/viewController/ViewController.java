package com.example.demo.viewController;

import ch.qos.logback.core.net.server.ServerRunner;
import com.example.demo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

  @GetMapping("/link")
  //  입력받을 2개의 매개변수를 던져서 보이게 할 예정이니 Model에 담아줌
  public String method3(Model model) {
    model.addAttribute("param1", 3);
    model.addAttribute("param2", 8);
    return "link";
  }

  @GetMapping("/param")
//  입력 받을 2개의 매개변수를 던져서 보이게 할 예정이니 Model에 담아줌
  public String method4(@RequestParam Integer param1,
                        @RequestParam Integer param2,
                        Model model) {
    model.addAttribute("result", param1 + param2);
    return "param";
  }
}
