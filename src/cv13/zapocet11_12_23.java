package src.cv13;

public class zapocet11_12_23 {
    public static void main(String[] args) {
        int[] pal = createPalindrom(new int[]{1, 2, 3,4,5});
        vypisPole(pal);
        System.out.println(constantSumNextTwo(new int[]{12,2,5,9,7,7}));
        System.out.println(testEven(new int[][]{{2,4,6,8},{10,12,14,16},{18,20,22,24},{26,28,30,32}}));
        vypisMatice(alter01(3,5));
    }
    public static int[]  createPalindrom(int[]a){
        int[] ret = new int[a.length + (a.length -1)];
        for (int i = 0; i < a.length; i++) {
            ret[i] = a[i];
        }
        for (int i = 0; i < a.length-1; i++) {
            ret[ret.length-1-i] = a[i];
        }
        return ret;
    }
    public static boolean constantSumNextTwo(int[]a){
        int lastsum = a[0] + a[1];
        int sum;
        for (int i = 0; i < a.length; i = i+2) {
            sum = a[i] + a[i+1];
            if(lastsum != sum){
                return false;
            }
        }
        return true;
    }
    public static boolean testEven(int[][]a){
        int lastDigit = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if(a[i][j] != lastDigit+2){
                    return false;
                }
                lastDigit = a[i][j];
            }
        }
        return true;
    }
    public static int[][] alter01(int radky, int sloupce){
        int[][] ret = new int[radky][sloupce];
        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < ret[0].length; j++) {
                if(i%2==0){
                    if(j%2==0){
                        ret[i][j] = 0;
                    }else {
                        ret[i][j] = 1;
                    }
                }else{
                    if(j%2==0){
                        ret[i][j] = 1;
                    }else {
                        ret[i][j] = 0;
                    }
                }
            }
        }
        return ret;
    }
    private static void vypisPole(int[] pole){
        for(int i=0;i<pole.length;i++){
            System.out.format("%d ",pole[i]);;
        }
        System.out.println();
    }
    private static void vypisMatice(int[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                System.out.format("%s ",mat[i][j]);
            }
            System.out.println();
        }
    }
}
