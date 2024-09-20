package ss10_dsa_danh_sach.bai_tap.array_list;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }
    public MyList(int capacity){
        elements = new Object[capacity];
    }
    public void ensureCapacity(int minCapacity){

    }

    public void add(int index, E element){
        E[] newElements = (E[]) new Object[size+1];

    }
}
