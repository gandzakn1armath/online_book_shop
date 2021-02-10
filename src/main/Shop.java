package main;

import models.Author;
import models.Book;
import models.Genere;

import java.util.ArrayList;
import java.util.Scanner;

import static local_datebase.Database.*;

public class Shop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printSection();
        int answer = scanner.nextInt();
        switch (answer) {
            case 1:
                break;
            case 2:
                printGeneres();
                break;
            case 3:
                printAuthors();
                break;
            case 4:
                break;
            case 5:
                break;

            default:
                System.out.println("Ընտրեք բաժինը նորից");
        }

    }

    public static void printSection() {
        System.out.println("Բարի գալուստ <<ԳՐՔԵՐԻ ԱՇԽԱՐՀ>> " + '\n' +
                "1․Որոնում " + '\n' +
                "2․Տեսակներ" + '\n' +
                "3․Հեղինակների անուններ" + '\n' +
                "4․Զամբյուղ" + '\n' +
                "5․Հետադարձ կապ" + '\n' +
                "Ընտրել բաժինը։ (Օր․՝ 1 + Enter)\n");
    }

   public static void askForBook(ArrayList<Book> books){
       Scanner scanner = new Scanner(System.in);
       int answer = scanner.nextInt();
       Book book = books.get(answer - 1);
       float price = book.getPrice();
       System.out.println("======== " + book.getNameBook() + " =========");
       System.out.println(book);
       System.out.println("Գինը "+price + " դրամ\n");



   }


    public static void printGeneres() {
        System.out.println(" ========  Տեսակներ  ========");
        ArrayList<Genere> genereData = getGenereList();
        for (int i = 0; i < genereData.size(); i++) {
            System.out.println((i + 1) + "." + genereData.get(i).getGenere());
        }

        System.out.println("Ընտրել տեսակ։\n");
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();
        int count = 0;
        if (answer >0 && answer <= genereData.size()) {
            Genere genere = genereData.get(answer - 1);
            System.out.println("======== " + genere + " =========");
            ArrayList<Book> bookData = getBookList();
            ArrayList<Book>  books = new ArrayList<>();
            for (int i = 0; i < bookData.size(); i++) {
                if (bookData.get(i).getGenre().equals(genere)) {
                    count = count+1;
                   System.out.println(count + "." + bookData.get(i).getNameBook());
                   books.add(bookData.get(i));
            }

        }
            askForBook(books);
            System.out.println("Գործողություններ" +
                    '\n' + "1.Ավելացնել Արկղ" +
                    '\n' + "2.Վերադառնալ" +
                    '\n' + "3.Գնել" );
            Scanner scanner1 = new Scanner(System.in);
            int answer1 = scanner1.nextInt();
            switch (answer1) {
                case 1:
                    break;
                case 2:
                    printGeneres();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Ընտրեք բաժինը նորից");
            }

    }
    }

    public static void printAuthors() {
        System.out.println(" ========  Հեղինակների անուններ  ========");
        ArrayList<Author> authorData = getAuthorList();
        for (int j = 0; j < authorData.size(); j++) {
            System.out.println((j + 1) + "." + authorData.get(j).getName());
        }
        System.out.println("Ընտրել հեղինակի անուն");
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();
        int count = 0;
        if (answer >= 1 && answer <= authorData.size()) {
            Author author = authorData.get(answer - 1);
            System.out.println("======== " + author + " ========");
            ArrayList<Book> bookData = getBookList();
            ArrayList<Book> authors= new ArrayList<>();
            for (int i = 0; i < bookData.size(); i++) {
                if (bookData.get(i).getAuthor().equals(author)) {
                    count = count+1;
                    System.out.println(count + "." +bookData.get(i).getNameBook());
                    authors.add(bookData.get(i));
                }
            }
            askForBook(authors);
            System.out.println("Գործողություններ\n" +
                    '\n' + "1.Ավելացնել Արկղ" +
                    '\n' + "2.Վերադառնալ" +
                    '\n' + "3.Գնել" );
            Scanner scanner1 = new Scanner(System.in);
            int answer1 = scanner1.nextInt();
            switch (answer1) {
                case 1:
                    break;
                case 2:
                    printGeneres();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Ընտրեք բաժինը նորից");
            }

        }
    }
}