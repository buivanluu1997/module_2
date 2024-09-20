package ss10_dsa_danh_sach.bai_tap.array_list;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    // Khởi tạo danh sách với dung lượng mặc định
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // Khởi tạo danh sách với dung lượng xác định bởi tham số capacity
    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    // Thêm phần tử vào vị trí index
    public void add(int index, E element) {
        E[] newElement = (E[]) new Object[size + 1];
        for (int i = 0; i < index; i++) {
            newElement[i] = (E) elements[i];
        }
        newElement[index] = element;
        for (int i = index; i < size; i++) {
            newElement[i + 1] = (E) elements[i];
        }
        elements = newElement;
        size++;
    }

    // Xóa phần tử tại vị trí index và trả về phần tử đó;
    public E remove(int index) {
        E removeElement = (E) elements[index];

        E[] newElement = (E[]) new Object[size - 1];

        for (int i = 0; i < index; i++) {
            newElement[i] = (E) elements[i];
        }
        for (int i = index; i < size - 1; i++) {
            newElement[i] = (E) elements[i + 1];
        }
        elements = newElement;
        size--;
        return removeElement;
    }

    // Trả về số lượng phần tử trong danh sách
    public int size() {
        return size;
    }

    // Trả về bản sao của danh sách
    public MyList<E> clone() {
        MyList<E> clone = new MyList<E>(size);
        for (int i = 0; i < elements.length; i++) {
            clone.elements[i] = elements[i];
        }
        clone.size = size;
        return clone;
    }

    // Kiểm tra danh sách có chứa phần tử o không
    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }

    // Trả về chỉ số của phần tử đầu tiên bằng o
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    // Thêm vào cuối danh sách
    public boolean add(E o) {
        E[] newElement = (E[]) new Object[size + 1];
        for (int i = 0; i < size; i++) {
            newElement[i] = (E) elements[i];
        }
        newElement[newElement.length - 1] = o;
        elements = newElement;
        size++;
        return true;
    }


    // Đảm bảo dung lượng của danh sách ít nhất bằng minCapacity
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newSize = elements.length * 2;
            E[] newElement = (E[]) new Object[newSize];
            for (int i = 0; i < elements.length; i++) {
                newElement[i] = (E) elements[i];
            }
        }
    }

    // Trả về phần tử tại vị trí i
    public E get(int i) {
        if (i < 0 || i > size) {
            return null;
        }
        return (E) elements[i];
    }

    // Xóa tất cả các phần tử trong danh sách
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    // Phương thức hiển thị danh sách
    @Override
    public String toString() {
        return "MyList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }
}
