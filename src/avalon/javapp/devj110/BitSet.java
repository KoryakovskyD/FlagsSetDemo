package avalon.javapp.devj110;

public class BitSet implements FlagsSet{
    private final int[] bits = new int[SIZE / 32];

    @Override
    public boolean get(int index) {
        checkIndex(index);
        int bitsNdx = index / 32;
        System.out.println("bitsNdx=" + bitsNdx);
        int bit = 1 <<  (index % 32);
        System.out.println("bit=" + bit);
        return (bits[bitsNdx / 32] & bit) != 0;
    }

    @Override
    public void set(int index) {
        checkIndex(index);
        int word = bits[index / 32];
        int posBit = 1 << (index % 32);
        word |= posBit;
    }

    @Override
    public void set(int index, boolean value) {
        checkIndex(index);
        int word = bits[index / 32];
        int posBit = 1 << (index % 32);
        if (value) {
            word |= posBit;
        } else {
            //word &= (0xFFFFFFFF - posBit);
            bits[index / 32] = word;
        }
    }

    @Override
    public void clear(int index) {
        checkIndex(index);
    }

    @Override
    public void flip(int index) {
        checkIndex(index);
    }

    @Override
    public int count() {
        return 0;
    }

    //bitsNdx = index / 32; индекс бита с которым работать
    // bitNdx= index / % 32
    // bit = 1 << bitIndex
    //     = 1 << (index % 32);
    //index = 8;
    //bitsndx = 8 / 32 = 0;
    // bit 1 << (8 %32) = 256 = 0x100
    //    = 0b1_0000_0000
    /*
          https://javarush.ru/groups/posts/2175-java-bits-and-bytes
     */

    private void checkIndex(int index) {
        if (index < 0 || index >= SIZE)
            throw new IllegalArgumentException("Flag index is out of range.");
    }

    @Override
    public String toString() {
        char[] ac = new char[SIZE];
        for (int i = 0; i < bits.length; i++) {
            boolean value = get(i);
            ac[i] = value ? '1' : '0';
        }
        return new String(ac);
    }
}
