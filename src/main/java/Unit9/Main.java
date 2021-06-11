package Unit9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        ArrayList<Course> courses = new ArrayList<Course>(Arrays.asList(
                new Course("testing"),
                new Course("java lvl 1"),
                new Course("java core"),
                new Course("linux"),
                new Course("python"),
                new Course("java lvl 2"),
                new Course("HTML/CSS")
        ));

        List<Person> persons = new ArrayList<Person>(Arrays.asList(
                new Person("Олег", new ArrayList<Course>(Arrays.asList(courses.get(0), courses.get(1)))),
                new Person("Катя", new ArrayList<Course>(Arrays.asList(courses.get(0), courses.get(1),
                        courses.get(2), courses.get(3)))),
                new Person("Денис", new ArrayList<Course>(Arrays.asList(courses.get(0), courses.get(2),
                        courses.get(4)))),
                new Person("Костя", new ArrayList<Course>(Arrays.asList(courses.get(0), courses.get(1),
                        courses.get(5), courses.get(3)))),
                new Person("Лиля", new ArrayList<Course>(Arrays.asList(courses.get(0), courses.get(1),
                        courses.get(2), courses.get(6))))
        ));

//        Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны студенты.
        List<String> studentCourses = persons.stream()
                .flatMap(person -> person.getAllCourses().stream().map(course -> course.courseName))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(studentCourses);

        System.out.println("* * * * * * * * * *");

//        Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных (любознательность определяется количеством курсов).
        List<String> goodStudent = persons.stream()
                .sorted(Comparator.comparing(Person::getLengthCourse).reversed())
                .map(person -> person.getName())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println((goodStudent));

        System.out.println("* * * * * * * * * *");

//         Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов, которые посещают этот курс.

        List<String> visitToCourse = persons.stream()
                .filter(person -> person.getAllCourses().contains(courses.get(1)))
                .map(person -> person.getName())
                .collect(Collectors.toList());
        System.out.println(visitToCourse);


    }

}

