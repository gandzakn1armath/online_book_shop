package main;

import com.sun.security.jgss.GSSUtil;
import local_datebase.Database;
import models.Author;
import models.Book;
import models.Contact;
import models.Genere;

import java.util.ArrayList;
import java.util.Scanner;

import static local_datebase.Database.*;

public class Shop {

    private static final ArrayList<Book> basketList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Բարի գալուստ <<ԳՐՔԵՐԻ ԱՇԽԱՐՀ>> " + '\n');
        printSection();
    }

    public static void printSection() {
        while (true) {
            System.out.println(
                    "1․Որոնում \n" +
                            "2․Տեսակներ\n" +
                            "3․Հեղինակների անուններ" + '\n' +
                            "4․Զամբյուղ" + '\n' +
                            "5․Հետադարձ կապ" + '\n' +
                            "Ընտրել բաժինը։ (Օր․՝ 1 + Enter)\n");
            Scanner scanner = new Scanner(System.in);
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
                    contact();
                    break;

                default:
                    System.out.println("Ընտրեք բաժինը նորից");
                    printSection();
            }
        }
    }


    public static void addBasket(Book book) {
        if (basketList.contains(book)) {
            System.out.println("Գիրքն արդեն ավելացված է զամբյուղում");
        } else {
            basketList.add(book);
            System.out.println("Գիրքն ավելացվեց զամբյուղում");
        }
    }

    public static void buy(Book book) {
        System.out.println("Շնորհավորում ենք,դուք գնել եք <<" + book.getNameBook() + ">> գիրքը։\n");
        printActions();
        Scanner scanner1 = new Scanner(System.in);
        int answer1 = scanner1.nextInt();
        switch (answer1) {
            case 1:
                addBasket(book);
                break;
            case 2:
                printGeneres();
                break;
            case 3:
                buy(book);
                break;
            default:
                System.out.println("Ընտրեք գործողությունը նորից");
                break;
        }

    }


    public static void printActions() {
        System.out.println("Գործողություններ" +
                '\n' + "1.Ավելացնել Զամբյուղ" +
                '\n' + "Հետ գնալ(սեղմեք 0)");

    }


    public static void askForBook(ArrayList<Book> books) {
        System.out.println("Հետ գնալ(սեղմեք 0)\n");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int answer = scanner.nextInt();
            if (answer == 0) {
                break;
            }
            Book book = books.get(answer - 1);
            float price = book.getPrice();
            System.out.println("======== " + book.getNameBook() + " =========");
            System.out.println(book);
            System.out.println("Գինը " + price + " դրամ\n");
            printActions();
            answer = scanner.nextInt();

            if (answer == 1) {
                addBasket(book);
            } else if (answer == 0) {
                break;
            }
        }
    }

    public static void contact() {
        while (true) {
            System.out.println(Database.getContact());
            System.out.println("\nՀետ գնալ(սեղմեք 0)\n");
            Scanner scanner = new Scanner(System.in);
            int answer = scanner.nextInt();
            if (answer == 0) {
                break;
            }
        }
    }


    public static void printGeneres() {
        while (true) {
            System.out.println(" ========  Տեսակներ  ========");
            ArrayList<Genere> genereData = getGenereList();
            for (int i = 0; i < genereData.size(); i++) {
                System.out.println((i + 1) + "." + genereData.get(i).getGenere());
            }

            System.out.println("Ընտրել տեսակ։");
            System.out.println("Հետ գնալ(սեղմեք 0)\n");
            Scanner scanner = new Scanner(System.in);
            int answer = scanner.nextInt();
            int count = 0;
            if (answer == 0) {
                break;
            }
            if (answer > 0 && answer <= genereData.size()) {
                Genere genere = genereData.get(answer - 1);
                System.out.println("======== " + genere + " =========");
                ArrayList<Book> bookData = getBookList();
                ArrayList<Book> books = new ArrayList<>();
                for (int i = 0; i < bookData.size(); i++) {
                    if (bookData.get(i).getGenre().equals(genere)) {
                        count = count + 1;
                        System.out.println(count + "." + bookData.get(i).getNameBook());
                        books.add(bookData.get(i));

                    }

                }
                askForBook(books);
            }
        }
    }

    public static void printAuthors() {
        while (true) {
            System.out.println(" ========  Հեղինակների անուններ  ========");
            ArrayList<Author> authorData = getAuthorList();
            for (int j = 0; j < authorData.size(); j++) {
                System.out.println((j + 1) + "." + authorData.get(j).getName());
            }
            System.out.println("Ընտրել հեղինակի անուն");
            System.out.println("Հետ գնալ(սեղմեք 0)\n");
            Scanner scanner = new Scanner(System.in);
            int answer = scanner.nextInt();
            int count = 0;
            if (answer == 0) {
                break;
            }
            if (answer >= 1 && answer <= authorData.size()) {
                Author author = authorData.get(answer - 1);
                System.out.println("======== " + author + " ========");
                ArrayList<Book> bookData = getBookList();
                ArrayList<Book> authors = new ArrayList<>();
                for (int i = 0; i < bookData.size(); i++) {
                    if (bookData.get(i).getAuthor().equals(author)) {
                        count = count + 1;
                        System.out.println(count + "." + bookData.get(i).getNameBook());
                        authors.add(bookData.get(i));
                    }
                }
                askForBook(authors);
                printActions();
                Scanner scanner1 = new Scanner(System.in);
                int answer1 = scanner1.nextInt();
                switch (answer1) {
                    case 1:
                        addBasket(bookData.get(answer));
                        break;
                    case 2:
                        printAuthors();
                        break;
                    case 3:
                        buy(bookData.get(answer));
                        break;
                    default:
                        System.out.println("Ընտրեք գործողությունը նորից");
                        break;
                }

            }
        }
    }
}