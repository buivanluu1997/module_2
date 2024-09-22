package ss11_dsa_stack_queue.thuc_hanh.queue_su_dung_mang;

public class MyQueue {
    private int capacity; //lưu kích thước tối đa của hàng đợi
    public int[] queueArr; //lưu trữ các phần tử trong hàng đợi
    private int head = 0; //lưu trữ chỉ số của phần tử đầu tiên trong hàng đợi
    private int tail = -1; //lưu trữ chỉ số của phần tử cuối cùng trong hàng đợi
    private int currentSize = 0; //theo dõi số lượng phần tử hiện tại trong hàng đợi.

    public MyQueue(int queueSize) {
        this.capacity = queueSize;
        queueArr = new int[this.capacity];
    }

    //kiểm tra hàng đợi có đạt đến kích thước tối đa hay chưa
    public boolean isQueueFull() {
        boolean status = false;
        if (currentSize == capacity) {
            status = true;
        }
        return status;
    }

    //kiểm tra xem hàng đợi có chứa phần tử nào hay không
    public boolean isQueueEmpty() {
        boolean status = false;
        if (currentSize == 0) {
            status = true;
        }
        return status;
    }

    //thêm 1 đối tượng vào
    public void enqueue(int item) {
        if (isQueueFull()) {
            System.out.println("Hàng đợi đã đạt kích thước tối đa, không thể thêm phần tử: " + item);
        } else {
            tail++;
            if (tail == capacity-1) {
                tail = 0;
            }
            queueArr[tail] = item;
            currentSize++;
            System.out.println("Phần tử: " + item + " đã thêm vào");
        }
    }


    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Hàng đợi rỗng, Nên không thể xoá được");
        } else {
            head++;
            if (head == capacity-1) {
                System.out.println("Phan tu da duoc xoa: " + queueArr[capacity-1]);
                head = 0;
            } else {
                System.out.println("Phan tu da duoc xoa: " + queueArr[capacity-1]);
            }
        }
        currentSize--;
    }
}
