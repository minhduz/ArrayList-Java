import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        MyArrayList<Integer> aList = new MyArrayList<>();
        Random rd = new Random();
        for (int i = 0; i < 20; i++) {
            aList.add(rd.nextInt(21));
        }
        System.out.println(aList.toString());
        System.out.println("Size of the list: " + aList.size());
        aList.removeAt(2);
        System.out.println(aList.toString());
        System.out.println("Size of the list: " + aList.size());


    }
}