package jp.co.seraku;
public class BookInfo {
    int isbnCode; 
    String title; 
    String author; 
    String publisher; 
    int year; 
    boolean status; 
    public BookInfo(int isbnCode, String title, String author, String publisher, int year, boolean status) {
        this.isbnCode = isbnCode;
        this.title= title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.status = status;
    }
    public BookInfo(int isbnCode, String title, String author, String publisher, int year) {
        this(isbnCode,title,author,publisher,year,true); 
    }
    public int getCode() {
        return isbnCode;
    }
    public String gettitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getPublisher() {
        return publisher;
    }
    public int getYear() {
        return year;
    }
    public String getStatusString() {
        if(status) {
            return "lending allowed book";
        }else {
            return "lending Not allowed book";
        }
    }
    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = !status;
    }
}