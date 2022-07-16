package com.example;

import com.example.entity.Student;
import com.example.reposiroty.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class ApplicationTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    @Transactional
    void test(){

        Student student = new Student();
        Student savedStudent = studentRepository.save(student);
        assertEquals(student, savedStudent);

    }

}