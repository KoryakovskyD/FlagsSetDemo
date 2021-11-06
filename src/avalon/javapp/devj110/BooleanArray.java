package avalon.javapp.devj110;

// можно дописать abstract, тогда не надо реализовывать все методы
public class BooleanArray implements FlagsSet{

    private final boolean[] values = new boolean[SIZE];

    @Override
    public boolean get(int index) {
        checkIndex(index);
        return values[index];
    }

    @Override
    public void set(int index) {
        checkIndex(index);
        values[index] = true;
    }

    @Override
    public void set(int index, boolean value) {
        checkIndex(index);
        values[index] = value;
    }

    @Override
    public void clear(int index) {
        checkIndex(index);
        values[index] = false;
    }

    @Override
    public void flip(int index) {
        checkIndex(index);
        values[index] = !values[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= SIZE)
            throw new IllegalArgumentException("Flag index is out of range.");
    }

    @Override
    public int count() {
        int res= 0;
        for (int i =0; i < values.length; i++) {
            boolean value = values[i];
            if (value)
                res++;
        }
        return res;
    }

    @Override
    public String toString() {
        char[] ac = new char[SIZE];
        for (int i = 0; i < values.length; i++) {
            boolean value = values[i];
            ac[i] = value ? '1' : '0';
        }
        return new String(ac);
    }

}
