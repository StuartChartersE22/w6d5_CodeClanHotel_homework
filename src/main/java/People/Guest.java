package People;

public class Guest {

    private double wallet;

    public Guest(double wallet){
        this.wallet = wallet;
    }


    public double getWallet() {
        return this.wallet;
    }

    public void pay(double cost) {
        this.wallet -= cost;
    }
}
