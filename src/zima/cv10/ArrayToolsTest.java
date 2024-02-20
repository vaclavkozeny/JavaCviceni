package src.zima.cv10;



public class ArrayToolsTest {
    public static void main(String[] args) {
        int[] IntegerArray = {15,1,1,1,1,12,13};
//        System.out.println(ArrayTools.maximum(IntegerArray));
//        System.out.println(ArrayTools.poziceVyskytu(IntegerArray,4,0,15));
//        printArray(IntegerArray);
//        ArrayTools.sort(IntegerArray);
//        printArray(IntegerArray);
//        long startTime = System.nanoTime();
//        System.out.println(ArrayTools.vyskytVUspo(IntegerArray,16,48));
//        long endTime = System.nanoTime() - startTime;
//        System.out.println((double)endTime / 1_000);
        System.out.println(ArrayTools.pocetRuznychUsp(IntegerArray));
        int[] b = ArrayTools.getReversed(IntegerArray);
        printArray(b);
        ArrayTools.reverse(b);
        printArray(b);
    }
    private static void printArray(int[]a){
        for (int i:a) {
            System.out.format("%d ",i);
        }
        System.out.format("\n");
    }
}

