package pro.sky22.testing.lesson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class University {

    private final StudentValueGenerator studentValueGenerator;

    public University(StudentValueGenerator studentValueGenerator) {
        this.studentValueGenerator = studentValueGenerator;
    }

    private Map<Integer, Student> allStudents = new HashMap<Integer, Student>();
    private int countId = 1;

    public void addStudents(Student student) {
        if (allStudents == null) {
            allStudents = new HashMap<Integer, Student>();
        }
        student.setId(countId);
        student.setAge(studentValueGenerator.generateAge());
        studentValueGenerator.generateAge();
        allStudents.put(countId, student);
        countId++;
    }

    public void addStudentsInRange(Student student, int minYear, int maxTear) {
        if (allStudents == null) {
            allStudents = new HashMap<Integer, Student>();
        }
        student.setId(countId);
        studentValueGenerator.generateAge();
        studentValueGenerator.generateAge();
        student.setAge(studentValueGenerator.generateAgeInRange(minYear, maxTear));
        allStudents.put(countId, student);
        countId++;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(allStudents.values());
    }

    public List<Student> getAllStudents(boolean isMale) {
        List<Student> listAllStudents = new ArrayList<>();
        for (Student student : allStudents.values()) {
            if (student.isMale() == isMale) {
                listAllStudents.add(student);
            }
        }
        return listAllStudents;
    }
}
