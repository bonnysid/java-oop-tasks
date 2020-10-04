package Tasks_1;

public class Time {
    private int seconds;
    private int minutes;
    private int hours;

    public  Time(int seconds) {
        setSec(seconds);
    }

    public Time(int hours, int minutes, int seconds) {
        this(hours * 60 * 60 + minutes * 60 + seconds);
    }

    public void setSec(int seconds) {
        if (seconds < 0) throw new IllegalArgumentException("Time cannot be less than 0");
        else this.seconds = seconds;
        this.hours = (seconds / (60 * 60)) % 24;
        this.minutes = (seconds / 60) % 60;
    }

    public int getHours() { return hours; }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    private String getZero(int x) {
        return x < 10 ? "0" + x : Integer.toString(x);
}

    @Override
    public String toString() {
        return getZero(hours) + ":" + getZero(minutes) + ":" + getZero(seconds % 60);
    }
}
