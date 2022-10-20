package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.FacultyRepository;

import java.util.Collection;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty editFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).orElse(null);
    }

    public void removeFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> allFaculties() {
        return facultyRepository.findAll();
    }

    public Collection<Faculty> findColor(String color) {
        return facultyRepository.findFacultiesByColor(color);
    }

    public Collection<Faculty> findFacultiesByColorOrName(String nameOrColor) {
        String name = nameOrColor;
        String color = nameOrColor;
        return facultyRepository.findFacultyByNameContainsIgnoreCaseOrColorContainsIgnoreCase(name, color);
    }

    public Collection<Student> findFacultyByStudent(long id) {
        Faculty faculty = facultyRepository.findById(id).get();
        if (faculty != null) {
            return faculty.getStudents();
        }
        return null;
    }

}
