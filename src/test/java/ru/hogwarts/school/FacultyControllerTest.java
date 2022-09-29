package ru.hogwarts.school;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repositories.FacultyRepository;
import ru.hogwarts.school.service.FacultyService;

import java.util.ArrayList;
import java.util.Collection;

import static ru.hogwarts.school.Constants.*;

@ExtendWith(MockitoExtension.class)
public class FacultyControllerTest {

    @InjectMocks
    private FacultyService facultyService;
    @Mock
    private FacultyRepository facultyRepository;
    private Faculty faculty1;
    private Faculty faculty2;
    private Faculty faculty3;

    @BeforeEach
    public void setUp(){
        facultyService = new FacultyService(facultyRepository);
        faculty1 = new Faculty(IDFACULTY1, NAMEFACULTY1, COLORFACULTY1);
        faculty2 = new Faculty(IDFACULTY2, NAMEFACULTY2, COLORFACULTY2);
        faculty3 = new Faculty(IDFACULTY3, NAMEFACULTY3, COLORFACULTY3);
    }

    @Test
    public void getFacultyTest(){
        facultyService.addFaculty(faculty1);
        Assertions.assertEquals(faculty1, facultyService.findFaculty(faculty1.getId()));
    }

    @Test
    public void createFacultyTest(){
        Assertions.assertEquals(faculty2, facultyService.addFaculty(faculty2));
    }

    @Test
    public void editFacultyTest(){
        Faculty editedFaculty = new Faculty(IDFACULTY1, NAMESTUDENT1, COLORFACULTY3);
        facultyService.addFaculty(faculty1);
        Assertions.assertEquals(editedFaculty, facultyService.editFaculty(editedFaculty));
    }

    @Test
    public void deleteFacultyTest(){
        facultyService.addFaculty(faculty3);
        //Assertions.assertTrue(facultyService.removeFaculty(faculty3.getId()));
    }

    @Test
    public void findFacultiesTest(){
        String color1 = "color1";
        Collection<Faculty> actual = facultyService.findColor(color1);
        ArrayList<Faculty> expected =new ArrayList<>();
        expected.add(faculty2);
        expected.add(faculty3);
        Assertions.assertTrue(expected.containsAll(actual));
    }
}
