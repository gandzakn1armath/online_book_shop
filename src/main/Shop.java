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

   public static void askForNameBook(){
       Scanner scanner = new Scanner(System.in);
       int answer = scanner.nextInt();
       ArrayList<Book> bookData = getBookData();
       switch (answer){
           case 1:
               System.out.println(bookData.get(answer-1));
       }
   }


    public static void printGeneres() {
        System.out.println(" ========  Տեսակներ  ========");
        ArrayList<Genere> genereData = getGenereData();
        for (int i = 0; i < genereData.size(); i++) {
            System.out.println((i + 1) + "." + genereData.get(i).getGenere());
        }
        System.out.println("Ընտրել տեսակ։\n");
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();
        if (answer >= 1 && answer <= genereData.size()) {
            System.out.println("========" + genereData.get(answer - 1) + "=========");
            Genere genere = genereData.get(answer - 1);
            ArrayList<Book> bookData = getBookData();
            for (int i = 0; i < bookData.size(); i++) {
                if (bookData.get(i).getGenre().equals(genere)) {
                   System.out.println(bookData.get(i).getNameBook());
                   askForNameBook();

            }

        }
    }
    }

    public static void printAuthors() {
        System.out.println(" ========  Հեղինակների անուններ  ========");
        ArrayList<Author> authorData = getAuthorData();
        for (int j = 0; j < authorData.size(); j++) {
            System.out.println((j + 1) + "." + authorData.get(j).getName());
        }
        System.out.println("Ընտրել հեղինակի անուն");
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();
        if (answer >= 1 && answer <= authorData.size()) {
            Author author = authorData.get(answer - 1);
            System.out.println("========" + author + "========");
            ArrayList<Book> bookData = getBookData();
            for (int i = 0; i < bookData.size(); i++) {
                if (bookData.get(i).getAuthor().equals(author)) {
                    System.out.println(bookData.get(i));
                }
            }

        }
    }
}

