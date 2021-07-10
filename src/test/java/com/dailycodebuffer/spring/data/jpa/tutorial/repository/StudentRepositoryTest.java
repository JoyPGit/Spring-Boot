package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Guardian;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

class StudentRepositoryTest {

  @Autowired
  private StudentRepository studentRepository;

  @Test
  public void saveStudent() {
    Student studentObject = Student
      .builder()
      .email("davy_jones2@gmail.com")
      .firstName("davy")
      .lastName("jones")
      .guardianEmail("nikhil1@gmail" + ".com")
      .guardianName("nikhil1")
      .guardianMobile("9999999999")
      .build();

    studentRepository.save(studentObject);
  }

//  @Test
//  public void saveStudentWithGuardian() {
//    Guardian guardian = Guardian
//      .builder()
//      .email("guardian1@gmail" + ".com")
//      .name("guardian1")
//      .mobile("9876543210")
//      .build();
//
//    Student student = Student
//      .builder()
//      .email("davy_jones2@gmail.com")
//      .firstName("davy")
//      .lastName("jones")
//      .guardian(guardian)
//      .build();
//
//    studentRepository.save(student);
//  }

  @Test
  public void printAllStudents() {
    List<Student> studentList = this.studentRepository.findAll();

    System.out.println("list " + studentList);
  }

  @Test
  public void printStudentByFirstName() {
    List<Student> studentList = this.studentRepository.findByFirstName("davy");
    System.out.println(studentList);
  }

  @Test
  public void printStudentByEmail() {
    Student student =
      this.studentRepository.findByEmail("davy_jones_1@gmail.com");
    System.out.println(student);
  }

  @Test
  public void printDetailsByEmail() {
    Student student =
      this.studentRepository.findDetailsByEmailNative("davy_jones_1@gmail.com");
    System.out.println(student);
  }
}
