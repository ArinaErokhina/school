package ru.hogwarts.school;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.ArrayList;
import java.util.Collection;

import static ru.hogwarts.school.Constants.*;

public class StudentControllerTest {

    private StudentService studentService;
    private Student student1;
    private Student student2;
    private Student student3;

    @BeforeEach
    public void setUp(){
        studentService = new StudentService();
        student1 = new Student(IDSTUDENT1, NAMESTUDENT1, AGESTUDENT1);
        student2 = new Student(IDSTUDENT2, NAMESTUDENT2, AGESTUDENT2);
        student3 = new Student(IDSTUDENT3, NAMESTUDENT3, AGESTUDENT3);
    }

    @Test
    public void getStudentTest(){
        studentService.addStudent(student1);
        Assertions.assertEquals(student1, studentService.findStudent(student1.getId()));
    }

    @Test
    public void createStudentTest(){
        Assertions.assertEquals(student1, studentService.addStudent(student1));
    }

    @Test
    public void editStudentTest(){
        Student editedStudent = new Student(IDSTUDENT1, NAMESTUDENT1, AGESTUDENT3);
        studentService.addStudent(student1);
        Assertions.assertEquals(editedStudent, studentService.editStudents(editedStudent));
    }

    @Test
    public void deleteStudentTest(){
        studentService.addStudent(student2);
        Assertions.assertEquals(student2, studentService.removeStudent(student2.getId()));
    }

    @Test
    public void findByAgeTest(){
        Collection<Student> actual = studentService.findByAge(12);
        ArrayList<Student> expected =new ArrayList<>();
        expected.add(student2);
        Assertions.assertTrue(expected.containsAll(actual));
    }
}
