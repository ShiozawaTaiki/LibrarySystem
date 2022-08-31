package jp.co.seraku;
public class SystemLibrary {
    BookShelf library; 
    
    public static void help() {
    	String errorcode1 ="errorcode 1:yes/no";
        String errorcode2 ="errorcode 2:can't find the book";
        String errorcode3 ="errorcode 3:the code is registered";
        String errorcode4 ="errorcode 4:Please input 0~5";
        String errorcode5 ="errorcode 5:Please input numbers";
        
    	System.out.println(errorcode1 + errorcode2 + errorcode3 + errorcode4 + errorcode5);  	
    }
    
    public SystemLibrary() {    
        library = new BookShelf();
    }
    public void createBook(int isbnCode, String title, String author, String publisher, int year) {
        BookInfo newBook = new BookInfo(isbnCode, title, author, publisher, year);
        this.library.getshelf().add(newBook); 
    }
    public void changeStatus(BookInfo book) { 
        book.setStatus(book.getStatus());
    }
    public void deleteBook(BookInfo book) { 
        library.getshelf().remove(book);
    }
}