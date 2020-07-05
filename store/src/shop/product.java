package shop;

public class product {
    private final String productid;
    private final String name;
    private final String file;
    private final double price;

    public product(String productid, String name, String file, double price) {
        this.productid=productid;
        this.name=name;
        this.file=file;
        this.price=price;
    }
    public String getProdId() {
        return productid;
    }
    public String getName() {
        return name;
    }
    public String getFile() {
        return file;
    }
    public double getPrice() {
        return price;
    }
}
