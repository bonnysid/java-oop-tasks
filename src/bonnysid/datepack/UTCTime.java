package bonnysid.datepack;

public class UTCTime extends Time {
    private int utcHours;
    private int utcMin;

    public UTCTime(int sec, int utcHours) {
        super(sec + (utcHours * 60 * 60));
        setTimeZone(utcHours);
    }

    public UTCTime(int hours, int minutes, int seconds, int utcHours) {
        super((hours + utcHours) % 24, minutes, seconds);
        setTimeZone(utcHours);
    }

    public UTCTime(int hours, int minutes, int seconds, int utcHours, int utcMin) {
        super((hours + utcHours) % 24, minutes + utcMin, seconds);
        setTimeZone(utcHours, utcMin);
    }

    public UTCTime setTimeZone(int utcHours) {
        if (utcHours < -12 || utcHours > 14) throw new IllegalArgumentException("UTC cannot be less than 12 and more than 14!");
        this.utcHours = utcHours;
        return this;
    }

    public UTCTime setTimeZone(int utcHours, int utcMin) {
        if (utcHours < -12 || utcHours > 14 || utcMin < 0) throw new IllegalArgumentException("UTC cannot be less than 12 and more than 14!");
        this.utcHours = utcHours;
        this.utcMin = utcMin % 60;
        return this;
    }

    public String getTimeZone() { return "(" + getZero(utcHours) + ":" + getZero(utcMin) + " UTC);"; }


    @Override
    public String toString() {
        return super.toString() + "(" + getZero(utcHours) + ":" + getZero(utcMin) + " UTC);";
    }
}
