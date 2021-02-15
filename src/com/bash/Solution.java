/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.

 ’+’, ‘-‘, ‘*’, ‘/’.

 A = "((a + b))"
Output 1:
    1
    Explanation 1:
        ((a + b)) has redundant braces so answer will be 1


 a + b => 0

 (a + b => 1

 (a + b) + c => 0

 ((a + b) + c) => 0

 (,(a+b), +, c, )  ((a + b) + c)

 (,(a+b),)
 mismatch & extra bracets

 */

//Assumption : Expressions are valid


public class Solution {

    public static void main(String[] args) {

        String str = "a + b + c";
        int output = checkExpression(str);
        System.out.println(output);
    }

    private static int checkExpression(String str){
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) != ')' ){
                stack.push(str.charAt(i));
            }else{
                boolean validExpression = false;
                while(true){
                    Character ch = stack.pop();
                    if(isOperator(ch)){
                        validExpression = true;
                    }
                    if(ch == '('){
                        break;
                    }
                }
                if(!validExpression) return 1;
            }
        }
        return 0;
    }

    private static boolean isOperator(Character c){
        if(c == null) return false;
        if(c.equals('+') || c.equals('-') || c.equals('*') || c.equals('/'))
            return true;
        return false;
    }
}

class Stack<T>{

    int top;
    List<T> stack;

    Stack(){
        top = -1;
        stack = new ArrayList<T>();
    }

    public T pop(){
        if(top == -1) return null;
        return stack.get(top--);
    }

    public void push(T element){
        ++top;
        stack.add(element);
    }

    public T getTop(){
        return stack.get(top);
    }

}


