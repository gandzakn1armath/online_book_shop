package models;

public class Product {
    private Book book;
    private  Card price;

    public Product(Book book, Card price) {
        this.book = book;
        this.price = price;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Card getPrice() {
        return price;
    }

    public void setPrice(Card price) {
        this.price = price;
    }
}
