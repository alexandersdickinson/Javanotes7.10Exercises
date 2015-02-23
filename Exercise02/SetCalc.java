/**
	This class takes a string provided by the user with two sets of positive integers and performs union, intersection, and difference operations. 
*/

import java.util.TreeSet;

public class SetCalc{
	
	public static void main(String[] args){
						
		System.out.println("Input                    Output              ");
		System.out.println("-------------------      --------------------");
		while(true){
			
			char ch;
			
			if(TextIO.peek() == '\n'){
				break;
			}
			
			setOperation();
			
            do {  // Copy extra characters on line to output.  If there 
                  // was no error, then the only character that is copied
                  // is the end-of-line character.
               ch = TextIO.getAnyChar();
               System.out.print(ch);
            } while (ch != '\n');
			
		}
		
	}
	
	/**
		Takes input and parses it into two TreeSets of integers, and then performs an union, intersection, or difference operation on them.
		Precondition: An input String with two sets of positive integers with a valid operator in between them (*, + or -).
		Postcondition: A TreeSet of integers created from the union, intersection, or difference of two other integer TreeSets.
		
		@throws IllegalArgumentException Prevents operations that are not supported by this function.
	*/
	static void setOperation(){
		
		char operator;
		TreeSet<Integer> setA = setParse();
		TextIO.skipBlanks();
		operator = TextIO.getChar();
		if(operator != '*' && operator != '+' && operator != '-'){
			throw new IllegalArgumentException("The operator is not valid.");
		}
		TreeSet<Integer> setB = setParse();	
		
		switch(operator){
			case '+': setA.addAll(setB);
					  break;
			case '-': setA.removeAll(setB);
					  break;
			default: setA.retainAll(setB);
					  break;
		}
		
		System.out.println(setA);
		
	}
	
	/**
		This creates a set of integers from a line of input.
		Precondition: A set of positive integers enclosed in brackets, separated by commas.
		Postcondition: A TreeSet of positive integers.
		
		@throws IllegalArgumentException Prevents users from inputting negative integers.
		@return A TreeSet of positive integers.
	*/
	private static TreeSet<Integer> setParse(){
		
		char ch;
		
		TreeSet<Integer> set = new TreeSet<Integer>();
			
		while(TextIO.peek() != '['){
			ch = TextIO.getAnyChar();
		}	
		
		TextIO.getAnyChar();
					
		while(true){
			
			set.add(TextIO.getInt());
			while(!Character.isDigit(TextIO.peek())){
				if(TextIO.peek() == ']'){
					TextIO.getAnyChar();
					return set;
				}
				ch = TextIO.getAnyChar();
			}
		
		}
		
	}
	
}