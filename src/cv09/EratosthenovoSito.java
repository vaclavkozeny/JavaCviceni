package src.cv09;

import java.util.Arrays;
public class EratosthenovoSito {
    public static void main(String[] args) {
        int k = 1_000;
        boolean[] jePrvocislo = new boolean[k];
        Arrays.fill(jePrvocislo, true);
        //long startTime = System.nanoTime();
        for(int i = 2; i<k;i++){
            if(jePrvocislo[i]){
                for(int j = (int)Math.pow(i,2); j<k; j+=i){
                    jePrvocislo[j] = false;
                }
            }
        }
        //long endTime = System.nanoTime() - startTime;
        //System.out.println(endTime);
        System.out.format("Prvočísla menší než %d:\n",k);
        for (int i = 2; i < k; i++) {
            if (jePrvocislo[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
