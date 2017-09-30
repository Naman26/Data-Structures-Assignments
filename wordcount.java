
/**
  @author Naman Kanwar
  @version 27 Jan 2017
 1) Purpose: This program prompts user to provide a name or path of file, then the program counts 
 words, lines, alphanumeric characters, sentences, vowels, and punctuations of the 
 given file. The ouput is displayed on screen and on an output file called output.txt.
 If he file is empty then the output is "the input file is empty".
 
 2) Lines can be counted at scan time, words can be counted according to spaces. By 
 converting Strings to characters alphanumeric characters and punctuations can be 
 calculated based on ASCII ranges. Sentences and vowels can be calculated by direct 
 comparison(==) among characters  
 
 3) There are no data structures used in this class, there is only manipulation on the 
 String, and characters
 
 4) This program should work on notepad(.txt) files. However, if the size of the file
 is large then the results may be projected incorrectly 
 
 5) There is only one class that reads input from a file given by user, then counts words,
 lines, alphanumeric characters, sentences, vowels, and punctuations of the given file. It
 also displayes output on screen and on a file called output.txt.
 */
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
public class wordcount
{
    public static void main(String[]args){
        Scanner input= new Scanner(System.in);
        String filePath="";
        System.out.println("Please enter the file name or file's path");//prompt
        filePath= input.next();
        int words=0;                                                    //number of words 
        int vowel=0;                                                    //number of vowels
        int alphanumeric=0;                                             //number of alphanumeric characters
        int lines=0;                                                    //number of lines
        int sentence=0;                                                 //number of sentences
        int punc=0;                                                     //number of punctuation marks
        int flag=0;                                                     //check if the file is empty 
        File file = new File(filePath);                             
        try{
            Scanner fileInput= new Scanner(file);
            while(fileInput.hasNext()){                                 //while there is input in the file
                String content= fileInput.nextLine();
                content= content.toLowerCase();
                for(int i=0;i<content.length();i++){
                    char c= content.charAt(i);                          //coverting String to character
                    if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){         
                        vowel++;                                        //counting vowels
                    }
                    if((c<=122 && c>=97)||(c<=57 && c>=48)){
                        alphanumeric++;                                 //counting alphanumeric characters
                    }
                    if(c=='.'||c=='?'||c=='!'){
                        sentence++;                                     //counting sentences
                    }
                    if(c==' '|| i==content.length()-1){
                        words++;                                        //counting words
                    }
                    if((c<=47&&c>=33)||(c<=63&&c>=58)||(c<=96&&c>=91)||(c<=126&&c>=124) ){
                        punc++;                                         //counting punctuation marks
                    }
                }
                flag++;
                lines++;                                                //counting the lines
            }
            fileInput.close();                                          //closing file
        }
        catch(FileNotFoundException n){
            n.printStackTrace();                                        //checking if file is found
        }
        if(flag==0){
            System.out.print("The input file is empty");                //if file is empty then print
        }
        else                                                            //if file is not empty then print the following
        {
            System.out.println("vowel: "+vowel);
            System.out.println("words: "+words);
            System.out.println("alphanemeric: "+alphanumeric);
            System.out.println("lines: "+lines);
            System.out.println("sentences: "+sentence);
            System.out.println("punctuation: "+punc);
        }
        PrintWriter output= null;
        try
        {
            output= new PrintWriter(new FileWriter("output.txt"));      //creating the output file and printing the following          
            output.println("vowel: "+vowel);
            output.println("words: "+words);
            output.println("alphanemeric: "+alphanumeric);
            output.println("lines: "+lines);
            output.println("sentences: "+sentence);
            output.println("punctuation: "+punc);
        }catch(IOException e){
            System.out.println(e);
            System.exit(1);
        }
    }
}
