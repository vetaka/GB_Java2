package geekbrains.couse2;

public class MyArraySizeException extends Exception{
    public MyArraySizeException(String message){
        super(message);
        System.out.println(message);

    }
}
