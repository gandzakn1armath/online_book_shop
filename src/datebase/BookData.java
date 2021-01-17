package datebase;

import models.Book;

import java.util.ArrayList;


public class BookData {
    public static ArrayList<Book> getBookData(){
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Շունն ու կատուն",AuthorData.getAuthorData().get(0),GenereData.getGenereData().get(3) ));
        books.add(new Book("Ոսկին և ցորենը",AuthorData.getAuthorData().get(3),GenereData.getGenereData().get(0)));
        books.add(new Book("Թշվառները",AuthorData.getAuthorData().get(1),GenereData.getGenereData().get(1)));
        books.add(new Book("Գուլիվերի ճանապարհորդությունները",AuthorData.getAuthorData().get(4),GenereData.getGenereData().get(2)));
        books.add(new Book("Ես և նա",AuthorData.getAuthorData().get(2),GenereData.getGenereData().get(4)));

        return  books;
    }
}
