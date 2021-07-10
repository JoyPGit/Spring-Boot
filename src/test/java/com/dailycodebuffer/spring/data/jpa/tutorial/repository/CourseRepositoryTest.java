package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class CourseRepositoryTest {

  @Autowired
  CourseRepository courseRepository;

  @Test
  public void findAllPagination() {
    Pageable firstRecordWithThreePages = PageRequest.of(0, 3);

    Pageable secondRecordWithTwoPages = PageRequest.of(1, 2);

    System.out.println(this.courseRepository.findAll());
    List<Course> courses =
      this.courseRepository.findAll(firstRecordWithThreePages).getContent();

    long totalElements =
      this.courseRepository.findAll(firstRecordWithThreePages)
        .getTotalElements();

    long totalPages =
      this.courseRepository.findAll(firstRecordWithThreePages).getTotalPages();

    System.out.println("courses pagination " + ": " + courses);
  }

  @Test
  public void findAllSorting() {
    Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));

    List<Course> list = (List<Course>) this.courseRepository.findAll(
        sortByTitle
      );
  }
}
