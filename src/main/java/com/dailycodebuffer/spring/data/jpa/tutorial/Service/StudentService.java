package com.dailycodebuffer.spring.data.jpa.tutorial.Service;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Guardian;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import com.dailycodebuffer.spring.data.jpa.tutorial.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Guard;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student getStudentDetailsByEmailId(String emailId){
        return this.studentRepository.findByEmail(emailId);
    }

    public Student createStudent(Student studentReqBody){
//        Guardian guardian = Guardian.builder()
//                .email(studentReqBody.getGuardianEmail())
//                .mobile(studentReqBody.getGuardianMobile())
//                .name(studentReqBody.getGuardianName())
//                .build();
//        studentReqBody.setGuardian(guardian);
        return this.studentRepository.save(studentReqBody);
    }

    public Student updateStudent(Long studentId,
                                 Student studentReqBody) throws Exception {
//        Guardian guardian = Guardian.builder()
//                .email(studentReqBody.getEmail())
//                .mobile(studentReqBody.getGuardianMobile())
//                .name(studentReqBody.getGuardianName())
//                .build();
        Optional<Student> studentEntityFromDB =
                this.studentRepository.findById(studentId);
        if(studentEntityFromDB.isPresent()){
            Student studentEntity =
                    this.studentRepository.getById(studentId);
            studentEntity.setEmail(studentReqBody.getEmail());
            studentEntity.setFirstName(studentReqBody.getFirstName());
            studentEntity.setLastName(studentReqBody.getLastName());
//            studentEntity.setGuardian(guardian);
            studentEntity.setGuardianEmail(studentReqBody.getGuardianEmail());
            studentEntity.setGuardianMobile(studentReqBody.getGuardianMobile());
            studentEntity.setGuardianName(studentReqBody.getGuardianName());
            return this.studentRepository.save(studentEntity);
        }
        else{
            throw new Exception("no student found with this id");
        }
    }

    public void deleteStudent(Long studentId){
        this.studentRepository.deleteById(studentId);
    }
}
