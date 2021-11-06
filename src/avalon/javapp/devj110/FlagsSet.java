package avalon.javapp.devj110;

public interface FlagsSet {

    //public static final необязательно писать
    int SIZE = 1024;

    boolean get(int index);
    void set(int index);
    void set(int index, boolean value);
    void clear(int index);
    void flip(int index);
    int count();
    String toString();
}
