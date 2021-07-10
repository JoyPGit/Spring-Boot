package com.dailycodebuffer.spring.data.jpa.tutorial.Controller;

import com.dailycodebuffer.spring.data.jpa.tutorial.Service.StudentService;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/{emailId}")
    public ResponseEntity<Student> getStudentDetails(@PathVariable String emailId){
        return ResponseEntity.ok().body
                (this.studentService.getStudentDetailsByEmailId(emailId));
    }

    @PostMapping("/create")
    public ResponseEntity createStudent(@RequestBody Student student) {
        return ResponseEntity.ok().body(this.studentService.createStudent(student));
    }

    @PutMapping("/{studentId}")
    public ResponseEntity updateStudent(@PathVariable Long studentId,
                                        @RequestBody Student studentReqBody) throws Exception {
        return ResponseEntity.ok().body(this.studentService.updateStudent(studentId, studentReqBody));
    }

    @DeleteMapping("/delete/{studentId}")
    public void createStudent(@PathVariable Long studentId) {
        this.studentService.deleteStudent(studentId);
        ResponseEntity.ok();
    }
}
