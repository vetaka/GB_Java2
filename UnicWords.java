package geekbrains.couse2;
/*1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся). Найти и вывести список
		уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово.
 */

import java.util.*;


public class UnicWords {

    public static void main(String[] args) {
        String [] listOfWords = {"dog", "cat", "monkey", "monkey","elephant", "dog", "cat", "mouse","dog", "cat", "cat", "dog"};
        Set<String> setWords = new HashSet<>(Arrays.asList(listOfWords));
        System.out.println(setWords);
        System.out.println(numberOfTimes(listOfWords));
    }

    public static Map<String, Long> numberOfTimes(String[] args) {
        Map<String, Long> numberTimes = new HashMap<>();
        List<String> words = Arrays.asList(args);
        Set<String> setWords = new HashSet<>(words);
        for(String s: setWords) {
            numberTimes.put(s, (long)Collections.frequency(words, s));
        }

        return numberTimes;
    }

}

