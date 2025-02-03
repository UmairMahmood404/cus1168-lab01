package academy.javapro;
//Umair Mahmood
//CUS1168
import java.util.*;
import java.util.stream.*;

public class StudentStreamLab {
    public static void main(String[] args) {
        // Creating a list of students
        List<Student> students = Arrays.asList(
                new Student("Alice", 3.5, "Junior"),
                new Student("Bob", 3.8, "Senior"),
                new Student("Charlie", 2.9, "Sophomore"),
                new Student("David", 3.1, "Freshman"),
                new Student("Eve", 3.9, "Junior")
        );

        // TODO - Filtering: Students with GPA > 3.0
        List<Student> highGpaStudents = students.stream()
                .filter(s -> s.getGpa() > 3.0)
                .collect(Collectors.toList());
        System.out.println("Students with GPA > 3.0:");
        highGpaStudents.forEach(System.out::println);
        System.out.println();

        // TODO - Mapping: Extract names of students with GPA > 3.0
        List<String> highGpaStudentnames = highGpaStudents.stream()
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println("High GPA student names:");
        highGpaStudentnames.forEach(System.out::println);
        System.out.println();
        // TODO - Reducing: Calculate the average GPA of all students
        double averageGpa = students.stream()
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0.0);
        System.out.printf("Average GPA: %.2f\n\n", averageGpa);
        // TODO Collecting: Collect all "Junior" students into a list
        List<Student> juniors = students.stream()
                .filter(s -> s.getCollegeYear().equals("Junior"))
                .collect(Collectors.toList());

        System.out.println("Juniors:");
        juniors.forEach(System.out::println);
    }
}
