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

        for (int i = 0; i < SIZE/32; i++) {
            for (int j = 0; j <= 31; j++) {
                if (((bits[i] >> j) & 1) == 1) res++;
            }
        }
        return res;
    }

    // не для задания, просто чтобы разобраться в теме
    public int countSetBits(int number){
        int count = 0;
        while(number>0){
            int result = number & 1;
            count += result;
            number >>= 1;
        }
        return count;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= SIZE)
            throw new IllegalArgumentException("Flag index is out of range.");
    }

    @Override
    public String toString() {
        int counter=0;
        char[] ac = new char[SIZE];
        for (int i = 0; i < SIZE/32; i++) {
            for (int j = 0; j < 32; j++) {
                ac[counter] = (((bits[i] >> j) & 1) == 1) ? '1' : '0';
                counter++;
            }
        }
        return new String(ac);
    }
}
