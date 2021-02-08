package geekbrains.couse2;

import java.util.Arrays;

public class Main {
/*
 1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4,
    при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
    Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
    должно быть брошено исключение MyArrayDataException – с детализацией, в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException
    и вывести результат расчета.
 */
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] myArray = {{"5", "22", "31", "14"},
                {"6", "82", "33", "24"},
                {"100", "22", "48", "9"},
                {"www", "18", "39", "40"}};
        System.out.println("Sum of array " + Arrays.deepToString(myArray) + " equal " + sumArray(myArray) + ".");
    }
    public static int sumArray(String array4x4[][]) throws MyArraySizeException, MyArrayDataException {

        if(array4x4.length != 4) {
               throw new MyArraySizeException("Size of array isn't 4X4. Number of array's row equal " + array4x4.length + " instead of 4.");
             }
        int sum = 0;
        for (int i = 0; i < array4x4.length; i++) {
            if(array4x4[i].length != 4){
                throw new MyArraySizeException("Size of array isn't 4X4. Number of array's columns equal " + array4x4[i].length + " instead of 4.");
            }

            for (int j = 0; j < array4x4[i].length ; j++) {
                try{
                        sum += Integer.parseInt(array4x4[i][j]);
                    }
                catch(NumberFormatException e){
                        throw new MyArrayDataException("Element [" + (i+1) + " , " + (j+1) + "] of array is not number. It's " + array4x4[i][j] + ".");
                    }
                finally{ continue;}
            }

        }
    return sum;
    }
}