package src.bag.arraybag;

import src.bag.BagInterface;

public final class LinkedBag<T> implements BagInterface<T> {

    private Node firstNode; // references the first Node
    private int numberOfEntries;

    // Default constructor
    public LinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean add(T newEntry) { // OutOfMemoryError possible
        Node newNode = new Node(newEntry);
        newNode.next = firstNode; // Make the new node reference the rest of the chain
        firstNode = newNode; // New node is at the beginning of chain
        numberOfEntries++;
        return true;
    }

    @Override
    public T remove() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean remove(T anEntry) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public int getFrequencyOf(T anEntry) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean contains(T anEntry) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public T[] toArray() {
        // This cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries]; // Unchecked cast
        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = currentNode.data;
            index++;
            currentNode = currentNode.next;
        }
        return result;
    }

    /*
     * I did not include a default constructor, because i do not need one. Because
     * Node will be an inner class, the generic type T will be the same the generic
     * type declared by the outer class that contains Node. Thus, we do not write
     * <T> after Node. If, however, Node was not an inner class, but instead had
     * public access or package access, you should write Node<T>. In that case, Node
     * would also require set and get methods for its data fields
     */
    private class Node {
        private T data; // Entry in the bag
        private Node next; // Link to next node

        private Node(T dataPortion) {
            this(dataPortion, null);
        }

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }
    }

}