package Lesson4lvl2.TaskTwo;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.HashMap;
        import java.util.List;

public class Phonebook {

    private HashMap<String, List<String>> book;

    public Phonebook(){
        this.book = new HashMap<>();
    }

    public void add(String lastname, String number){
        if(book.containsKey(lastname)){
            List<String> numbers = book.get(lastname);
            if(!numbers.contains(number)){
                numbers.add(number);
                System.out.println(String.format("Контактный телефон %s добавлен для фамилии %s", number, lastname));
            } else {
                System.out.println(String.format("Контактный телефон %s уже существует для фамилии %s", number, lastname));
            }
        } else {
            book.put(lastname, new ArrayList<>(Arrays.asList(number)));
            System.out.println(String.format("Контактный телефон %s добавлен для фамилии %s", number, lastname));
        }
    }

    public List<String> get(String lastname){
        if(book.containsKey(lastname)){
            return book.get(lastname);
        } else {
            System.out.println(String.format("В телефонной книге нет номера для фамилии %s", lastname));
            return new ArrayList<>();
        }
    }
}