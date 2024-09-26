package ss14_thuat_toan_sap_xep.bai_tap.cai_dat_tt_sx_chen;

public class InsertionSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    public static void insertionSort(int[] array) {
        int pos, x;
        for(int i = 1; i < array.length; i++){ //đoạn array[0] đã sắp xếp
            x = array[i];
            pos = i;
            while(pos > 0 && x < array[pos-1]){
                array[pos] = array[pos-1]; // đổi chỗ
                pos--;
            }
            array[pos] = x;
        }
    }

    public static void main(String[] args) {
        System.out.println("Mảng trước khi sắp xếp: ");
        for (int item : list) {
            System.out.print(item + " ");
        }
        System.out.println("\nMảng sau khi sắp xếp là: ");
        insertionSort(list);
        for (int value : list) {
            System.out.print(value + " ");
        }
    }
}

