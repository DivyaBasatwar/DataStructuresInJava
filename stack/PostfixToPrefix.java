package stack;

import java.util.Scanner;
import java.util.Stack;

public class PostfixToPrefix {
    public static boolean isOperator(char op){
        if(op == '+' || op == '-' || op == '*' || op == '/' || op =='%')
            return true;
        return false;
    }
 
    /*  precedence to an operator */
    public static int precedence(char op){
        switch (op){
            case '+' :
            case '-' :
                return 1;
            case '/' :
            case '*' :
                return 2;
            case '%' :
                return 3;
            default :
                return 4;
        }
    }
 
    /* This function tell if the op1 has lower precedence than op2 */
    public static boolean isLowerPrecedence(char op1, char op2){
        if(precedence (op1) < precedence(op2))
            return true;
        return false;
    }
    public static String convertInixToPostfix(String infix){
        Stack<Character> stack = new Stack();
        StringBuilder sb = new StringBuilder();
 
        for(int i=0; i<infix.length(); i++){
            char currentCharacter = infix.charAt(i);
            //If it's an operand, put it on output string
            if(!isOperator(currentCharacter)){
                sb.append(currentCharacter);
            }
            else{
                if(stack.empty()) stack.push(currentCharacter);
                else{
                    while(!stack.empty()
                    && isLowerPrecedence(currentCharacter, stack.peek())){
                        sb.append(stack.pop());
                    }
                    stack.push(currentCharacter);
                }
            }
        }
        while(!stack.empty()) sb.append(stack.pop());
 
        return sb.toString();
    }
 
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the string ---> ");
    	String str = sc.nextLine();
        System.out.println(convertInixToPostfix(str));
    }
}
