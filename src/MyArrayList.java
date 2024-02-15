import java.util.Arrays;

public class MyArrayList<T> {

    private Object[] array; //under lying data structure
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList(){
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void add(T element){
        checkCapacity();
        array[size++] = element;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        checkCapacity();

        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = element;
        size++;
    }

    private void checkCapacity(){
        if(size == array.length){
            int newCapacity = array.length * 2;
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    public void remove(T element) {
        int index = findIndex(element);
        if (index != -1) {
            removeAt(index);
        }
    }

    private int findIndex(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public void removeAt(int index){

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        array[size - 1] = null;
        size--;
    }

    public int size(){
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < size; i++) {
            str.append(" ").append(array[i]);
        }
        return str.toString();
    }
}
