import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class HomeWorkApp4_1 {

    private static final char DEFAULT = '_';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final int SIZE = 3;

    private static final char[][] MAP = new char[SIZE][SIZE];

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DEFAULT;
            }
        }
    }

    private static void printMap() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("|");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + "|");
            }
            System.out.println();
        }
    }

    private static boolean isCellValid(int x, int y) {
        boolean isInMap = x > 0 && x <= SIZE && y > 0 && y <= SIZE;
        return isInMap && MAP[x - 1][y - 1] == DEFAULT;
    }

    private static void makeStep(int x, int y, char value) {
        MAP[x - 1][y - 1] = value;
    }

    private static void moveAI() {
        //логика хода компьютера
        int x, y;
        do {
            x = (int) (1 + Math.random() * 3);
            y = (int) (1 + Math.random() * 3);
        }while (!isCellValid(x, y));
        MAP[x - 1][y - 1] = DOT_O;
    }

    private static void aiAwait() {
        for (int i = 0; i < 10; i++) {
            System.out.print(" * ");
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
//логика проверки победы
    private static boolean isWin(char sym) {
        for (int i = 0; i < SIZE; i++) {
            boolean hor = true, ver = true, d1 = true, d2 = true;
            for (int j = 0; j < SIZE; j++) {
                hor &= MAP[i][j] == sym;
                ver &= MAP[j][i] == sym;
                d1 &= MAP[j][j] == sym;
                d2 &= MAP[j][SIZE - j - 1] == sym;
            }
            if (hor || ver || d1 || d2) {
                return true;
            }
        }
        return false;
    }

    private static void startGame() {
        initMap();
        System.out.println("Ты в игре крестики и нолики.");
        System.out.println("Чтобы победить AI, необходимо собрать три крестика подряд.");
        System.out.println("Для того, чтобы сделать ход, введи\n2 целых числа от 1 до 3 - номер строки и номер " +
                "столбца.");
        printMap();
        Scanner in = new Scanner(System.in);
        int cnt = 0;
        while (true) {
            System.out.println("Делай ход:");
            String[] values = in.nextLine().split(" ");
            if (values.length != 2) {
                System.out.println("Ты ввёл некорректные данные.\nВведи ровно два числа от 1 до 3!");
                continue;
            }
            try {
                int x = Integer.parseInt(values[0]);
                int y = Integer.parseInt(values[1]);
                if (isCellValid(x, y)) {
                    makeStep(x, y, DOT_X);
                    cnt++;
                    if (isWin(DOT_X)) {
                        System.out.println("В этот раз ты победил, кожаный мешок!");
                        showEndGameDialog(in);
                        break;
                    }
                    printMap();
                    if (cnt == 9) {
                        System.out.println("Ничья");
                        showEndGameDialog(in);
                        break;
                    }
                    System.out.println("Ход AI:");
                    aiAwait();
                    moveAI();
                    cnt++;
                    if (isWin(DOT_O)) {
                        System.out.println("В этот раз ты проиграл :,(");
                        showEndGameDialog(in);
                        break;
                    }
                    printMap();
                } else {
                    System.out.println("Невозможно сделать такой ход! Выбери другие значения");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ты ввёл некорректные данные.\nДанные должны быть числами от 1 до 3");
            }
        }
    }

    private static void showEndGameDialog(Scanner in) {
        System.out.println("Нажми 1, чтобы начать новую игру");
        System.out.println("Для выхода нажми любую другую клавишу");

        System.out.println("Введи команду...");
        String command = in.next();
        if (command.equals("1")) {
            startGame();
            return;
        }
        System.out.println("Игра окончена!");

    }

    public static void main(String[] args) {
        startGame();
    }


}

