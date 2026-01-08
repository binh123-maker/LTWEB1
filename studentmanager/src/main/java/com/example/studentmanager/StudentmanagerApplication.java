package com.example.studentmanager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController // Thêm dòng này để đánh dấu đây là một Controller
@RequestMapping("/api") // Tất cả API sẽ bắt đầu bằng /api
public class StudentmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentmanagerApplication.class, args);
    }

    // Bài 1: Tạo Hello API
    // http://localhost:8080/api/hello
    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot API";
    }

    // Bài 2: API nhận tham số
    // http://localhost:8080/api/greet?name=Hieu
    @GetMapping("/greet")
    public String greet (@RequestParam String name) {
        return "xin chào" + name;
    }

    @GetMapping("/students/search")
    public String search(
        @RequestParam String keyword,
        @RequestParam(defaultValue = "1") int page) {
    return "keyword=" + keyword + ", page=" + page;
}


    // Bài 3: API với path variable
    @GetMapping("student/{id}")
    public String getStudent(@PathVariable int id) {
        return "Sinh viên Id" + id;
    }

    // Bài 4: Trả về 1 sinh viên (JSON Object)
    // http://localhost:8080/api/student
    @GetMapping("/student")
    public Student getStudent() {
        // Trả về một đối tượng Student duy nhất
        return new Student(1, "Nguyen Van A", 20);
    }

    // Bài 5: Trả về danh sách sinh viên (JSON Array)
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "Nguyen Van A", 20));
        list.add(new Student(2, "Tran Thi B", 21));
        list.add(new Student(3, "Le Van C", 22));
        
        return list;
    }
}