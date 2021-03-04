package models;

import java.util.Objects;

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
        return   "հեղինակ՝ " + author +'\n' +
                 "ժանր՝ " +genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Float.compare(book.price, price) == 0 && Objects.equals(nameBook, book.nameBook) && Objects.equals(author, book.author) && Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameBook, author, genre, price);
    }
}
