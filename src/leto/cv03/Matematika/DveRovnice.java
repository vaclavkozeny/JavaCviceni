package src.leto.cv03.Matematika;

public class DveRovnice {
    double a1;
    double a2;
    double b1;
    double b2;
    int Det;

    public DveRovnice(int a1, int b1, int a2, int b2){
        this.a1 = a1;
        this.b1 = b1;
        this.a2 = a2;
        this.b2 = b2;
        Det = (a1*b2)-(b1*a2);
    }
    public double[] dejReseni(int c1,int c2){
        if(existujeReseni())
            return new double[] {((b2 * c1) - (b1 * c2)) /Det, ((a1 * c1) - (a2 * c2)) /Det};
        throw new IllegalArgumentException("Nema reseni");
    }
    private boolean existujeReseni(){
        if(Det==0){
            return false;
        }
        else
            return true;
    }
}
