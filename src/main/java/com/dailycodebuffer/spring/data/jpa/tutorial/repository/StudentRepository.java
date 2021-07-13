package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
  List<Student> findByFirstName(String firstName);

  // jpql query, based on Entity, not on tables,
  // so Student and not tbl_student is used
  @Query("Select s from Student s where s.email = ?1")
  Student findByEmail(String emailId);

  // native SQL query
  @Query(
    value = "Select * from tbl_student s where " +
    "s.email_address = :emailAddr",
    nativeQuery = true
  )
  Student findDetailsByEmailNative(@Param("emailAddr") String emailId);

  // any put/post/delete needs to be committed,
  // so @Transactional
  @Modifying
  @Transactional
  @Query(
    value = "update tbl_student set " +
    "firstName = :firstName s" +
    ".email_address = :emailAddr",
    nativeQuery = true
  )
  int update(@Param("firstName") String firstName, @Param("emailAddr") String emailAddr);
}
