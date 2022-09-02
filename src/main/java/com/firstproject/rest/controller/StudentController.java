package com.firstproject.rest.controller;

import com.firstproject.rest.Service.StudentService;
import com.firstproject.rest.domain.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    // http://localhost:808/students -POST
    @Autowired
    private StudentService service;

    @PostMapping("/save")
    public ResponseEntity<Student> save(@RequestBody Student student) {
        //System.out.println("SAVE");
        try {

            //implementing logger or logging in program
            LOGGER.info("START SAVE Operation");
            Student stu = service.save(student);
            LOGGER.info("END SAVE Operation");

            return new ResponseEntity<>(stu, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping()
    public ResponseEntity<Student> save1(@RequestBody Student student) {
        //System.out.println("SAVE1");
        try {


            LOGGER.info("START SAVE Operation");
            Student stu = service.save(student);
            LOGGER.info("END SAVE Operation");

            return new ResponseEntity<>(stu, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Student>> getAllStudents(){

        try {
            List<Student> list = service.getAllStudents();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long id){

        try {
            Student student = service.getStudentById(id);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public <T> ResponseEntity<T> updateStudentById(@PathVariable("id") long id, @RequestBody Student student){
        try {
            Student response = service.updateStudentById(id, student);
            if(null == response){
                return new ResponseEntity<>((T) ("ERROR!!! NO STUDENT RECORD AVAILABLE for this ID:"+id), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<T> ((T) response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<T>((T) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
