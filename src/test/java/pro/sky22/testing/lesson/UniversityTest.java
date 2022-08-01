package pro.sky22.testing.lesson;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class UniversityTest {

    private final Student student = new Student("Evgeny", true);
    //    private Student student1;
//    private Student student2;
    @InjectMocks
    private University university;

    @Mock
    private StudentValueGenerator studentValueGenerator;

//    @BeforeEach
//    public void setUp() {

//        University university = new University(studentValueGenerator);

//        Student student = new Student("Evgeny", 35, true);
//        Student student1 = new Student("Olga", 15, false);
//        Student student2 = new Student("Marina", 34, false);
//
//
//        university.addStudents(student);
//        university.addStudents(student1);
//        university.addStudents(student2);
//    }
//    }

    @Test
    public void getAllStudents() {
//        University university = new University(studentValueGenerator);
        assertNotNull(studentValueGenerator);
        Mockito.when(studentValueGenerator.generateAge()).thenReturn(50);
        university.addStudents(student);
        List<Student> expected = university.getAllStudents();
        assertEquals(expected.get(0).getAge(), 50);

    }

    @Test
    public void getAllStudentsOver50Years() {
//        University university = new University(studentValueGenerator);
        Mockito.when(studentValueGenerator.generateAgeInRange(anyInt(), anyInt())).thenReturn(55);
        university.addStudentsInRange(student, 50, 100);
        List<Student> expected = university.getAllStudents();
        assertEquals(expected.get(0).getAge(), 55);

    }

    @Test
    public void getAllStudentsWithCountAgeGenerate() {
//        University university = new University(studentValueGenerator);
        assertNotNull(studentValueGenerator);
        Mockito.when(studentValueGenerator.generateAge()).thenReturn(50);
        university.addStudents(student);
        List<Student> expected = university.getAllStudents();
        assertEquals(expected.get(0).getAge(), 50);

        Mockito.verify(studentValueGenerator, times(2)).generateAge();

    }

    @Test
    public void getAllStudentsInOrder() {
//        University university = new University(studentValueGenerator);
        Mockito.when(studentValueGenerator.generateAgeInRange(anyInt(), anyInt())).thenReturn(55);
        university.addStudentsInRange(student, 50, 100);

        InOrder inOrder = Mockito.inOrder(studentValueGenerator);

        List<Student> expected = university.getAllStudents();

        inOrder.verify(studentValueGenerator, times(2)).generateAge();
        inOrder.verify(studentValueGenerator).generateAgeInRange(anyInt(), anyInt());
        assertEquals(expected.get(0).getAge(), 55);

    }

//    @Test
//    public void getAllStudents() {
//        Student student = new Student("Evgeny", 35, true);
//        Student student1 = new Student("Olga", 15, false);
//        Student student2 = new Student("Marina", 34, false);
//
//        University university = new University();
//
//        university.addStudents(student);
//        university.addStudents(student1);
//        university.addStudents(student2);
//
//        List<Student> expected = university.getAllStudents();
//        List<Student> actual = new ArrayList<>();
//
//        actual.add(student);
//        actual.add(student1);
//        actual.add(student2);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void getAllStudentsNotNull() {
//        University university = new University();
//        List<Student> expected = university.getAllStudents();
//        assertNotNull(expected);
//    }
//
//    @Test
//    public void getAllStudentsIsMale() {
//        Student student = new Student("Evgeny", 35, true);
//        Student student1 = new Student("Olga", 15, false);
//        Student student2 = new Student("Marina", 34, false);
//
//        University university = new University();
//
//        university.addStudents(student);
//        university.addStudents(student1);
//        university.addStudents(student2);
//
//        List<Student> expected = university.getAllStudents(true);
//        List<Student> actual = new ArrayList<>();
//
//        actual.add(student);
////        actual.add(student1);
//        assertEquals(expected, actual);
//    }

}
