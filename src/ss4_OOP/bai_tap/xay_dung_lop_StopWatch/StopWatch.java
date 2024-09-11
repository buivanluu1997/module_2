package ss4_OOP.bai_tap.xay_dung_lop_StopWatch;

public class StopWatch {
    private long starTime;
    private long endTime;
    public StopWatch() {
        this.starTime = System.currentTimeMillis();
    }
    public void star() {
        this.starTime = System.currentTimeMillis();
    }
    public void stop() {
        this.endTime = System.currentTimeMillis();
    }
    public long getElapsedTime() {
        return this.endTime - this.starTime;
    }
}
