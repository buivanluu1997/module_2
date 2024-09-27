package ss15_xu_li_ngoai_le_debug.Test;

public class NewTriangle {
    private int a;
    private int b;
    private int c;

    public NewTriangle(int a, int b, int c) throws IllegalTriangleException {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("tong 2 canh tam giac phai lon hon canh con lai");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "NewTriangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
