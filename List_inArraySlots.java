import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
  Implement a list of integer elements, including
  both data and operations.
 */

public class List_inArraySlots {

    // declare fields here

    private static final int DEFAULT_SIZE = 10;

    private Object[] array;
    private int capacity;

    /**
      Construct an empty list with a small initial capacity.
     */
    public List_inArraySlots() {
        array = new Object[DEFAULT_SIZE];
    }

    public List_inArraySlots(T[] array) {
        int startSize = DEFAULT_SIZE;
        while (startSize < array.length) {
            startSize*=2;
        }
        this.array = new Object[startSize];
        capacity = array.length;
        copy(array);
    }

    private void copy(Object[] array) {
        for (int i = 0; i < Math.min(this.array.length, array.length); i++) {
            this.array[i] = array[i];
        }
    }


    /**
      @return the number of elements in this list
     */
    public int size() {
        return capacity;
    }


     /**
       @return a string representation of this list,
       in [a,b,c,] format
      */
     public String toString() {
         String temp = "[";
         for (int i = 0; i < capacity; i++) {
             //temp += array[i] + (i == capacity - 1 ? "" : ", ");
             temp += array[i] + ",";
         }
         temp += "]";
         return temp;
     }


    /**
      Appends @value to the end of this list.

      @return true, in keeping with conventions yet to be discussed
     */
    public boolean add(Object value) {
        return add(value, capacity);
    }

    public boolean add(Object value, int index) {
        if (index > capacity || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (capacity >= array.length) {
            expand();
        }

        for (int i = capacity; i > index; i--) {
            array[i] = array[i-1];
        }

        array[index] = value;
        capacity++;

        return true;
    }

    public boolean remove(int index) {
        if (index > capacity - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i < capacity; i++) {
            array[i] = array[i+1];
        }

        capacity--;

        return true;
    }

    public T get(int index) {
        if (index > capacity - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (T) array[index];
    }

    public boolean set(int index, Object value) {
        if (index > capacity - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        array[index] = value;

        return true;
    }

    /**
      Double the capacity of the List_inArraySlots,
      preserving existing data
     */
     private void expand() {
        System.out.println( "expand... (for debugging)");

        Object[] oldArray = array;
        array = new Object[oldArray.length * 2];

        copy(oldArray);
     }
}
