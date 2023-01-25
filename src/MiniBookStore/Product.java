package MiniBookStore;

//1-a-tüm productların özellikleri,metodları
public class Product {

    private int id;
    private String name;
    private String price;
    private int stok;

    public Product(int id, String name, String price, int stok) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stok = stok;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}