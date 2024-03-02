package src.leto.cv01.pokladny;

public class PokladnickaOtviratelna {
    boolean open;
    int amount;

    public PokladnickaOtviratelna() {
    }

    public PokladnickaOtviratelna(int a) {
        kontrolaCastky(a);
        this.amount = a;
    }

    public void Vlozit(int a){
        kontrolaCastky(a);
        this.amount += a;
    }
    public int Vybrat(int a){
        kontrolaCastky(a);
        a = Math.min(amount, a);
        this.amount -= a;
        return a;
    }

    public double getAmount() {
        return amount;
    }
    private void kontrolaCastky(int c){
        if(c < 0)
            throw new IllegalArgumentException("Zaporna castka" + c);
    }
}
