package com.example;


import com.example.entity.Guide;
import com.example.entity.Student;
import com.example.reposiroty.GuideRepository;
import com.example.reposiroty.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Component
public class Bootstrap implements CommandLineRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GuideRepository guideRepository;


    @Override
    //@Transactional
    public void run(String... args) throws Exception {
        //createStudentsAndGides();

        //Student student = studentRepository.findById(3).get();
       // student.setName("some value");

        //Student student2 = studentRepository.findById(3).get();

        Student student1 = entityManager.find(Student.class, 3);
        Student student2 = entityManager.find(Student.class, 3);


        System.out.println("STOP");


    }

    private void createStudentsAndGides(){

        Student student = new Student();
        student.setRegistrationNumber("fist");
        student.setName("Ali");
        //student.setGuide(guide);

        Student student2 = new Student();
        student2.setRegistrationNumber("second");
        student2.setName("Baga");
        Student save = studentRepository.save(student);
        Student save1 = studentRepository.save(student2);
        Guide guide = new Guide();
        guide.setName("Gide1");
        guide.setSalary(500);
        guide.setBadge("Staff one");

        Guide guide2 = new Guide();
        guide2.setName("Gide1");
        guide2.setSalary(500);
        guide2.setBadge("Staff one");
        guide2.getStudents().add(student);

        Guide save2 = guideRepository.save(guide);
        Guide save3 = guideRepository.save(guide2);

        System.out.println("done");
    }
}
