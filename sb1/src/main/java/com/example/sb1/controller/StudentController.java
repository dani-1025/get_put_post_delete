package com.example.sb1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sb1.model.Student;
import com.example.sb1.repository.StudentRepository;

@RestController
@RequestMapping("/api")

public class StudentController {

     @Autowired
    StudentRepository studentRepository;

   @GetMapping("/show_all")
   public List<Student> getAllStudents(){
    return (List<Student>) studentRepository.findAll();
   }

    @PostMapping("/create")
   public ResponseEntity<Student> createToutorial(@RequestBody Student student){
    Student _student = studentRepository
        .save(new Student(student.getId(),student.getName(),student.getDept()));
        return new ResponseEntity<Student>(_student, HttpStatus.CREATED);
   }
   
   @DeleteMapping("/delete_all")
   public ResponseEntity<HttpStatus> deleteAllStudent(){
        studentRepository.deleteAll();
        return new ResponseEntity<> (HttpStatus.NOT_FOUND);
   }

   @PutMapping("/insert/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id,@RequestBody Student student){
        Optional<Student> __student = studentRepository.findById(id);
        if(__student.isPresent()){
            Student _student = __student.get();
            _student.setId(student.getId());
            _student.setName(student.getName());
            _student.setDept(student.getDept());
            
            return new ResponseEntity<Student>(studentRepository.save(_student), HttpStatus.OK);
        }
        else{
             return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        }
   }

    
}
