public class HomeWorkApp2 {
    public static void main(String[] args) {
        withinTenAndTwenty(5,10);
        isPositiveOrNegative(0);
        isNegative(-2);
        printWordNTimes("hello", 5);
        leapYear(2020);
    }
    //задание 1
public static boolean withinTenAndTwenty(int a, int b) {
    int sum = a + b;
    return sum >= 10 && sum <= 20;
    }
    //задание 2
    public static void isPositiveOrNegative(int x) {
        if (x >= 0) {
            System.out.println("число положительное");
        } else {
            System.out.println("число отрицательное");
        }
    }
    //задание 3
    public static boolean isNegative(int x) {
        return x < 0;
    }
        //задание 4
        public static void printWordNTimes(String str, int n) {
            for (int i = 0; i < n; i++) {
                System.out.println(str);
            }
        }
        //задание 5
    public static boolean leapYear(int year){
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
    }

