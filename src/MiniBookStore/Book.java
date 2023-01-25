package MiniBookStore;

//1-b- book da ürün, ancak authorName ve publisher var
public class Book extends Product{

    private String authorName;
    private String publisher;


    public Book(int id, String name, String price, int stok,String authorName,String publisher) {
        super(id, name, price, stok);//parentın const kullan
        this.authorName=authorName;
        this.publisher=publisher;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}