package src.bag.testprograms;

import src.bag.arraybag.ArrayBag;
import src.bag.BagInterface;

public class arrayBagDemo {
    public static void main(String[] args) {
        BagInterface<String> aBag = new ArrayBag<>();
        aBag = new ArrayBag<>(7);
        aBag.add("1");
        aBag.add("2");
        aBag.add("3");

        Object[] bagArray = aBag.toArray();
        for (int index = 0; index < bagArray.length; index++) {
            System.out.println(bagArray[index]);
        }

    }
}