\# Mini CRUD Library Program



A simple CRUD program for managing a personal library of books.  

This program is built in \*\*Java\*\* using \*\*OOP principles\*\* and supports data persistence through \*\*JSON\*\* and \*\*Java File I/O\*\*.



---



\## Purpose



The purpose of this project is to \*\*practice and demonstrate fundamental programming concepts\*\* in Java, including \*\*OOP, file handling, and data persistence\*\*.



This project also serves as a practical example of using external libraries (\*\*Gson\*\*) with \*\*Maven\*\* for dependency management, and for developing small-scale applications that can be easily extended in the future.



---



\## Features



\- \*\*Add Books\*\* – Create a new book entry with a title, author, and price. The book's ID is automatically generated.  

\- \*\*Remove Books\*\* – Delete a book by its unique ID.  

\- \*\*Update Books\*\* – Modify existing book details (title, author, or price).  

\- \*\*View Books\*\* – Display all books in the library.  



---



\## How It Works



1\. The program maintains a list of `Book` objects.  

2\. Each `Book` has the following attributes:  

&nbsp;  - \*\*ID\*\* (auto-generated)  

&nbsp;  - \*\*Title\*\*  

&nbsp;  - \*\*Author\*\*  

&nbsp;  - \*\*Price\*\*  

3\. Users can perform CRUD operations through a simple console-based interface.  

4\. All changes are saved to a JSON file so that data persists between program runs.  



---



\## Project Structure



Mini-CRUD-Library-Program/

│

├─ src/

│ └─ main/

│ └─ java/

│ └─ library/

│ ├─ Book.java

│ ├─ BookManager.java

│ └─ Main.java

│

└─ data/

└─ bookdata.json



yaml

Copy code



---



\## How to Run



\### Option 1 – Running in Windows CMD or macOS Terminal



\- Install \[JDK 24](https://www.oracle.com/java/technologies/javase/jdk24-archive-downloads.html)  

\- Install \[Maven](https://maven.apache.org/install.html) (if running via CLI)  



\- Clone the repository:  

&nbsp; ```bash

&nbsp; git clone https://github.com/saiaungzawoo/Mini-CRUD-Library-Program.git

Navigate to the project folder:



bash

Copy code

cd Mini-CRUD-Library-Program

Build the project and download dependencies:



bash

Copy code

mvn clean compile

Run the program:



bash

Copy code

mvn exec:java -Dexec.mainClass="Main"

Option 2 – Running in IntelliJ IDEA

Open IntelliJ IDEA and choose Open → select the project root folder.



Make sure the Project SDK is set to JDK 24.



Ensure the working directory is set to the project root (so JSON files are read/written correctly).



Right-click Main.java → Run 'Main.main()'.



IntelliJ will automatically handle dependencies if you imported the project as a Maven project.



Example Run

text

Copy code

Welcome to the Library Program!



1\. Add book

2\. Remove book

3\. View all books

4\. Update book

5\. Search book

6\. Exit



Please choose an option:

