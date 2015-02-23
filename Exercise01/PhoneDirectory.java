/**
 * A PhoneDirectory holds a list of names with a phone number for
 * each name.  It is possible to find the number associated with
 * a given name, and to specify the phone number for a given name.
 */

import java.util.TreeMap;

public class PhoneDirectory{
	
	public static void main(String[] args){
		
		String name = "";
		String number = " ";
		TreeMap<String, String> contacts = new TreeMap<String, String>();
		
		System.out.println("This program compiles the names and phone numbers of people");
		System.out.println("and prints out contact information in alphabetical order.");
		System.out.println("The program can be ended at any time by pressing return.");
		
		while(true){
			System.out.println("Enter a name:");
			if(TextIO.peek() == '\n'){
				break;
			}
			else{
				name = TextIO.getln();
			}
			System.out.println("Enter " + name + "\'s phone number:");
			if(TextIO.peek() == '\n'){
				break;
			}
			else{
				number = TextIO.getln();
			}
			contacts.put(name, number);
		}
		
		for(String key:contacts.keySet()){
			String num = contacts.get(key);
			System.out.println(key + "\'s phone number is " + number + ".");
		}
		
	}

} // end class PhoneDirectory