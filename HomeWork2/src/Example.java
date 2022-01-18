import java.util.Arrays;

public class Example {
    /*
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException, и вывести результат расчета.
     */
    public static void main(String[] args) throws MyArraySizeException {

        int[][] IntegerArray = new int[4][4];

//        String[][] StringArray = new String[3][4];// Exception in thread "main" MyArraySizeException: Подается неверный массив. Должен быть 4x4.
        String[][] StringArray = new String[4][4];

//        DoubleArray(StringArray, IntegerArray, "Q"); //Exception in thread "main" java.lang.NumberFormatException: For input string: "Q"
        DoubleArray(StringArray, IntegerArray, "10");

        System.out.println(Arrays.deepToString(IntegerArray));

    }

    public static void DoubleArray(String[][] StringArray, int[][] IntegerArray, String input) throws MyArraySizeException {

        if(StringArray.length != 4  || StringArray[0].length != 4 || StringArray[1].length != 4 || StringArray[2].length !=4 || StringArray[3].length !=4) {
            throw new MyArraySizeException("Подается неверный массив. Должен быть 4x4.");
        } else {
            for (int i = 0; i < StringArray.length; i++) {
                for (int j = 0; j < StringArray.length; j++) {
                    StringArray[i][j] = input;
                }
            }
            int sum = 0;
            for (int i = 0; i < StringArray.length; i++) {
                for (int j = 0; j < StringArray.length; j++) {
                        IntegerArray[i][j] = Integer.parseInt(StringArray[i][j]);
                        sum += IntegerArray[i][j];
                }
            }
            System.out.println(sum);
        }
    }


}
