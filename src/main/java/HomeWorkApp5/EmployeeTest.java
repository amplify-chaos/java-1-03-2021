package HomeWorkApp5;

import java.util.Arrays;

public class EmployeeTest {
    public static void main(String[] args) {

        Employee[] user = new Employee[5];
        System.out.println(Arrays.toString(user));
        user[0] = new Employee("Ivanov Ivan", "PM", "PM@mail.ru","12341234", 150000, 35);
        user[1] = new Employee("Petrov Petr", "Junior QA", "juniorqa@mail.ru", "12341235", 60000, 21);
        user[2] = new Employee("Letuchaya Elena", "QA engineer", "qaengineer@mail.ru", "123412346", 120000, 29);
        user[3] = new Employee("Irisov Vasiliy", "Director", "director@mail.ru", "123412347", 500000, 45);
        user[4] = new Employee("Petrov Evgenii", "developer", "developer@mail.ru", "123412348", 250000, 41);

        for (Employee employee : user) {
            if (employee.getAge() > 40) {
                employee.printInfo();
            }
        }
    }
}