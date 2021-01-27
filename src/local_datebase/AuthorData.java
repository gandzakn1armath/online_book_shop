package local_datebase;

import models.Author;

import java.util.ArrayList;

public class AuthorData {

    public static ArrayList<Author> getAuthorData(){
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("Հովհաննես Թումանյան"));
        authors.add(new Author("Վիկտոր Հյուգո"));
        authors.add(new Author("Նար-Դոս"));
        authors.add(new Author("Մխիթար Գոշ"));
        authors.add(new Author("Ջոնաթան Սվիվթ"));

        return  authors;
    }

}
