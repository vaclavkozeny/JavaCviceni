package src.leto.cv04.polynomy;

public class PolynomyApp {
    public static void main(String[] args) {
        Polynom polynom = new Polynom(1, 2, 3, 4);
        Polynom polynom2 = new Polynom(1, 2, 3, 4);
        //System.out.println(polynom.toStringFmt());
        System.out.println(Polynomy.soucet(polynom, polynom2).toStringFmt(2));
        System.out.println(Polynomy.soucin(polynom,polynom2).toStringFmt(2));
    }
}
