package jp.co.seraku;
import java.util.ArrayList;
public class BookShelf {
    ArrayList<BookInfo> shelf = new ArrayList<BookInfo>(); 
    public BookShelf() {
    	shelf.add(new BookInfo(0000000000001, "abook", "a.a", "a", 2022));
    	shelf.add(new BookInfo(0000000000002, "bbook", "b.b", "b", 2022));
    	shelf.add(new BookInfo(0000000000003, "cbook", "c.c", "c", 2022));
    	shelf.add(new BookInfo(0000000000004, "dbook", "d.d", "d", 2022));
    	shelf.add(new BookInfo(0000000000005, "ebook", "e.e", "e", 2022));
    }
    
    public void showLibrary() {
        System.out.println("display books");
        for(int i = 0; i < shelf.size(); i++) {
            System.out.println("ISBNcode: " + shelf.get(i).getCode());
            System.out.println("Title: " + shelf.get(i).gettitle());
            System.out.println("Author: " + shelf.get(i).getAuthor());
            System.out.println("Publisher: " + shelf.get(i).getPublisher());
            System.out.println("PublishYear: " + shelf.get(i).getYear());
            System.out.println("Status: " + shelf.get(i).getStatusString());
        }
    }
    
    public BookInfo passBookInfo(int isbnCode) {
        for(int i = 0; i < shelf.size(); i++) {
            if(shelf.get(i).getCode() == isbnCode) {
                return shelf.get(i);
            }
        }
        return null;
    }
   
    public ArrayList<BookInfo> getshelf() {
        return shelf;
    }
}