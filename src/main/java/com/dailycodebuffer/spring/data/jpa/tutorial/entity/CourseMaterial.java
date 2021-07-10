package com.dailycodebuffer.spring.data.jpa.tutorial.entity;

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
// table is created in snake case
public class CourseMaterial {

  @Id
  @SequenceGenerator(
    name = "course_material_sequence",
    sequenceName = "course_material_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "course_material_sequence"
  )
  private Long courseMaterialId;

  private String url;

  // this table will have an extra column named course_id, like a foreign key
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "course_id", referencedColumnName = "courseId")
  private Course course;
}
