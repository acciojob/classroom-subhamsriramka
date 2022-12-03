package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.addAStudent(student);
    }

    public void addTeacher(Teacher teacher) {
        studentRepository.addATeacher(teacher);
    }

    public Student getStudentByName(String name) {
        return studentRepository.getStudentByName(name);
    }

    public Teacher getTeacherByName(String name) {
        return studentRepository.getTeacherByName(name);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        studentRepository.addStudentTeacherPair(student, teacher);
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        return studentRepository.getStudentsByTeacherName(teacher);
    }

    public List<String> findAllStudents() {
        return studentRepository.findAllStudents();
    }

    public void deleteTeacherByName(String name) {
        studentRepository.deleteTeacherByName(name);
    }

    public void deleteAllTeachers() {
        studentRepository.deleteAllTeachers();
    }
}
