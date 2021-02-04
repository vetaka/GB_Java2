package geekbrains.couse2;

public class MyArrayDataException extends Exception {
    MyArrayDataException(String message){
        super(message);
        System.out.println(message);
    }
}
