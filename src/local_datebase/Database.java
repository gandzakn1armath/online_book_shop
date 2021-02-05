package local_datebase;

import models.Author;
import models.Book;
import models.Contact;
import models.Genere;

import java.util.ArrayList;

public class Database {
    public static ArrayList<Author> getAuthorData(){
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("Հովհաննես Թումանյան"));
        authors.add(new Author("Վիկտոր Հյուգո"));
        authors.add(new Author("Նար-Դոս"));
        authors.add(new Author("Մխիթար Գոշ"));
        authors.add(new Author("Ջոնաթան Սվիվթ"));

        return  authors;
    }
    public static ArrayList<Book> getBookData(){
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Շունն ու կատուն",getAuthorData().get(0),getGenereData().get(3) ));
        books.add(new Book("Ոսկին և ցորենը",getAuthorData().get(3),getGenereData().get(0)));
        books.add(new Book("Թշվառները",getAuthorData().get(1),getGenereData().get(1)));
        books.add(new Book("Գուլիվերի ճանապարհորդությունները",getAuthorData().get(4),getGenereData().get(2)));
        books.add(new Book("Ես և նա",getAuthorData().get(2),getGenereData().get(4)));
        books.add(new Book("Եզ և ձի",getAuthorData().get(3),getGenereData().get(0)));
        return  books;
    }
    public static Contact getContact(){
        return new Contact("Սպարտակ Եղիազարյան", "+79855015566", "frunze@book.com");

    }
    public static ArrayList<Genere> getGenereData(){
        ArrayList<Genere> genres = new ArrayList<>();
        genres.add(new Genere("Առակ"));
        genres.add(new Genere("Վեպ"));
        genres.add(new Genere("Արկածային"));
        genres.add(new Genere("Հեքիաթ"));
        genres.add(new Genere("Նովել"));

        return  genres;
    }
}
