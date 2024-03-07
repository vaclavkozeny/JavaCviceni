package src.leto.cv03.Matematika;

public class MainClass {
    public static void main(String[] args) {
        DveRovnice dveRovnice = new DveRovnice(4,-1,-3,2);
        System.out.format("Reseni je x = %f, y = %f",dveRovnice.dejReseni(4,3)[0], dveRovnice.dejReseni(4,3)[1]);
    }
}
