package jp.co.seraku;
import java.util.Scanner;

public class MainLibrary {
    public static void main(String[] args) {
            BackEnd myMenu = new BackEnd(); 
            while(true) {
                myMenu.selectMain(); 
                myMenu.operateMain(myMenu.inputInteger()); 
                while(true) {
                    System.out.println("continue with Operation??(yes/no)");                   
                    String answer = myMenu.inputString();
                    if(answer.equals("yes")) {
                        break;
                    }else if(answer.equals("no")){
                        System.out.println("shutdown。");
                        System.exit(0);
                    }else {
                        System.out.println("error!!!!!:errorcode 1");
                        continue;
                    }
                }   
            }
        }
}