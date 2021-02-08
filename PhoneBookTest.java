package geekbrains.couse2;

public class PhoneBookTest {

    public static void main(String[] args) {
        PhoneBook1 book = new PhoneBook1();
        book.add("Ivan", "+12345678");
        book.add("Max", "+91011121");
        book.add("Ann", "+77777777");
        book.add("Ann", "+88888888");
        System.out.println(book.getNumber("Ivan"));
        System.out.println(book.getNumber("Ann"));
        System.out.println(book.getNumber("Max"));
    }

}
