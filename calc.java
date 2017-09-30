import java.util.*;
/**
 *1)This program takes an expression as String (infix notation). The the expression is
 *  converted to postfix notation. If there are any variables inside the expression then
 *  the user is prompted to give integer values to those varible. Then the expression is 
 *  evaluated. The program keeps asking for input until "q" is entered to quit. After
 *  entering "q" the porgram prints invalid expression then quits.
 *
 *2)There are three important methods that complete this program. infixToPostfix, 
 *  convertVar, and soln. These methods convert the expression to postfix, replaces variables,
 *  and evaluates expression respectively. There are no specific algorithms used, it's just 
 *  manipulation on String data types.
 * 
 *3)Stack of characters is used extensively throughout the program. Especially in two of 
 *  the three important methods discussed above.
 *  
 *4)This program catches the errors that are specified as constraints in the assignment.
 *  Although, space between characters is recommended for clearity and efficiency.
 *  
 *5)There is only one class that achieves main purpose of the program. This class has a
 *  main method that prompts the user for input and evaluates the output.
 *  
 * @author Naman Kanwar 
 * @version 3/14/17
 */
public class calc
{
   public static void main(String[]args){                                                   //Main method
       Scanner console= new Scanner(System.in);
       System.out.println("Enter q to quit.");
       String s= "";                                                                        //For user input
       while (!s.equals("q")){                      
           System.out.println("Enter infix Expression: ");                                  //Prompt for input
           s= console.nextLine();                   
           boolean b= checkInput(s);
           if(b==false)
                System.out.println("Invalid expression");                                   //if expression is invalid
           else{
               System.out.println("Converted Expression: "+infixToPostfix(s));              //converted expression
               String n= convertVar(infixToPostfix(s));
               System.out.println("Answer to Expression: "+ soln(n));                       //solved solution
           }
        }
    }
   
   public static boolean checkInput(String k){                                              //Takes a string parameter k and returns boolean
       int paren=0;                                                                         //for index of right parenthesis
       int flag=0;                      
       char m= k.charAt(k.length()-1);                                                      //last character
       for(int i=0;i<k.length();i++){
           k=k.replaceAll(" ","");                                                          //remove spaces
           char c= k.charAt(i);
           if(m=='(')                                                                       //if last charaacter is an opening brace
                return false;
           else if(c=='*'||c=='/'||c=='+'||c=='-'||c=='%'){                                 //if character is an operator then check operator befor and after 
               if((k.charAt(i-1)>47 && k.charAt(i-1)<58) || (k.charAt(i-1)>64 && k.charAt(i-1)<91) || (k.charAt(i-1)>96 && k.charAt(i-1)<123)&&
               (k.charAt(i+1)>47 && k.charAt(i+1)<58) || (k.charAt(i+1)>64 && k.charAt(i+1)<91) || (k.charAt(i+1)>96 && k.charAt(i+1)<123))
                    return true;
           }
           else if(!((c>47 && c<58) || (c>64 && c<91) || (c>96 && c<123)))                  //if chatacter is neither operator nor operand
                return false;
           else if(c=='('){                                                                 //if an ( is found    
               flag=1;
               for(int j=i;j<k.length();j++){                                               //checking for closing pranthesis
                   if(k.charAt(j)==')' && j>paren){                                         //checking for pairs of parenthesis
                       flag=0;
                       paren=j;                             
                   }     
               }
           }
       }
       if(m!=')'|| !((m>47 && m<58) || (m>64 && m<91) || (m>96 && m<123)))
                return false;
       if(flag!=1)                                                                          //if parenthesis pair is found
            return true;
       return true;
   }
   
   public static String infixToPostfix(String exp){                                         //Takes String parameter and returns String as result
       String postfix="";                                                                   //For postfix expression
       Stack <Character>s= new Stack<Character>();                                          //Stack for concersion
       for(int i=0;i<exp.length();i++){
           if(exp.charAt(i)==' '){                                                          //if wide space is encountered
               postfix+=" ";
           }
           else if((exp.charAt(i)>47 && exp.charAt(i)<58) || (exp.charAt(i)>64 && exp.charAt(i)<91) || (exp.charAt(i)>96 && exp.charAt(i)<123)) 
                postfix+=exp.substring(i,i+1);                                              //character is an operator
           
           else if((exp.charAt(i)>39 && exp.charAt(i)<48) && !closingP(exp.charAt(i))&&(exp.charAt(i)!=44 || exp.charAt(i)!=46 || exp.charAt(i)!=41) || exp.charAt(i)==37){ 
               if(openingP(exp.charAt(i))){
                   s.push(exp.charAt(i));                                                   //if character is an operator or parenthesis
                   continue;
               }
               while(!s.isEmpty() && !openingP(s.peek())&& precedence(s.peek(),exp.charAt(i))){
                   postfix+=s.peek();                                                       //if pushing an operator with higher precedence than top
                   s.pop();
               }
               s.push(exp.charAt(i));                                                       //if precedence of current is equal or lower that top
           }
           else if(openingP(exp.charAt(i)))
                s.push(exp.charAt(i));                                                      //if current is opening parnthesis
           else if(closingP(exp.charAt(i))){                                                //if closing parenthesis is encountered
               while(!s.isEmpty() && !openingP(s.peek())){
                   postfix+=s.peek();
                   s.pop();
               } 
               s.pop();
           }
           
        }
       while(!s.isEmpty()){                             
           postfix+=s.peek();                                                               //After iterating through the string postfix evlauation
           s.pop();
       }
       return postfix;                                                                      //Returning postfix expression
   }
   
   public static boolean precedence(char a,char b ){                                        //takes two char(s) and returns a boolean 
        int a1=0;
        int b1=0;
        while(a1==0 & b1==0){                                                               //assign values according to the precedence of th operators 
            if(a=='*'||a=='/'||a=='%')
                a1=3;
            else if(b=='*'||b=='/'||b=='%')
                b1=3;    
            else if(a=='+'||a=='-')
                a1=1;
            else if(b=='+'||b=='-')
                b1=1;
            else if(a=='('||a==')')
                a1=2;
            else if(b=='('||b==')')
                b1=2;   
        }
        if(a1>b1)                                                                           //if character a > character b
            return true;
        return false;
   }
   
   public static boolean openingP(char a){                                                  //takes 1 char parameter and returns a boolean value
       if(a=='(')                                                                           //checks for opening parenthesis
            return true;
       return false;
   }
   
   public static boolean closingP(char a){                                                  //takes 1 char parameter and returns a boolean value
       if(a==')')                                                                           //checks for closing parenthesis
            return true;
       return false;
   }
   
   //After Conversion
   public static String convertVar(String var){                                             //takes 1 String parameter and returns a String 
       Scanner console= new Scanner(System.in);
       String val= var;
       for(int i=0;i<var.length();i++){
           if((var.charAt(i)>64 && var.charAt(i)<91)||(var.charAt(i)>96 && var.charAt(i)<123)){    
            System.out.printf("Enter the value of %s: ",var.charAt(i));                     //Finds the variables and prompts the user for values
            String n= console.next();
            for(int j=0; j<var.length();j++){
                 if(var.charAt(j)==var.charAt(i)){      
                    val=val.replace(val.substring(j,j+1),n);                                //replaces variables with values(String)
                }
            }
           }
       }
       return val;                                                                          //returns converted expression
   }

    public static int soln(String exp){                                                     //takes 1 String parameter and returns an int value
        Stack<Integer> in= new Stack<Integer>();                                            //Stack for operands
        int right;
        int left;
        int temp=0;
        int j=1;
        for(int i=0;i<exp.length();i++){
            char c= exp.charAt(i);
            if(c=='*' || c=='/' || c=='%' || c=='+' || c=='-'){                             //When an operator is found
                switch(c){
                    case'*':
                    right= in.pop();
                    left= in.pop();
                    in.push(left*right);
                    break;

                    case'/':
                    right= in.pop();
                    left= in.pop();
                    in.push(left/right);
                    break;
        
                    case'%':
                    right= in.pop();
                    left= in.pop();
                    in.push(left%right);
                    break;

                    case'+':
                    right= in.pop();
                    left= in.pop();
                    in.push(left+right);
                    break;

                    case'-':
                    right= in.pop();
                    left= in.pop();
                    in.push(left-right);
                    break;
                }
            }
            else if(c==' '){                                                                //When wide space is found
                continue;
            }
            else if(c>47 && c<58){                                                          //if integer value is found
                int count=0;
                temp=0;
                for(j=i; exp.charAt(j)>47 && exp.charAt(j)<58;j++){
                    count++;
                }
                j=i;
                while(count>0){
                    temp+=Integer.parseInt(exp.substring(j,j+1))*Math.pow(10,count-1);
                    count--;
                    j++;
                }
                in.push(temp);
                i=j-1;
            }
        }       
        return in.pop();                                                                    //returns the final value
    }

}
