package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable Long id) {
        Faculty faculty = facultyService.findFaculty(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PostMapping
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        Faculty addFaculty = facultyService.addFaculty(faculty);
        if (addFaculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(addFaculty);
    }

    @PutMapping
    public ResponseEntity<Faculty> editFaculty(@RequestBody Faculty faculty) {
        Faculty createFaculty = facultyService.editFaculty(faculty);
        if (createFaculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(createFaculty);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Faculty> deleteFaculty(@PathVariable Long id) {
        Faculty deleteFaculty = facultyService.removeFaculty(id);
        if (deleteFaculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleteFaculty);
    }

    @GetMapping("{color}")
    public ResponseEntity<Collection<Faculty>> findFaculties(@PathVariable String color) {
        if (color != null && !color.isBlank()) {
            return ResponseEntity.ok(facultyService.findColor(color));
        }
        return ResponseEntity.notFound().build();
    }
}