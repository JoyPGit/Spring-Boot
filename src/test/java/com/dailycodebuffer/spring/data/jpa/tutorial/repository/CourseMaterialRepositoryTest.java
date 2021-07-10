package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.CourseMaterial;
import java.util.List;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@ToString(exclude = "course")
@SpringBootTest
public class CourseMaterialRepositoryTest {

  @Autowired
  CourseMaterialRespository courseMaterialRespository;

  @Test
  public void save() {
    Course course = Course.builder().courseTitle("DS-Algo").credit(6).build();

    CourseMaterial courseMaterial = CourseMaterial
      .builder()
      .url("www.google.com")
      .course(course)
      .build();

    this.courseMaterialRespository.save(courseMaterial);
    // if course is not save first,
    // constraint error
    // ->
  }

  @Test
  public void printAllCourseMaterials() {
    List<CourseMaterial> list = this.courseMaterialRespository.findAll();
    System.out.println("Course materials : " + list);
  }
}
