package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@Service
public class StudentService {

    private final HashMap<Long, Student> students = new HashMap<>();
    private long lastId = 0;

    public Student addStudent(Student student) {
        student.setId(++lastId);
        students.put(lastId, student);
        return student;
    }

    public Student editStudents(Student student) {
        if (students.containsKey(student.getId())){
            students.put(student.getId(), student);
            return student;
        }
        return null;
    }

    public Student findStudent(long id) {
        return students.get(id);
    }

    public Student removeStudent(long id) {
        return students.remove(id);
    }

    public Collection<Student> findByAge(int age) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : students.values()) {
            if (student.getAge() == age) {
                result.add(student);
            }
        }
        return result;
    }
}
