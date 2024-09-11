package ss3_mang_va_phuong_thuc_trong_java.test;

public class test_them_ptu_vao_mang {
    public static void main(String[] args) {
       int[] arr = {10, 4, 6, 7, 8, 0, 0, 0, 0, 0};
       int[] newArray = insert(arr, 3, 4);
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
    }
    public static int [] insert(int[] arr, int index, int number) {
        if (index < 0 || index > arr.length-1) {
            return arr;
        } else {
            int newLength = arr.length+1;
            int[] newArr = new int[newLength];
            for (int i = 0; i < index; i++) {
                newArr[i] = arr[i];
            }
            newArr[index] = number;
            for (int i = index+1; i < newLength; i++) {
                newArr[i] = arr[i-1];
            }
            return newArr;
        }
    }
}
