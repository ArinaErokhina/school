package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.Collection;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student addStudent(Student student) {
        logger.debug("The method addStudent is called");
        return studentRepository.save(student);
    }

    public Student editStudents(Student student) {
        logger.debug("The method editStudent is called");
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        logger.debug("The method findStudent is called");
        return studentRepository.findById(id).orElse(null);
    }

    public void removeStudent(long id) {
        logger.debug("The method removeStudent is called");
        studentRepository.deleteById(id);
    }

    public Collection<Student> allStudent() {
        logger.debug("The method allStudent is called");
        return studentRepository.findAll();
    }

    public Collection<Student> findByAge(int age) {
        logger.debug("The method findByAge is called");
        return studentRepository.findStudentByAge(age);
    }

    public Collection<Student> findByAgeRange(int min, int max) {
        logger.debug("The method findByAgeRange is called");
        return studentRepository.findByAgeBetween(min, max);
    }

    public Faculty findStudentsFaculty(Long id) {
        logger.debug("The method findStudentsFaculty is called");
        Student student = studentRepository.findById(id).get();
        if (student != null) {
            return student.getFaculty();
        }
        return null;
    }

    public Long getAmountStudents() {
        logger.debug("The method getAmountStudents is called");
        return studentRepository.getAmountAllStudents();
    }

    public Double averageAge() {
        logger.debug("The method averageAge is called");
        return studentRepository.getAverageAgeAllStudent();
    }

    public List<Student> getLastFiveStudents() {
        logger.debug("The method getLastFiveStudents is called");
        return studentRepository.getLastFiveStudents();
    }

    public List<String> getStudentByLetter(String letter) {
        logger.debug("The method getStudentByLetter is called");
        List<String> studentByLetter =
                studentRepository.findAll().stream()
                        .map(student -> student.getName())
                        .filter(s -> s.startsWith(letter))
                        .sorted((s1, s2) -> s1.compareTo(s2))
                        .map(s -> s.toUpperCase())
                        .collect(Collectors.toList());

        return studentByLetter;
    }

    public OptionalDouble getAverageAge(){
        logger.debug("The method getAverageAge is called");
        OptionalDouble averageAge =
                studentRepository.findAll().stream()
                        .mapToDouble(student -> student.getAge())
                        .average();

        return averageAge;
    }

}
