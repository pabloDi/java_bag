package src.bag.testprograms;

import src.bag.arraybag.ArrayBag;

public class GuessingGame {

    public static void main(String[] args) {
        ArrayBag<String> secretBag = new ArrayBag<String>(4);
        secretBag.add("forste");
        secretBag.add("andre");
        Object[] elements = secretBag.toArray();
        for (int i = 0; i < elements.length; i++) {
            System.out.println(elements[i]);
        }

        System.out.println(secretBag.isEmpty());
        secretBag.clear();
        System.out.println(secretBag.isEmpty());

    }

}
