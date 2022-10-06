package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

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
    public ResponseEntity<Collection<Student>> findStudents(@RequestParam(name = "age") int age) {
        if (age >= 0) {
            return ResponseEntity.ok(studentService.findByAge(age));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("age_range")
    public ResponseEntity<Collection<Student>> findStudentsByAgeRange(@RequestParam("min") int min, @RequestParam("max") int max){
        return ResponseEntity.ok(studentService.findByAgeRange(min, max));
    }

    @GetMapping("students_faculty/{id}")
    public ResponseEntity<Collection<Student>> findStudentsByFaculty(@PathVariable long id){
        return ResponseEntity.ok(studentService.findByFaculty(id));
    }
}
