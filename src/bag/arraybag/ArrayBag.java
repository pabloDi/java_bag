package src.bag.arraybag;

import src.bag.BagInterface;

public final class ArrayBag<T> implements BagInterface<T> {

    private final T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;
    private boolean initialized = false;
    private static final int MAX_CAPACITY = 10000; // Random default capacity

    /** Creates an empty bag whose initial capacity is at 25 */
    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    /** End default constructor */

    /**
     * Creates an empty bag having a given initial capacity
     * 
     * @param capacity The initial capacity desired
     */
    public ArrayBag(int capacity) {
        if (capacity <= MAX_CAPACITY) {
            /* This cast is safe because the new array contains null entries */
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[]) new Object[capacity]; // Unchecked cast
            bag = tempBag;
            numberOfEntries = 0;
            initialized = true;
        } else {
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds allowed maximum");
        }

    }

    /**
     * Adds a new entry to this bag
     * 
     * @param newEntry The object to be added as a new entry.
     * @return True if the addition is successful, or false if not
     */
    public boolean add(T newEntry) {
        checkInitialization();
        boolean result = true;
        if (isArrayFull()) {
            result = false;
        } else {
            // Assertion: Result is true here
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        } // end If
        return result;

    } // End function

    public T remove() {
        checkInitialization();
        T result = removeEntry(numberOfEntries - 1);
        return result;
    }

    public boolean remove(T anEntry) {
        checkInitialization();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    }

    private T removeEntry(int givenIndex) {
        T result = null;
        if (!isEmpty() && (givenIndex >= 0)) {
            result = bag[givenIndex]; // Entry to remove
            bag[givenIndex] = bag[numberOfEntries - 1]; // Replace entry with last entry
            bag[numberOfEntries - 1] = null; // Remove last entry
            numberOfEntries--;
        }
        return result;
    }

    private int getIndexOf(T anEntry) {
        boolean found = false;
        int index = 0;
        int where = -1;
        while (!found && index < numberOfEntries) {
            if (anEntry.equals(bag[index])) {
                found = true;
                where = index;
            }
            index++;
        }
        return where;
    }

    public void clear() {
        while (!isEmpty()) {
            remove(); // Removes random entry, checks initialization
        }
    }

    public int getCurrentSize() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public int getFrequencyOf(T anEntry) {
        checkInitialization();
        int counter = 0;
        for (int index = 0; index < numberOfEntries; index++) {
            if (anEntry.equals(bag[index])) {
                counter++;
            }
        }

        return counter;
    }

    public boolean contains(T anEntry) {
        checkInitialization();
        return getIndexOf(anEntry) > -1;
    }

    /**
     * Checks if the bag is full
     * 
     * @return True if the bag is full, false if not
     */
    public boolean isArrayFull() {
        checkInitialization();
        return numberOfEntries >= bag.length;
    }

    public T[] toArray() {
        checkInitialization();
        // This cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries]; // Unchecked cast
        for (int index = 0; index < numberOfEntries; index++) {
            result[index] = bag[index];
        }
        return result;
    }

    private void checkInitialization() {
        if (!initialized) {
            throw new SecurityException("Array bag is not initialized properly");
        }
    }

}