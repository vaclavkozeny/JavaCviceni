package src.leto.cv03.Matematika;

public class MainClass {
    public static void main(String[] args) {
        Zlomek zlomek = new Zlomek(18,7);
        System.out.println(zlomek);
        System.out.println(zlomek.secti(new Zlomek(7,18)).toDouble());
    }
}
