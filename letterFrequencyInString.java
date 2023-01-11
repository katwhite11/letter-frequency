/*
author: Kathryn White
purpose: This program receives a sentence input from a user and then has the ability to set that string, 
return the string, or print each element in a string and their frequency directly after.
*/
import java.util.Scanner;

class MyString{
    //instance fields
    String s;
    
    //constructor with null string
    MyString(){
        s = "";
    }

    //gets a string as input parameter and assigns it to s
    public void setMyString(String newS){
        s = newS.toLowerCase();
    }

    //returns s
    public String getS(){
        return s;
    }
    
    /* 
    returns another String r built from s where each character in r is followed by the frequency in s
    if s = "abcabbacd", it will return "a3b3c2d1" or if s = "attack at noon", it will return "a3t3c1k1 2n2o2"
    */
    public String getCount(){
        
        //instance variables
        String r = "";
        char c;
        String[] letters = new String[s.length()];
        
        //sorts each letter of the string into an array
        for(int i = 0; i<s.length();i++){
            c = s.charAt(i);
            letters[i] = Character.toString(c);
        }
        
        //counts the instances of each element in the array, assigns void to additional repeated elements to avoid being recounted
        for(int j = 0; j<letters.length; j++){
            int count = 1;
            for(int k = j+1; k<letters.length;k++){
                if(letters[j].equals(letters[k])){
                    count++;
                    letters[k]= "void";
                }
            }
            //adds all elements and their instances to the new string r unless the element reads as "void"
            if(!letters[j].equals("void")){
                r = r+letters[j]+count;
            }
        }
        return r;  //returns new String r
    }
   
}

public class Lab06 {

    //main method
    public static void main(String[] args) {
        //test
        String userInput;
        Scanner in = new Scanner(System.in);
        MyString test = new MyString();
        
        //prompts user for input
        System.out.println("Please type a sentence or string of letters: ");
        
        //receives and stores input from user
        userInput = in.nextLine();
        test.setMyString(userInput); //sets string 
        
        System.out.println(test.getCount()); //prints each element and frequency
    }
    
}
