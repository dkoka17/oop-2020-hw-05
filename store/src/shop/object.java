package shop;

public class object {
    private int number;
    private product product;

    public object(product product,int number) {
        this.product = product;
        this.number = number;
    }
    public void changeNumber(int number) {
        this.number = number;
    }
    public int getNumb() {
        return number;
    }
    public product getProd() {
        return product;
    }
}
