package geekbrains.couse2;
/*2	Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get()
искать номер телефона по фамилии. Следует учесть, что под одной фамилией может
 несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны

*/

import java.util.ArrayList;
        import java.util.List;
        import java.util.Map;
        import java.util.TreeMap;

public class PhoneBook1 {
    private Map<String, List<String>> phoneBook1;


    public PhoneBook1() {
        phoneBook1 = new TreeMap<>();
    }

    public void add(String name, String number) {
        if(phoneBook1.containsKey(name)) {
            phoneBook1.get(name).add(number);
        }
        else {
            List <String> numbers = new ArrayList<>();
            numbers.add(number);
            phoneBook1.put(name, numbers);
        }
    }

    public List<String> getNumber(String name){
        return phoneBook1.get(name);
    }

}
