package by.oz.constants;

public enum WaitTime {
   MIN(1),
   AVG(30),
   MAX(60);

    public final int value;


    WaitTime(int value) {
        this.value = value;
    }
}
