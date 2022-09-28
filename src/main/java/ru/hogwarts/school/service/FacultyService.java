package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repositories.FacultyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Service
public class FacultyService {

    private FacultyRepository facultyRepository;

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
        return facultyRepository.findById(id).get();
    }

    public void removeFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> allFaculties(){
        return facultyRepository.findAll();
    }

    public Collection<Faculty> findColor(String color) {
        Collection<Faculty> faculties = facultyRepository.findAll();
        ArrayList<Faculty> result = new ArrayList<>();
        for (Faculty faculty : faculties) {
            if (Objects.equals(faculty.getColor(), color)) {
                result.add(faculty);
            }
        }
        return result;
    }

}
