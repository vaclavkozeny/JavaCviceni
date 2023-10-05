package src.cv02;

public class CelaCisla {
    public static void main(String[] args) {
        //--------------1--------------
        int a,b;
        a = 459;
        b = 55;
        System.out.format("Pred vymenou %d %d %n", a,b);
        //vymena
        int tempA = a;
        a = b;
        b = tempA;
        System.out.format("Po vymene %d %d %n", a,b);
        //--------------2--------------
        a++;
        System.out.println(a);
        //--------------3--------------
        /*
        pro zadaný počet řádků a sloupců dvourozměrné tabulky a pro zadané pořadí konkrétní pozice v tabulce
        poskytnou číslo řádku a sloupce této pozice;
         */
        int ps,pr,poradi;
        pr = 4;
        ps = 5;
        poradi = 7;
        int s = poradi % ps;
        int r = poradi / pr;
        System.out.println(s + " " + r);
        //--------------4--------------
        r = 1;
        s = 1;
        poradi = r*ps + s;
        System.out.println(poradi);
        //--------------5--------------
        a = 0;
        int n = 5;
        for(int i = 0; i <20;i++){
//            a++;
//            if(a > n){
//                a = 1;
//            }
            a = a % n + 1;
            System.out.println(a);

        }
        //--------------6--------------
        a = 975;
        b = 6;
        boolean Out = (a%b) == 0;
        System.out.println(Out);
    }
}
