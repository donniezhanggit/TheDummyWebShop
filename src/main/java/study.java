import java.lang.*;
import java.util.*;


public class study {

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<Integer>(3);

        integerList.add(19);
        integerList.add(5);
        integerList.add(1978);

        for (Iterator<Integer> i = integerList.iterator(); i.hasNext();) {
            int value = i.next();
            System.out.println(value);
        }

        List<String> stringList = new ArrayList<String>(4);
        //stringList.iterator();




        String[] strings = new String[3];
        strings[0] = "ciao";
        strings[1] = "forse";
        strings[2] = "bye";

        for (String sentence:strings) {
            System.out.print(sentence+" ");
        }

        Character[] characters = new Character[3];
        characters[0] = 'b';
        characters[1] = 'y';
        characters[2] = 'e';

        for (char letter:characters) {
            System.out.print(letter+" ");
        }

        Integer[] integers = new Integer[3];
        integers[0] = 1;
        integers[1] = 2;
        integers[2] = 3;

        for (int i = 0; i < integers.length; i++) {
            System.out.print(integers[i]);
        }







    }



}
