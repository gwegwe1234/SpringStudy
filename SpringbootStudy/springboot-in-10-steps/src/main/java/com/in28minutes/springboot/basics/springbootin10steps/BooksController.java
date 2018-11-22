package com.in28minutes.springboot.basics.springbootin10steps;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController 가 어떻게 작동하는가?
 * 1. @SpringBootApplication 에서 자동으로 @RestController 찾아서 빈등록하고 관리한다.
 */
@RestController
public class BooksController {
  @GetMapping("/books")
  public List<Book> getAllBooks() {
    return Arrays.asList(new Book(1l,"Mastering Spirngsdf", "Gwangtae"));
  }
}
