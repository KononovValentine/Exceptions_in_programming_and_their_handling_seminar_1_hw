import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Задание 1
//        nullPointerException(null);
//        arithmeticException();
//        numberFormatException();
//        arrayIndexOutOfBoundsException();

        // Задание 2
        String[][] arr = {{"12", "10", "10", "10", "10", "10", "10"}, {"12", "10", "10", "10", "10", "10", "10"},
                {"12", "10", "10", "10", "10", "10", "10"}, {"12", "10", "10", "10", "10", "10", "10"},
                {"12", "10", "10", "10", "10", "10", "10"}};
        String[][] arr2 = {{"12", "10"}, {"12", "10"}};
        String[][] arr3 = {{"abc", "xyz"}, {"abc", "xyz"}, {"abc", "xyz"}, {"abc", "xyz"}, {"abc", "xyz"}};
//        sum2d(arr);
//        sum2d(arr2);
//        sum2d(arr3);

        // Задание 3
        int[] firstArr = getRandomArray(5);
        int[] secondArr = getRandomArray(10);
//        divideArrays(firstArr, secondArr);
    }

    // Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
    static void arithmeticException() {
        int a = 10;
        int b = 0;
        int c = a/b;
    }

    static void numberFormatException() {
        int sum = 0;
        String[] arr = {"abc", "xyz"};
        for (int i = 0; i < 5; i++) {
            int val = Integer.parseInt(arr[i]);
            sum += val;
        }
    }

    static void arrayIndexOutOfBoundsException() {
        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0; i < 7; i++) {
            int a = arr[i];
        }
    }

    static void nullPointerException(Integer num) {
        int a = 10;
        int b = a/num;
    }


    // Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
    // 2 исключения
    public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length <= 4) {
                throw new RuntimeException("Out of bounds!"); // 1 - ArrayIndexOutOfBoundsException
            }
            for (int j = 0; j < 5; j++) { // 1
                if (!arr[i][j].chars().allMatch(Character::isDigit)) {
                    throw new RuntimeException("Character is not digit!"); // 2 - NumberFormatException
                }
                int val = Integer.parseInt(arr[i][j]); // 2
                sum += val;
            }
        }
        return sum;
    }

    // Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
    // каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. Если длины массивов
    // не равны, необходимо как-то оповестить пользователя.

    public static int[] getRandomArray(int length) {
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) arr[i] = random.nextInt(100);
        return arr;
    }

    public static int[] divideArrays(int[] firstArr, int[] secondArr) {
        if(firstArr.length != secondArr.length) throw new RuntimeException("Array lengths are not equal!");
        int[] resultArr = new int[firstArr.length];
        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = firstArr[i] - secondArr[i];
        }
        return resultArr;
    }
}
