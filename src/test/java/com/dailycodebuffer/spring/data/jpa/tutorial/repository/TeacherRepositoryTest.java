package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Teacher;
import com.sun.xml.bind.v2.runtime.reflect.Lister;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeacherRepositoryTest {

  private TeacherRepository teacherRepository;

  @Test
  public void saveTeacher() {
    Course course1 = Course.builder().courseTitle("DBA").credit(5).build();

    Course course2 = Course.builder().courseTitle("Sys-DBA").credit(6).build();

    List<Course> courseList = new ArrayList<>();
    courseList.add(course1);
    courseList.add(course2);

    Teacher teacher = Teacher
      .builder()
      .firstName("Qutub")
      .lastName("Khan")
      .courses(new ArrayList<>(courseList))
      .build();

    teacherRepository.save(teacher);
  }
}
