package Lesson5lvl2;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Домашняя работа N5\n");
        AppData appData = new AppData("Value1,Value2,Value3");//Создаём готовые заголовки
        appData.setData(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        FileWriter fileWriterHeader = new FileWriter("data.csv", false);
        fileWriterHeader.write(appData.getHeaderString());//Записываем в файл заголовок
        fileWriterHeader.write(appData.stringData());//Записываем в файл данные
        fileWriterHeader.close();//Закрываем поток вывода

        AppData appDataRead = new AppData(new FileReader("data.csv"));
        appDataRead.readAll();//Читаем из файла и ициализируем поля класса
        System.out.println(Arrays.toString(appDataRead.getHeader()));//Проверяем поле заголовков
        AppData.show2dArray(appDataRead.getData());//Проверяем поле данных


    }

}

