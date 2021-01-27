package models;

public class Product {
    private Book book;
    private  float price;

    public Product(Book book, float price) {
        this.book = book;
        this.price = price;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
