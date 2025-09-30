//Mini CRUD program
//The user can add,remove,update,view books
//each book object has title, author, price, ID
// book's ID is set automatically whenever the user add a book

//version - 1.1  14.9.25
//version - 1.2  15.9.25
//version - 1.3  16.9.25
//version - 1.4  17.9.25
//version - 1.5  21.9.25
//version - 1.6  24.9.25

package library;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import library.Book;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BookManager {
    private List<Book> bookList; //all methods can access it
    // id = previous highest id + 1;
    private int idCounter = 0;

    //create gson obj, file obj to point json file
    //init
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private File file = new File("data/bookdata.json");

    //read books data from file
    public BookManager(){
        loadBooks(); //always load the list first
        //restore the previous id counter
        for(Book b : bookList){
            if(b.getId() > idCounter){
                idCounter = b.getId();
            }
        }
    }

    public void loadBooks(){

        //save to JSON
        try{

            if(file.exists()){
                //load the existing book from json file
                FileReader fileReader = new FileReader(file);
                //(copied this single line of code. it tells json that the list contains book objects)
                Type listType = new TypeToken<List<Book>>() {}.getType();
                bookList = gson.fromJson(fileReader, listType); //read json from file, then convert to java obj
                fileReader.close();

                //create an empty array list if the list is null
                //so user can store book obj
                if(bookList == null){
                    bookList = new ArrayList<>(); //list obj
                }

            }
            else {
                bookList = new ArrayList<>();
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addBook(Scanner scanner){
        //increment whenever the user add a book
        idCounter++;

        System.out.print("Please enter the book title: ");
        String title = scanner.nextLine();
        System.out.println();

        System.out.print("Please enter the author's name: ");
        String author = scanner.nextLine();
        System.out.println();

        //exception handling
        double price;

        while(true){
            System.out.print("Please enter the book's price: ");
            try{
                price = scanner.nextDouble();
                break; //exit the loop if the input is double
            }
            catch (InputMismatchException e){
                System.out.println("Only numbers are allowed. Please try again.");
                scanner.next(); //if input is invalid, clear that input
            }

        }

        //store user input in obj
        Book book = new Book(idCounter, title, author, price);

        bookList.add(book);
        saveBooks();

        System.out.println();
        System.out.println("You've added a book.");
        System.out.println();
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + "$" + price);
        System.out.println("ID: " + book.getId());
    }

    public void saveBooks(){

        try {
            FileWriter fileWriter = new FileWriter(file);
            gson.toJson(bookList, fileWriter);
            fileWriter.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void viewAllBooks(){
        if(bookList.isEmpty()){
            System.out.println("Book list is empty.");

        }
        else {
            //count books
            int booksCount = bookList.size();
            System.out.println("There are " + booksCount + " books in the library database.");
            System.out.println("All Books:");
            for(Book b : bookList){
                System.out.println(b);
            }
        }
    }


    public void removeBook(Scanner scanner){

        System.out.print("Please remove a book by ID: ");
        int idInput = scanner.nextInt();

        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i); //i = 0,1,etc... cuz it's looping the index
            //index = book obj in the book list

            //remove book
            if(idInput == book.getId()){
                bookList.remove(i);
                System.out.println("You've removed a book: " + book.getTitle());
                saveBooks(); //rewrite the book list
                return; //stop
            }
        }

        System.out.println("Book not found.");

    }

    //to update existing book info
    public void updateBook(Scanner scanner){

        System.out.print("Please update the book by entering ID: ");
        int idBook = scanner.nextInt();
        scanner.nextLine();

        boolean bookFound = false; //condition for finding book ID

        //search (loop) the book list for book id
        for (Book book : bookList) {
            if (idBook == book.getId()) {
                //if book id is found
                bookFound = true;

                System.out.println("Book found: " + book.getTitle());
                System.out.println();

                System.out.println("Press Enter if you want to skip\nOR you can proceed.");
                System.out.println();
                System.out.print("Enter the new title: ");
                String newTitle = scanner.nextLine();
                System.out.println();


                if(newTitle.isEmpty()){
                    //keep the old title
                    book.getTitle();
                    saveBooks();
                }
                else {
                    book.setTitle(newTitle);
                    System.out.println("The title is updated.");
                    System.out.println("New Title: " + book.getTitle());
                    //save the updated info
                    saveBooks();
                }
                System.out.println();

                System.out.print("Enter the new author: ");
                String newAuthor = scanner.nextLine();
                System.out.println();

                if(newAuthor.isEmpty()){
                    //keep the old author name
                    book.getAuthor();
                    saveBooks();
                }
                else {
                    book.setAuthor(newAuthor);
                    System.out.println("The author name is updated.");
                    System.out.println("New Author: " + book.getAuthor());
                    saveBooks();
                }
                System.out.println();


                while(true){
                System.out.print("Enter the new price: ");
                String newPrice = scanner.nextLine();

                System.out.println();

                //if the user skip
                if(newPrice.isEmpty()){
                    //keep the old price
                    book.getPrice();
                    saveBooks();
                    break; //exit loop
                }
                else {
                    //Exception handling
                    try {
                        book.setPrice(Double.parseDouble(newPrice));
                        System.out.println("The price is updated.");
                        System.out.println("New Price: " + book.getPrice());
                        saveBooks();
                        break; //exit loop if input contains double
                    } catch (NumberFormatException e) {
                        System.out.println("Only numbers are allowed. Please try again.");
                    }
                }
                    }
                System.out.println("All updates are finished.");


                    }
                }
        System.out.println();
        if(!bookFound){
            //if the loop ends and can't find the id,
            System.out.println("Book not found.");

            }

    }

    public void searchBook(Scanner scanner){

        System.out.print("Please search any books by entering ID: ");
        int inputId = scanner.nextInt();
        scanner.nextLine();

        //searching books
        for(Book book : bookList){

            if(inputId == book.getId()){
                System.out.println("Book found!");
                System.out.println();
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Price: " + "$" + book.getPrice());
                System.out.println("ID: " + book.getId());
                return;
            }

        }
        System.out.println("The Book does not exist.");

    }

}




