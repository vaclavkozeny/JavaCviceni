package src.leto.cv03.Matematika;

public class Zlomek {
    final int citatel;
    final int jmenovatel;

    public Zlomek(int citatel, int jmenovatel) {
        if(jmenovatel == 0)
            throw new IllegalArgumentException("Nulovy jmenovatel");
        int nsd = MathTools.nejvetsiSpolecnyDelitel(citatel, jmenovatel);
        this.citatel = citatel / nsd;
        this.jmenovatel = jmenovatel / nsd;
    }
    public double toDouble(){
        return (double) citatel /jmenovatel;
    }
    public String toString(){
        return String.format("%d/%d",citatel,jmenovatel);
    }
    public boolean equals(Zlomek zlomek){
        return this.citatel == zlomek.citatel && this.jmenovatel == zlomek.jmenovatel;
    }
    public Zlomek secti(Zlomek zlomek){
        int cit = (this.citatel * zlomek.jmenovatel) + (zlomek.citatel * this.jmenovatel);
        int jm = this.jmenovatel * zlomek.jmenovatel;
        return new Zlomek(cit, jm);
    }
    public Zlomek odecti(Zlomek zlomek){
        int cit = (this.citatel * zlomek.jmenovatel) - (zlomek.citatel * this.jmenovatel);
        int jm = this.jmenovatel * zlomek.jmenovatel;
        return new Zlomek(cit, jm);
    }
}
