package src.leto.cv01.pokladny;

public class PokladnickaNeotviratelna {
    private int amount;
    private boolean rozbita;

    public PokladnickaNeotviratelna(int amount) {
        this.amount = amount;
        this.rozbita = false;
    }
    public PokladnickaNeotviratelna() {
    }
    public void Vlozit(int a){
        kontrolaCastky(a);
        if(rozbita)
            throw new IllegalStateException("Pokladna již byla rozbita");
        this.amount += a;
    }
    public int Vybrat(){
        if(rozbita)
            throw new IllegalStateException("Pokladna již byla rozbita");
        this.rozbita = true;
        return amount;
    }
    private void kontrolaCastky(int c){
        if(c < 0)
            throw new IllegalArgumentException("Zaporna castka" + c);
    }
}
