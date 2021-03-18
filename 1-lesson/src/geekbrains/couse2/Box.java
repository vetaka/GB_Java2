package geekbrains.couse2;

import java.util.ArrayList;
import java.util.Arrays;
// Класс Box, в который можно складывать фрукты.
// Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
public class Box<T extends Frut> {
    ArrayList<T> box = new ArrayList();
    private T[] fruts;
// конструктор коробки
    public Box(T... fruts) {  // один и более параметров или массив
        box = new ArrayList<>(Arrays.asList(fruts));
        this.fruts = fruts;
    }
// геттер
    public ArrayList<T> getBox() {
        return box;
    }
// метод Добавить фрукт
    public void addFrut(T frut) {
        box.add(frut);
    }
//  М-д Получения веса коробки
    public float getWeight() {
        float sumWeight = 0.0f;
        for (int i = 0; i < box.size(); i++) {
            sumWeight = sumWeight + box.get(i).getWeight();
        }
        return sumWeight;
    }

    public boolean compare(Box<? extends Frut> boxWithSomething) {
        return Math.abs(getWeight() - boxWithSomething.getWeight()) < 0.0001f;
    }

    public void addAllFruitsToAnotherBox(Box<T> anotherBox) {
        anotherBox.box.addAll(this.box);
        this.box.clear();
    }
}