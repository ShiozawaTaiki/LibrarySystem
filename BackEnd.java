package jp.co.seraku;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;


public class BackEnd {
    SystemLibrary system; 
    Scanner scan = new Scanner(System.in); 
    
    public void selectMain() {
        System.out.println("Library system");
    	System.out.println("Select an option");
        System.out.println("0 - exit");
        System.out.println("1 - Add book");
        System.out.println("2 - find book");
        System.out.println("3 - edit shelf");
        System.out.println("4 - throw away book");
        System.out.println("5 - display books");
        System.out.println("6 - help");
    }
          
    public void operateMain(int num) {  	   	
        switch(num) {
        case 0:
            System.out.println("shutting down");
            System.exit(0);
        case 1:
            System.out.println("Please input　New Books ISBNcode");
            int case1Code = inputInteger();
            BookInfo checkBook = system.library.passBookInfo(case1Code);
            if(checkBook != null) {
                System.out.println("error!!!!!:errorcode 3");
                break;
            }
            System.out.println("Please input New Books Title: ");
            String title = inputString();
            System.out.println("Please input New Books Author");
            String author = inputString();
            System.out.println("Please input New Books Publisher");
            String publisher = inputString();
            System.out.println("Please input New Books Publishyear");
            int year = inputInteger();
            System.out.println("ISBNcode: " + case1Code);
            System.out.println("title: " + title);
            System.out.println("author: " + author);
            System.out.println("Publisher: " + publisher);
            System.out.println("Publishyear: " + year);
            System.out.println("status: Available for loan");
            while(true) {
                System.out.println("register for the Book？(yes/no)");
                String case1Answer = inputString();
                if(case1Answer.equals("yes")) {
                    system.createBook(case1Code, title, author, publisher, year);
                    System.out.println("Please input the books ISBNcode you want to delete");
                    break;
                }else if(case1Answer.equals("no")){
                    break;
                }else {
                    System.out.println("error!!!!!:errorcode 1");
                    continue;
                }
            }
            break;
            
        case 2:
            System.out.println("Please input the books ISBNcode you want to search for");
            int case2Code = inputInteger();
            BookInfo case2Book = system.library.passBookInfo(case2Code);
            displayInfo(case2Book);
            break;
            
        case 3:
            System.out.println("Please input the books ISBNcode for which you want to change the lending status");
            int case3Code = inputInteger();
            BookInfo case3Book = system.library.passBookInfo(case3Code);
            displayInfo(case3Book);
            if(case3Book != null) {
                while(true) {
                    System.out.println("Do you want to change the status of the book?(yes/no)" );                   
                    String case3Answer = inputString();
                    if(case3Answer.equals("yes")) {
                        system.changeStatus(case3Book);
                        System.out.println("Changes are complete");
                        break;
                    }else if(case3Answer.equals("no")){
                        break;
                    }else {
                        System.out.println("error!!!!!:errorcode1");
                        continue;
                    }
                }
            }
            break;       
            
        case 4:
            System.out.println("Please input the books ISBNcode you want to delete。");
            int case4Code = inputInteger();
            BookInfo case4Book = system.library.passBookInfo(case4Code);
            displayInfo(case4Book);
            if(case4Book != null) {
                while(true) {
                    System.out.println("Do you delete this book?(yes/no)" );
                    String case4Answer = inputString();
                    if(case4Answer.equals("yes")) {
                        system.deleteBook(case4Book);
                        System.out.println("Finished deleting books");
                        break;
                    }else if(case4Answer.equals("no")){
                        break;
                    }else {
                        System.out.println("error!!!!!:errorcode 1");
                        continue;
                    }
                }
            }
            break;
            
        case 5:
            while(true) {
                System.out.println("Do you want to list the bookshelves?(yes/no)");         
                String case5Answer = inputString();
                if(case5Answer.equals("yes")) {
                    system.library.showLibrary();
                    break;
                }else if(case5Answer.equals("no")){
                    break;
                }else {
                    System.out.println("error!!!!!!:errorcode 1");
                    continue;
                }
            }
            break;
            
         case 6:        	
        	help();
        	String case6Answer = inputString();
        	break;
        	
            default:
                System.out.println("error!!!!!!:errorcode 4");
                break;
        }
    }
   
    public void help() {
    	String errorcode1 ="errorcode 1:Please input yes/no";
        String errorcode2 ="errorcode 2:can't find the book";
        String errorcode3 ="errorcode 3:the code is registered";
        String errorcode4 ="errorcode 4:Please input 0~5";
        String errorcode5 ="errorcode 5:Please input numbers";
      	System.out.println(errorcode1); 
    	System.out.println(errorcode2);
    	System.out.println(errorcode3);
    	System.out.println(errorcode4);
    	System.out.println(errorcode5);
    }
    
    public int inputInteger() {
        int answer = 0;
        try {
            String tempAnswer = scan.next();
            answer = Integer.parseInt(tempAnswer); 
        }catch (NumberFormatException e){
            System.out.println("error!!!!!:errorcode 5");          
            answer = inputInteger();            
        }
        return answer;
    }
    public String inputString() {
        String answer = scan.next();
        return answer;
    }
    
    public void displayInfo(BookInfo book) {    
        if(book != null) {
            System.out.println("ISBNcode: " + book.getCode());
            System.out.println("Title: " + book.gettitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Publisher: " + book.getPublisher());
            System.out.println("PublishYear: " + book.getYear());
            System.out.println("Status: " + book.getStatusString());
        }else {
            System.out.println("error!!!!!:errorcode 2");
        }
    }
    
    
    public BackEnd() {
        system = new SystemLibrary();
    }
    
    
}