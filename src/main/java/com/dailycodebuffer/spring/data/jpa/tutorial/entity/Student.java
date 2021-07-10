package com.dailycodebuffer.spring.data.jpa.tutorial.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Data // of lombok
@AllArgsConstructor
@NoArgsConstructor
@Builder // adds builder pattern
//@Table(
//  name = "tbl_student",
//  // how does this work?
//  uniqueConstraints = @UniqueConstraint(
//    name = "emailid_unique",
//    columnNames = "email_address"
//  )
//)
public class Student {

  @Id
  // how does this work?
  @SequenceGenerator(
    name = "student_sequence",
    sequenceName = "student_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "student_sequence"
  )
  //    @GeneratedValue(strategy = GenerationType.AUTO)
  private long studentId;

  private String firstName;
  private String lastName;

  @Column(name = "email_address", nullable = false)
  private String email;

  private String guardianName;
  private String guardianEmail;
  // how to add constraints? like must start
  // with 9, 8, or 7?
  private String guardianMobile;

//  @Embedded
//  private Guardian guardian;
}
