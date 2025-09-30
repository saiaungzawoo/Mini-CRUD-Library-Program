package library;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BookManager bookManager = new BookManager();

        int choice = 0;

        while(choice != 6){
            System.out.println();
            System.out.print("1.Add book\n2.Remove book\n3.View all books\n4.Update book\n5.Search book\n6.Exit");
            System.out.println();
            System.out.print("Please choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); //extra line
            System.out.println();

            switch (choice){
                case 1:
                    bookManager.addBook(scanner);
                    break;
                case 2:
                    bookManager.removeBook(scanner);
                    break;
                case 3:
                    bookManager.viewAllBooks();
                    break;
                case 4:
                    bookManager.updateBook(scanner);
                    break;
                case 5:
                    bookManager.searchBook(scanner);
                    break;
                case 6:
                    System.out.println("Have a nice day!");
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }

        scanner.close();
    }
}
