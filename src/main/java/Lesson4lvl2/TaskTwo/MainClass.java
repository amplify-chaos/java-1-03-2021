package Lesson4lvl2.TaskTwo;

public class MainClass {
    public static void main(String[] args){
        System.out.println("Идёт создание справочника:");
        Phonebook phonebook = new Phonebook();
        System.out.println("* * * * * * * * * *");

        System.out.println("Идёт наполнение справочника:");
        phonebook.add("Раскольников", "12345678");
        phonebook.add("Раскольников", "23456789");
        phonebook.add("Свидригайлов", "34567891");
        phonebook.add("Мармеладова", "45678910");
        phonebook.add("Раскольников", "56789101");
        System.out.println("* * * * * * * * * *");

        System.out.println("Идёт получение номеров:");
        System.out.println("Раскольников");
        System.out.println(phonebook.get("Раскольников"));
        System.out.println("Свидригайлов");
        System.out.println(phonebook.get("Свидригайлов"));
        System.out.println("Мармеладова");
        System.out.println(phonebook.get("Мармеладова"));
        System.out.println("* * * * * * * * * *");

        System.out.println("Запись отсутствует:");
        System.out.println("Карамазов");
        System.out.println(phonebook.get("Карамазов"));
        System.out.println("* * * * * * * * * *");

        System.out.println("Запишем уже существующий номер:");
        phonebook.add("Раскольников", "12345678");
        System.out.println("Раскольников");
        System.out.println(phonebook.get("Раскольников"));
    }
}