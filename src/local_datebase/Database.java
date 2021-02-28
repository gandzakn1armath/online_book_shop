package local_datebase;

import models.Author;
import models.Book;
import models.Contact;
import models.Genere;

import java.util.ArrayList;

public class Database {
    public static ArrayList<Author> getAuthorList(){
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("Հովհաննես Թումանյան"));
        authors.add(new Author("Վիկտոր Հյուգո"));
        authors.add(new Author("Նար-Դոս"));
        authors.add(new Author("Մխիթար Գոշ"));
        authors.add(new Author("Ջոնաթան Սվիվթ"));
        authors.add(new Author("Վարդան Այգեկցի"));

        return  authors;
    }
    public static ArrayList<Book> getBookList(){
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Շունն ու կատուն", getAuthorList().get(0), getGenereList().get(3),1600));
        books.add(new Book("Ոսկին և ցորենը", getAuthorList().get(3), getGenereList().get(0),1000));
        books.add(new Book("Թշվառները", getAuthorList().get(1), getGenereList().get(1),3500));
        books.add(new Book("Գուլիվերի ճանապարհորդությունները", getAuthorList().get(4), getGenereList().get(2),2000));
        books.add(new Book("Ես և նա", getAuthorList().get(2), getGenereList().get(4),2500));
        books.add(new Book("Եզ և ձի", getAuthorList().get(5), getGenereList().get(0),1200));
        return  books;
    }
    public static Contact getContact(){
        return new Contact("Աբգար Ենոքյան", "+79855015566", "abo@book.com");

    }
    public static ArrayList<Genere> getGenereList(){
        ArrayList<Genere> genres = new ArrayList<>();
        genres.add(new Genere("Առակ"));
        genres.add(new Genere("Վեպ"));
        genres.add(new Genere("Արկածային"));
        genres.add(new Genere("Հեքիաթ"));
        genres.add(new Genere("Նովել"));

        return  genres;
    }
}
