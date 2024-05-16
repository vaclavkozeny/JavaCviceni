package src.leto.cv13;

import java.util.Scanner;

public class MujSeznam {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
//        Slovo head;
//        head = new Slovo("prvni", new Slovo("druhe", new Slovo("treti")));
//        Vypis(head);
//        System.out.println("\nZaznamy pro pridani");
//        head = null;
//        String radek;
//        while((radek = new Scanner(System.in).nextLine()).length() > 0){
//            head = new Slovo(radek, head);
//        }
//        System.out.println("\nVypis zaznamu");
//        Vypis(head);
        josephusProblem(10, 3);

    }

    private static void Vypis(Slovo tmp) {
        while(tmp != null){
            System.out.println(tmp.slovo);
            tmp = tmp.dalsi;
        }
    }
    private static int josephusProblem(int n, int k) {
        Josef head = new Josef(1);
        Josef tail = new Josef(n,head);
        for (int i = 2; i <= n; i++) {
            head = new Josef(i, head);
        }
        vypisJosefa(head);
        return 0;
    }
    private static void vypisJosefa(Josef josef) {
        Josef tmp = josef;
        do{
            System.out.println(tmp.num);
            tmp = tmp.next;
        }while(tmp != josef);
    }
    private static class Josef {
        int num;
        Josef next;
        public Josef(int num) {
            this(num, null);
        }
        public Josef(int num, Josef next) {
            this.num = num;
            this.next = next;
        }
    }

    public static class Slovo{
        String slovo;

        public Slovo(String slovo) {
            this(slovo, null);
        }
        public Slovo(String slovo, Slovo dalsi) {
            this.slovo = slovo;
            this.dalsi = dalsi;
        }
        Slovo dalsi;
    }
}

