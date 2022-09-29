package ru.hogwarts.school.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.model.Student;
import java.util.*;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findStudentByAge (int age);
    List<Student> findByAgeBetween(int min, int max);

    List<Student> findStudentsByFaculty(Long id);
}
