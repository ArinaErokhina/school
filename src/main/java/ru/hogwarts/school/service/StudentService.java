package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.Collection;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student editStudents(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void removeStudent(long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> allStudent(){
        return studentRepository.findAll();
    }

    public Collection<Student> findByAge(int age) {
        return studentRepository.findStudentByAge(age);
    }

    public Collection<Student> findByAgeRange(int min, int max){
        return studentRepository.findByAgeBetween(min, max);
    }

    public Collection<Student> findByFaculty(Long id){
        return studentRepository.findStudentsByFaculty(id);
    }
}
