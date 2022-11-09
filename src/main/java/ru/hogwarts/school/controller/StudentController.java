package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.*;
@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id) {
        Student student = studentService.findStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student addStudent = studentService.addStudent(student);
        return ResponseEntity.ok(addStudent);
    }

    @PutMapping
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        Student editStudent = studentService.editStudents(student);
        if (editStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(editStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable long id) {
        studentService.removeStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> getAllStudent(){
        return ResponseEntity.ok(studentService.allStudent());
    }

    @GetMapping("age")
    public ResponseEntity<Collection<Student>> findStudentsByAge(@RequestParam(name = "age") int age) {
        if (age >= 0) {
            return ResponseEntity.ok(studentService.findByAge(age));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("age_range")
    public ResponseEntity<Collection<Student>> findStudentsByAgeRange(@RequestParam("min") int min, @RequestParam("max") int max){
        return ResponseEntity.ok(studentService.findByAgeRange(min, max));
    }

    @GetMapping("faculty_student/{id}")
    public ResponseEntity<Faculty> findStudentsByFaculty(@PathVariable long id){
        return ResponseEntity.ok(studentService.findStudentsFaculty(id));
    }

    @GetMapping("student_count")
    public ResponseEntity<Long> getAmountStudent(){
        return ResponseEntity.ok(studentService.getAmountStudents());
    }

    @GetMapping("average_age")
    public ResponseEntity<Double> getAverageStudent(){
        return ResponseEntity.ok(studentService.averageAge());
    }

    @GetMapping("last_five_student")
    public ResponseEntity<List<Student>> getLastFiveStudent(){
        return ResponseEntity.ok(studentService.getLastFiveStudents());
    }

    @GetMapping("student_by_letter/{letter}")
    public ResponseEntity<List<String>> getStudentByLetter(@PathVariable String letter){
        return ResponseEntity.ok(studentService.getStudentByLetter(letter));
    }

    @GetMapping("student_average_age")
    public ResponseEntity<OptionalDouble> getAverageAge(){
        return ResponseEntity.ok(studentService.getAverageAge());
    }

    @GetMapping("student_thread1")
    public void findStudentThread(){
        studentService.findStudentThread1();
    }

    @GetMapping("student_thread2")
    public void findStudentThread2(){
        studentService.findStudentThread1();
    }
}
