package com.firstproject.rest.Service;

import com.firstproject.rest.domain.Student;
import com.firstproject.rest.exception.StudentNotFoundException;
import com.firstproject.rest.repo.StudentDetail;
import com.firstproject.rest.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student save(Student student) {

        //Map pojo to entity class
        StudentDetail entityObj = mapToEntity(student);
        StudentDetail response = studentRepository.save(entityObj);
        student.setId((int) response.getId());
        return student;
    }

    public List<Student> getAllStudents() {
        List<StudentDetail> listOfRecords = studentRepository.findAll();
        List<Student> studentList = new ArrayList<>();
        for(StudentDetail s : listOfRecords){
            Student st = new Student();
            st.setId((int)s.getId());
            st.setName(s.getName());
            st.setCollegeName(s.getCollegeName());
            st.setAge(s.getAge());
            studentList.add(st);
        }
        return studentList;
    }

    private StudentDetail mapToEntity(Student student) {
        StudentDetail entityObj = new StudentDetail();
        entityObj.setName(student.getName());
        entityObj.setCollegeName(student.getCollegeName());
        entityObj.setAge(student.getAge());
        return entityObj;
    }


    public Student getStudentById(Long id) throws StudentNotFoundException {
        Optional<StudentDetail> entityObj = studentRepository.findById(id);

        StudentDetail resp;
        try {
            resp = entityObj.get();
        } catch (Exception ex) {
            throw new StudentNotFoundException("Student has not enrolled with this id :" + id);
        }
        return mapToDomainObj(resp);
    }


    public Student updateStudentById(long id, Student student) {
        if(studentRepository.existsById(id)){
            Optional<StudentDetail> entityObj = studentRepository.findById(id);
            StudentDetail studentDetail = entityObj.get();
            studentDetail.setName(StringUtils.hasLength(student.getName()) ? student.getName() : studentDetail.getName());
            studentDetail.setCollegeName(StringUtils.hasLength(student.getCollegeName()) ? student.getCollegeName() : studentDetail.getCollegeName());
            studentDetail.setAge(student.getAge() > 3 ? student.getAge() : studentDetail.getAge());


            StudentDetail response = studentRepository.save(studentDetail);
            return mapToDomainObj(response);
        } else {
            return null;
        }
    }

    private Student mapToDomainObj(StudentDetail response) {
        Student st = new Student();
        st.setId((int) response.getId());
        st.setName(response.getName());
        st.setCollegeName(response.getCollegeName());
        st.setAge(response.getAge());
        return st;
    }
}