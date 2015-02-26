import java.util.TreeSet;
import java.util.TreeMap;
import java.util.Map;

public class Concordance{
	
	private static TreeMap<String, TreeSet<Integer>> concord;//data structure to store the concordance
	
	public static void main(String[] args){
		
		int lineNo = 1;//line number
		concord = new TreeMap<String, TreeSet<Integer>>();
		String word;
		
		if (TextIO.readUserSelectedFile() == false) {//read from file
            System.out.println("No input file selected. Exiting.");
            System.exit(1);
        }
		
		while(true){
			word = readNextWord();
			
			if(word == null){
				System.out.println("end of file");
				break;
			}
			else if(word.equals("\n")){
				lineNo++;
				System.out.println("new line");
			}
			else if(word.toLowerCase().equals("the")){
				System.out.println("the");
				continue;
			}
			else if(word.length() < 3){
				System.out.println("less than 3");
				continue;
			}
			else{
				System.out.println("normal word");
				addReference(word, lineNo);
			}
		}
		
		TextIO.writeUserSelectedFile();
		printConcordance();
		
	}
	
	/**
	 * Add a page reference to the index.
	 */
	static void addReference(String term, int lineNum) {
	   TreeSet<Integer> references; // The set of page references that we
	                                //    have so far for the term.
	   references = concord.get(term);
	   if (references == null){
	          // This is the first reference that we have
	          // found for the term.  Make a new set containing
	          // the page number and add it to the index, with
	          // the term as the key.
	       TreeSet<Integer> firstRef = new TreeSet<Integer>();
	       firstRef.add( lineNum );  // pageNum is "autoboxed" to give an Integer!
	       concord.put(term,firstRef);
	   }
	   else {
	         // references is the set of page references
	         // that we have found previously for the term.
	         // Add the new page number to that set.  This
	         // set is already associated to term in the index.
	      references.add( lineNum ); // pageNum is "autoboxed" to give an Integer!
	   }
	}
	
	/**
	 * Print each entry in the index.
	 */
	static void printConcordance() {
   
	    for (Map.Entry<String, TreeSet<Integer>>  entry :  concord.entrySet() ) {
    
	        String term = entry.getKey();
	        TreeSet<Integer> pageSet = entry.getValue();
   
	        TextIO.put( term + " " );
	        for ( int page : pageSet ) {
	            TextIO.put( page + " " );
	        }
	        TextIO.putln();
   
	    }
   
	}
	
	/**
	     * Read the next word from TextIO, if there is one.  First, skip past
	     * any non-letters in the input.  If an end-of-file is encountered before 
	     * a word is found, return null.  Otherwise, read and return the word.
	     * A word is defined as a sequence of letters.  Also, a word can include
	     * an apostrophe if the apostrophe is surrounded by letters on each side.
	     * @return the next word from TextIO, or null if an end-of-file is encountered
	     */
	    private static String readNextWord() {
	        char ch = TextIO.peek(); // Look at next character in input.
	        while (ch != TextIO.EOF && ! Character.isLetter(ch)) {
				if(ch == '\n'){
		            TextIO.getAnyChar();  // Read the character.
					return "\n";
				}
	            TextIO.getAnyChar();  // Read the character.
	            ch = TextIO.peek();   // Look at the next character.
	        }
	        if (ch == TextIO.EOF) // Encountered end-of-file
	            return null;
	        // At this point, we know that the next character is a letter, so read a word.
	        String word = "";  // This will be the word that is read.
	        while (true) {
	            word += TextIO.getAnyChar();  // Append the letter onto word.
	            ch = TextIO.peek();  // Look at next character.
	            if ( ch == '\'' ) {
	                    // The next character is an apostrophe.  Read it, and
	                    // if the following character is a letter, add both the
	                    // apostrophe and the letter onto the word and continue
	                    // reading the word.  If the character after the apostrophe
	                    // is not a letter, the word is done, so break out of the loop.
	                TextIO.getAnyChar();   // Read the apostrophe.
	                ch = TextIO.peek();    // Look at char that follows apostrophe.
	                if (Character.isLetter(ch)) {
	                    word += "\'" + TextIO.getAnyChar();
	                    ch = TextIO.peek();  // Look at next char.
	                }
	                else
	                    break;
	            }
	            if ( ! Character.isLetter(ch) ) {
	                    // If the next character is not a letter, the word is
	                    // finished, so break out of the loop.
	                break;
	            }
	            // If we haven't broken out of the loop, next char is a letter.
	        }
	        return word;  // Return the word that has been read.
	    }
	
}