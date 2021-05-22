package Lesson3lvl2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FirstTask();
        SecondTask();
    }

    public static void FirstTask() {

        String[] strArray = {" каждый ", " охотник ", " желает ", " знать ", " где ", " сидит ", " фазан "};

        TwoElementsSwap<String> strAnyArray = new TwoElementsSwap<>(strArray);
        try {
            strAnyArray.TwoElementsSwap(strArray, 3, 6);

        } catch (WrongPositionException e) {
            e.printStackTrace();
        }
        System.out.println("Результат замены в массиве String: " + Arrays.toString(strArray));

    }
    public static void SecondTask() {
        Box<Apple> boxOfApples = new Box<>(new Apple(), new Apple(), new Apple()); //складываем яблоки в коробку
        Box<Orange> boxOfOranges = new Box<>(new Orange(), new Orange()); //складываем апельсины в коробку
        System.out.println(" Коробка яблок весит " + boxOfApples.getWeight()); //взвешиваем коробку с яблоками
        System.out.println(" Коробка апельсинов весит " + boxOfOranges.getWeight()); //взвешиваем коробку с апельсинами
        System.out.println(boxOfApples.compare(boxOfOranges));//вес коробок одинаковый >> печатаем в консоль true, иначе - false
    }
}

