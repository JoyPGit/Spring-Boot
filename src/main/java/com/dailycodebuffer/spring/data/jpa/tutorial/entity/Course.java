package com.dailycodebuffer.spring.data.jpa.tutorial.entity;

import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

  @Id
  @SequenceGenerator(
    name = "course_sequence",
    sequenceName = "course_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "course_sequence"
  )
  private Long courseId;

  private String courseTitle;
  private Integer credit;

  // this says that one to one mapping is defined by the course attribute in CourseMaterial class
  @OneToOne(mappedBy = "course")
  private CourseMaterial courseMaterial;

  // course will have teacher id as a foreign key, so use joincolumn here
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(
    // custom col name
    name = "teacher_id",
    // actual col name of teacher table
    referencedColumnName = "teacherId"
  )
  private Teacher teacher;

  // think in terms of objects, a new table will be created and the courseId of this
  // course obj will be stored in a column and the studentId of all students in the
  // list will be stored as entries in another column
  // (corresponding to the courseId, multiple entries for the same courseId and vice versa)
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
    name = "StudentCourseMapping",
    joinColumns = @JoinColumn(
      name = "course_id",
      referencedColumnName = "courseId"
    ),
    inverseJoinColumns = @JoinColumn(
      name = "student_id",
      referencedColumnName = "studentId"
    )
  )
  public List<Student> students;
}
