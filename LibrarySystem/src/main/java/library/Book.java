package library;

public class Book {
    //restore the previous id counter
    //use id from book manager


    private String title;
    private String author;
    private double price;
    private int id;

    //constructor to store user input
    public Book(int id, String title, String author, double price){
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;


    }

    //getter for retrieving book info
    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public double getPrice(){
        return price;
    }

    public int getId(){
        return id;
    }

    //setter for updating the book's info
    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setPrice(double price){
        this.price = price;
    }


    //obj to string format for display
    public String toString(){
        return "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "Price: " +"$" + price +  "\n" +
                "ID: " + id + "\n";
    }
}
