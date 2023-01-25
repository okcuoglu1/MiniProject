package MiniBookStore;

public class Notebook extends Product{

    private String brand;

    private String sheet;


    public Notebook(int id, String name, String price, int stok,String brand, String sheet) {
        super(id, name, price, stok);
        this.brand=brand;
        this.sheet=sheet;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSheet() {
        return sheet;
    }

    public void setSheet(String sheet) {
        this.sheet = sheet;
    }
}