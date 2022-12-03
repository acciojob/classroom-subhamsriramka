package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Component
public class StudentRepository {
    List<Student> studentList = new ArrayList<>();
    List<Teacher> teacherList = new ArrayList<>();
    Map<Teacher, List<Student>> teacherListMap = new HashMap<>();

    public void addAStudent(Student student) {
        studentList.add(student);
        return;
    }

    public void addATeacher(Teacher teacher) {
        teacherList.add(teacher);
        return;
    }

    public void addStudentTeacherPair(String teacher, String student) {
        Student student1 = getStudentByName(student);
        Teacher teacher1 = getTeacherByName(teacher);
        if(teacher1 == null || student1 == null) return;
        if(!teacherListMap.containsKey(teacher1))
            teacherListMap.put(teacher1, new ArrayList<>());
        teacherListMap.get(teacher1).add(student1);
    }

    public Student getStudentByName(String student) {
        for(Student student1: studentList) {
            if(student1.getName().equals(student))
                return student1;
        }

        return new Student();
    }

    public Teacher getTeacherByName(String name) {
        for(Teacher teacher: teacherList) {
            if(teacher.getName().equals(name)) return teacher;
        }

        return new Teacher();
    }

    public List<String> getStudentsByTeacherName(String TeacherName) {
        Teacher director = getTeacherByName(TeacherName);
        List<String> movieList = new ArrayList<>();

        if(director == null || !teacherListMap.containsKey(director))
            return movieList;

        for (Student movie: teacherListMap.get(director)) {
            movieList.add(movie.getName());
        }

        return movieList;
    }

    public List<String> findAllStudents() {
        List<String> list = new ArrayList<>();
        for (Student student: studentList)
            list.add(student.getName());

        return list;
    }

    public void deleteTeacherByName(String teacherName) {
        Teacher teacher = getTeacherByName(teacherName);
        if(teacherListMap.containsKey(teacher) && teacher!= null) {
            List<Student> studentList1 = teacherListMap.get(teacher);
            for (Student teacher1: studentList1)
                studentList.remove(teacher1);

            teacherListMap.remove(teacher);
        }

        teacherList.remove(teacher);
    }

    public void deleteAllTeachers() {
        for(Teacher teacher:teacherList) {
            if(teacherListMap.containsKey(teacher)) {
                for (Student student: teacherListMap.get(teacher))
                    studentList.remove(student);
            }
        }

        teacherList.clear();
        teacherListMap.clear();
    }
}