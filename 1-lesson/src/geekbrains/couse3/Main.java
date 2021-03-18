package geekbrains.couse3;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) {
                // 1.Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа)
                Integer[] array1 = new Integer[]{1, 2, 3, 4, 5};
                System.out.println("1. Первоначальный массив: " + Arrays.toString(array1));
                exchangeElements(array1, 2, 4);
                System.out.println("Массив с переставленными элементами array: " + Arrays.toString(array1));
                //2. Написать метод, который преобразует массив в ArrayList
                List<Integer> arrList = convertToArrList(array1);
                System.out.println("2. Преобразованный массив " + arrList.toString() + " имеет тип:" + arrList.getClass());
                System.out.println("3. Задача Фрукты");
                // создаем экземпляры фруктов
                Orange orange = new Orange();
                Apple apple = new Apple();
                // создаем  3 коробки (2 с апельсинами и 1 - яблоками)
                Box<Orange> orangeBox1 = new Box();
                Box<Orange> orangeBox2 = new Box();
                Box<Apple> appleBox = new Box();
                // добавим 4 апельсина в 1-ю коробку с апельсинами
                for (int i = 0; i < 4; i++) {
                    orangeBox1.addFrut(new Orange());
                }
                // добавим 7 апельсинов во 2-ю коробку с апельсинами
                for (int i = 0; i < 7; i++) {
                    orangeBox2.addFrut(new Orange());
                }

                // добавим 6 яблок в коробку яблок
                for (int i = 0; i < 6; i++) {
                    appleBox.addFrut(new Apple());
                }

                // получаем вес всех коробок

                System.out.println("Вес коробки 1 с апельсинами: " + orangeBox1.getWeight());
                System.out.println("Вес коробки 2 с апельсинами: " + orangeBox2.getWeight());
                System.out.println("Вес коробки с яблоками: " + appleBox.getWeight());
                // сравниваем веса коробок
                System.out.println("Сравнить вес orangeBox1 и appleBox: " + orangeBox1.compare(appleBox) + " "  +  (orangeBox1.compare(appleBox) ?  " - равны": " - не равны"));
                System.out.println("Сравнить вес orangeBox2 и appleBox: " + orangeBox2.compare(appleBox)+ " "  +  (orangeBox2.compare(appleBox) ?  " - равны": " - не равны"));
                // пересыпаем из 2-й коробки апельсинов в 1-ю
                orangeBox1.addAllFruitsToAnotherBox(orangeBox2);
                System.out.println("После пересыпания из 1-й коробки с апельсинами во 2-ю :");
                System.out.println("Вес коробки 1 с апельсинами: " + orangeBox1.getWeight());
                System.out.println("Вес коробки 2 с апельсинами: " + orangeBox2.getWeight());

    }
// метод перестановки членов массива
    private static <T> void exchangeElements(T[] array,int id1, int id2) {
        T temp = array[id1];
        array[id1] = array[id2];
        array[id2] = temp;

    }
// метод преобразования массива в ArrayList
    private static <E> List<E> convertToArrList(E[] array) {
        return Arrays.asList(array);

    }

}
