//$Id$
package com.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ExpressionEvalution {

	public static void main(String[] args) {
		
		ExpressionEvalution eval=new ExpressionEvalution();
		String s="(+ 5 4 6)";//"(+ 3 (* 5 2) (- 6 3))";//"(*2(-73)4)"; //(+ 5 4 6)
		
		
		String result="";
		
		s="(+ 5 4 6)";
		result=eval.convertItToInFix(s);
		System.out.println(s+"="+"="+result+"="+eval.evaluateInFixExpression(result));
		
		s="(*2(-73)4)";
		result=eval.convertItToInFix(s);
		System.out.println(s+"="+"="+result+"="+eval.evaluateInFixExpression(result));
		
		s="(+ 3 (* 5 2) (- 6 3))";
		result=eval.convertItToInFix(s);
		System.out.println(s+"="+"="+result+"="+eval.evaluateInFixExpression(result));

	}
	
	String convertItToInFix(String expression) {
		Stack<Character> stack=new Stack<Character>();
		
		Queue<Character> queue= new LinkedList<Character>();
		
		for(char c:expression.toCharArray()) {
			if(c!=' ') {
				queue.add(c);
			}
		}
		
		String result="";
		while(!queue.isEmpty()) {
			
			if(isOperand(queue.peek())) {
				stack.push(queue.remove());
			}else if(isOpenBracket(queue.peek())) {
				result+=queue.remove();
			}else if(isClosedBracket(queue.peek())) {
				result+=queue.remove();
				stack.pop();
				char tem=' ';
				try {
					tem = queue.peek();
				} catch (Exception e) {
				}
				if(isNumber(tem) || isOpenBracket(tem)) {
					result+=stack.peek();	
				}
			}else {
				result+=queue.remove();
				if(!isClosedBracket(queue.peek())) { 
					result+=stack.peek();
				}
			}
		}
		return result;
	}
	int evaluateInFixExpression(String expr) {
		Stack<Integer> number=new Stack<Integer>();
		Stack<Character> operator=new Stack<Character>();
		
		for(char c:expr.toCharArray())  {
			if(isOperand(c) || isOpenBracket(c)) {
				operator.push(c);
			} else if(isNumber(c)) {
				number.push(Integer.parseInt(""+c));
			}else {
				int op2=number.pop();
				char op=operator.pop();
				int op1=number.pop();
				if(operator.peek()=='('){
					operator.pop();
				}
				int sss=calcualte(op1, op2, op);
				number.push(sss);
			}
		}
		
		while(!operator.isEmpty()) {
			int op2=number.pop();
			char op=operator.pop();
			int op1=number.pop();
			if(operator.peek()=='('){
				operator.pop();
			}
			int sss=calcualte(op1, op2, op);
			number.push(sss);
		}
		return number.peek();
	}
	
	int calcualte(int a,int b,Character operator) {
		if(operator=='+')
			return  (a+b);
		else if(operator=='-')
			return  (a-b);
		else if(operator=='*')
			return  (a*b);
		else if(operator=='/')
			return (a/b);
		else
			return 0;
	}
	boolean isNumber(Character s) {
		try{
			int i=Integer.parseInt(""+s);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	boolean isOperand(Character s) {
		if(s=='+')
			return true;
		else if(s=='-')
			return true;
		else if(s=='*')
			return true;
		else if(s=='/')
			return true;
		else
			return false;
	}
	
	boolean isOpenBracket(Character s) {
		try {
			if(s=='(')
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	boolean isClosedBracket(Character s) {
		try {
			if(s==')')
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

}
