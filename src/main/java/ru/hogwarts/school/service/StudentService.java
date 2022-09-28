package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class StudentService {

    private StudentRepository studentRepository;

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
        return studentRepository.findById(id).get();
    }

    public void removeStudent(long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> allStudent(){
        return studentRepository.findAll();
    }

    public Collection<Student> findByAge(int age) {
        Collection<Student> students = studentRepository.findAll();
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getAge() == age) {
                result.add(student);
            }
        }
        return result;
    }
}
