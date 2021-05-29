package Lesson4lvl2.TaskOne;

import java.util.*;

    public class MainClass {
        public static void main(String[] args){
            List<String> words = Arrays.asList(
                    "немецкая овчарка", "датский дог", "такса", "стаффордширдский терьер", "чау-чау",
                    "той-терьер", "немецкая овчарка", "немецкая овчарка", "немецкий дог", "бультерьер",
                    "питбуль", "лабрадор", "золотистый ретривер", "японский хин", "мопс",
                    "бультерьер", "лабрадор", "французский бульдог", "русский спаниель", "мопс"
            );

            Set<String> unique = new HashSet<String>(words);

            System.out.println("Первоначальный список слов:");
            System.out.println(words.toString());
            System.out.println("Список уникальных слов:");
            System.out.println(unique.toString());
            System.out.println("Частота встречаемости:");
            for (String key : unique) {
                System.out.println(key + ": " + Collections.frequency(words, key));
            }
        }
    }
