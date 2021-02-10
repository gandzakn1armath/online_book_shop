package models;

public class Book {
    private String nameBook;
    private Author author;
    private Genere genre;
    private float price;

    public Book(String nameBook, Author author, Genere genre, float price) {
        this.nameBook = nameBook;
        this.author = author;
        this.genre = genre;
        this.price = price;
    }


    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genere getGenre() {
        return genre;
    }

    public void setGenre(Genere genre) {
        this.genre = genre;
    }

    public float getPrice() { return price; }

    public void setPrice(float price) { this.price = price; }

    @Override
    public String toString() {
        return  nameBook + '\n' +
                 author +'\n' +
                 genre;
    }


}
