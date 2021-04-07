public class HomeWorkApp3 {
    public static void main(String[] args) {
      invertArray();
      fillArray();
      changeArray();
      //задание4
        int[][] m = new int[5][5];
        fillMatrix(m);
        for (int i = 0; i < 5; i ++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();}
        twoArguments(6,6);
    }
//задание1
public static void invertArray() {
    int[] arr = {1, 0, 1, 0, 0, 1};
    for (int i = 0; i < arr.length; i++) {
        arr[i] = (arr[i] + 1) % 2;
        System.out.print (arr[i] + " ");
    }
        System.out.println();
    }

//задание2
    public static void fillArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            {arr[i] = i + 1;
            System.out.print(arr[i] + " ");
            }
        }
            System.out.println();
        }

        //задание3
        public static void changeArray() {
            int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < 6) arr[i] *= 2;
                System.out.print(arr[i] + " ");
            }
                System.out.println();
            }
            //задание4
            static void fillMatrix(int[][] m) {
                for (int i=0; i < m.length; i++) {
                    m[i][i] = m[i][m.length - i - 1] = 1;
                }

                }
                //задание5
public static void twoArguments (int len, int initialValue) {
        int[] arr = new int [len];
    for (int i = 0; i < arr.length; i++) {
        arr[i] = initialValue;
            System.out.print(arr[i] + " ");}
}}