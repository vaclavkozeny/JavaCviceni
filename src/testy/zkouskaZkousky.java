package src.testy;

public class zkouskaZkousky {
    public static void main(String[] args){
        int[][] mat = new int[][]{{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        int[] pole = new int[]{-3,-6,-9,-27,-99,-15};
        vypisMatice(mat);
        System.out.println();
        reverseHorizontaly(mat);
        vypisMatice(mat);
        System.out.println();
        System.out.println(onlyNeg(pole));
    }
    public static void reverseHorizontaly(int[][]a){
        int temp;
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length/2; j++) {
                temp = a[j][i];
                a[j][i] = a[a.length-1-j][i];
                a[a.length-1-j][i] = temp;
            }
        }
    }
    public static boolean onlyNeg(int[]a){
        for (int i = 0; i < a.length; i++) {
            if(!(a[i] < 0 && Math.abs(a[i])%3==0)){
                return false;
            }
        }
        return true;
    }
    private static void vypisMatice(int[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                System.out.format("%2d ",mat[i][j]);
            }
            System.out.println();
        }
    }
}
