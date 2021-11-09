package avalon.javapp.devj110;

public class BitSet implements FlagsSet{
    private final int[] bits = new int[SIZE / 32];


    @Override
    public boolean get(int index) {
        checkIndex(index);
        int bitsNdx = index / 32;
        int bitNdx = index % 32;
        return ((bits[bitsNdx] >> bitNdx) & 1) == 1;
    }

    @Override
    public void set(int index) {
        checkIndex(index);
        set(index, true);
    }

    @Override
    public void set(int index, boolean value) {
        checkIndex(index);
        int bitsNdx = index / 32;
        int bitNdx = index % 32;
        if (value)
            bits[bitsNdx] |= (1 << (bitNdx));
         else
            bits[bitsNdx] &=~ (1 << (bitNdx));
    }

    @Override
    public void clear(int index) {
        checkIndex(index);
        set(index, false);
    }

    @Override
    public void flip(int index) {
        checkIndex(index);
        bits[index / 32] ^= (1 << (index % 32));
    }

    @Override
    public int count() {
        int res = 0;

        for (int i = 0; i < SIZE; i++)
            if (get(i)) res++;
        return res;
     }

    private void checkIndex(int index) {
        if (index < 0 || index >= SIZE)
            throw new IllegalArgumentException("Flag index is out of range.");
    }

    @Override
    public String toString() {
        char[] ac = new char[SIZE];
        for (int i = 0; i < SIZE; i++)
            ac[i] = (get(i)) ? '1' : '0';
        return new String(ac);
    }
}
