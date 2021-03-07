package main;

import local_datebase.Database;
import models.Author;
import models.Book;
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

    public static int getScanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void printSection() {
        while (true) {
            System.out.println(
                    "1․Որոնում \n" +
                            "2․Տեսակներ\n" +
                            "3․Հեղինակների անուններ" + '\n' +
                            "4․Զամբյուղ" + '\n' +
                            "5․Հետադարձ կապ" + '\n' +
                            "6․Դուրս գալ" + '\n' +
                            "Ընտրել բաժինը։ (Օր․՝ 1 + Enter)\n");
            Scanner obj = new Scanner(System.in);
            int answer1 = obj.nextInt();
            if (answer1 == 6) {
                break;
            }
            switch (answer1) {
                case 1:
                    search();
                    break;
                case 2:
                    printGeneres();
                    break;
                case 3:
                    printAuthors();
                    break;
                case 4:
                    basket();
                    break;
                case 5:
                    contact();
                    break;


                default:
            }
        }
    }

    public static void basket() {
        while (true) {
            if (basketList.size() == 0) {
                System.out.println("  Զամբյուղը դատարկ է\n");
                printSection();
            } else {
                System.out.println(" ========  ԶԱՄԲՅՈՒՂ  ========");
                int allPrice = 0;
                for (int i = 0; i < basketList.size(); i++) {
                    System.out.print((i + 1) + "." + basketList.get(i).getNameBook() + '\n');
                    int price = (int) basketList.get(i).getPrice();
                    allPrice = allPrice + price;
                }
                System.out.println("Ընդհանութ արժեքը՝ " + allPrice + "դրամ" + '\n');
                System.out.println("Գործողություններ" +
                        '\n' + "  Գնել(մուտքագրել ընդհանուր արժեքը)" +
                        '\n' + "  Ջնջել ըստ համարի(Օր․՝ 5)" +
                        '\n' + "  Հետ գնալ(մուտքագրել 0)");
                int answer = getScanner();
                if (answer <= basketList.size() && answer > 0) {
                    basketList.remove(answer - 1);
                    if (basketList.size() == 0) {
                        System.out.println("  Զամբյուղը դատարկ է\n");
                        printSection();
                        break;
                    }
                }
                if (answer == allPrice) {
                    buy();
                } else if (answer == 0) {
                    break;
                } else {
                    System.out.println("Դուք մոտքագրել եք սխալ արժեք։ Փորձեք կրկին։");
                }
            }

        }
    }


    public static void addBasket(Book book) {
        if (basketList.contains(book)) {
            System.out.println("<<" + book.getNameBook() + ">>" + " արդեն ավելացված է զամբյուղում" + '\n');
        } else {
            basketList.add(book);
            System.out.println("<<" + book.getNameBook() + ">>" + " ավելացվեց զամբյուղում" + '\n');
        }

    }


    public static void buy() {
        while (true) {
            System.out.println(" ========  ՇՆՈՐՀԱԿԱԼՈՒԹՅՈՒՆ ԳՆՈՒՄԸ ԿԱՏԱՐՎԱԾ Է ========  \n");
            break;
        }

    }


    public static void printActions() {
        System.out.println("Գործողություններ" +
                '\n' + "1.Ավելացնել Զամբյուղ" +
                '\n' + "Հետ գնալ(մուտքագրել 0)");

    }


    public static boolean askForBook(ArrayList<Book> books) {
        System.out.println("\nՀետ գնալ(մուտքագրել 0)\n");
        while (true) {
            int answer = getScanner();
            if (answer == 0) {
                return false;
            }
            Book book = books.get(answer - 1);
            float price = book.getPrice();
            System.out.println("======== " + book.getNameBook() + " =========");
            System.out.println(book);
            System.out.println("Արժեքը՝ " + price + " դրամ\n");
            printActions();
            answer = getScanner();

            if (answer == 1) {
                addBasket(book);
                break;
            } else if (answer == 0) {
                break;
            }
        }
        return true;
    }

    public static void contact() {
        System.out.println(" ========  ՀԵՏԱԴԱՐՁ ԿԱՊ  ========");
        System.out.println(Database.getContact() + "\n");
        printSection();

    }


    public static void printGeneres() {
        while (true) {
            System.out.println(" ========  Տեսակներ  ========");
            ArrayList<Genere> genereData = getGenereList();
            for (int i = 0; i < genereData.size(); i++) {
                System.out.println((i + 1) + "." + genereData.get(i).getGenere());
            }

            System.out.println("\nԸնտրել տեսակ");
            System.out.println("Հետ գնալ(մուտքագրել 0)\n");
            int answer = getScanner();
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

    public static void search() {
        System.out.println("========  Որոնում  ========  ");
        System.out.println("Հետ գնալ(մուտքագրել 0)");
        System.out.println("Մուտքագրեք գրքի վերնագիր կամ հեղինակի անուն");
        Scanner scanner = new Scanner(System.in);
        String keyword = scanner.nextLine();
        while (true) {
            ArrayList<Book> bookList = getBookList();
            ArrayList<Book> searchResult = new ArrayList<>();
            if (keyword.equals("0")){
                break;
            }
            for (Book book : bookList) {

                if (equalsBook(book, keyword)) {
                    searchResult.add(book);
                    System.out.println(searchResult.size() + "․ " + book.getNameBook());
                }
            }

            if (searchResult.size() > 0) {
                if (!askForBook(searchResult)) {
                    break;
                }

            } else {
                System.out.println("Որոնման արդյունքը չի գտնվել\n");
                break;
            }
        }
    }


    private static boolean equalsBook(Book book, String keyword) {
        return equalsText(book.getNameBook(), keyword) ||
                equalsText(book.getAuthor().getName(), keyword) ||
                equalsText(book.getGenre().getGenere(), keyword);
    }

    private static boolean equalsText(String t1, String t2) {
        return t1.substring(0, Math.min(t2.length(), t1.length())).equalsIgnoreCase(t2);
    }

    public static void printAuthors() {
        while (true) {
            System.out.println(" ========  Հեղինակների անուններ  ========");
            ArrayList<Author> authorData = getAuthorList();
            for (int j = 0; j < authorData.size(); j++) {
                System.out.println((j + 1) + "." + authorData.get(j).getName());
            }
            System.out.println("\nԸնտրել հեղինակի անուն");
            System.out.println("Հետ գնալ(մուտքագրել 0)\n");
            int answer = getScanner();
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
                        int count = 0;
                        count = count + 1;
                        System.out.println(count + "." + bookData.get(i).getNameBook());
                        authors.add(bookData.get(i));
                    }
                }
                askForBook(authors);


            }
        }
    }
}