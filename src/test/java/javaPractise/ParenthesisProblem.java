package javaPractise;

import org.testng.annotations.Test;

import java.util.Stack;

public class ParenthesisProblem {

    @Test
    public void parenthesisProblemUsingString() {
        String in = "[({}){}[]<>][.]";
        String bracketStack = "";
        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);
            if ((c == ')' || c == ']' || c == '}' || c == '>') && !bracketStack.isEmpty()){
                char openingBracket = 0;
                switch (c){
                    case ')':
                        openingBracket = '(';
                        break;
                    case ']':
                        openingBracket = '[';
                        break;
                    case '}':
                        openingBracket = '{';
                        break;
                    case '>':
                        openingBracket = '<';
                        break;
                }
                if (bracketStack.charAt(bracketStack.length()-1) == openingBracket)
                    bracketStack = bracketStack.substring(0,bracketStack.length()-1);
            }
            else
                bracketStack = bracketStack.concat(String.valueOf(c));
        }
        if (bracketStack.isEmpty()) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
    @Test
    public void parenthesisProblemUsingStack(){
        String in = "{[()[]]{}<<>>}";
        Stack<Character> bracketsStack = new Stack<>();
        for (int i = 0; i < in.length(); i++) {
            Character currentChar = in.charAt(i);
            switch (currentChar){
                case '(':
                    bracketsStack.push(currentChar);
                    break;
                case '{':
                    bracketsStack.push(currentChar);
                    break;
                case '[':
                    bracketsStack.push(currentChar);
                    break;
                case '<':
                    bracketsStack.push(currentChar);
                    break;
                case ')':
                    if (bracketsStack.pop() == currentChar);
                    break;
                case '}':
                    if (bracketsStack.pop() == currentChar);
                    break;
                case ']':
                    if (bracketsStack.pop() == currentChar);
                    break;
                case '>':
                    if (bracketsStack.pop() == currentChar);
                    break;
            }
        }
        if (bracketsStack.isEmpty())
            System.out.println("Valid");
        else
            System.out.println("Invalid");
    }

}
