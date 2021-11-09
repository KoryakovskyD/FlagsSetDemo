package avalon.javapp.devj110;

public class Main {
    public static void main(String[] args) {
        FlagsSet flagsSet = new BooleanArray();
        flagsSet.set(2);
        flagsSet.set(3);
        flagsSet.set(5);
        flagsSet.set(8);
        flagsSet.set(11);
        flagsSet.set(13);
        flagsSet.set(18);
        flagsSet.flip(10);
        flagsSet.flip(11);

        System.out.println(flagsSet.count());
        System.out.println(flagsSet.toString().substring(0, 50));

        flagsSet.clear(5);
        flagsSet.clear(6);
        flagsSet.set(7, true);

        System.out.println(flagsSet.count());
        System.out.println(flagsSet.toString().substring(0, 50));
        System.out.println(flagsSet.get(1));
        System.out.println(flagsSet.get(2));
        System.out.println("-------------------BitSet-------------------------\n\n");

        FlagsSet flagsSet1 = new BitSet();


        flagsSet1.set(2);
        flagsSet1.set(3);
        flagsSet1.set(5);
        flagsSet1.set(8);
        flagsSet1.set(11);
        flagsSet1.set(13, true);
        flagsSet1.set(18, false);
        flagsSet1.set(20, true);
        System.out.println("count=" + flagsSet1.count());
        System.out.println(flagsSet1.toString().substring(0, 30));


        flagsSet1.flip(8);
        flagsSet1.clear(11);
        flagsSet1.clear(2);
        flagsSet1.clear(2);
        System.out.println("count=" + flagsSet1.count());
        System.out.println(flagsSet1.toString().substring(0, 30));

    }
}
