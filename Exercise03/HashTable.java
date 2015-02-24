public class HashTable{
	
	ListNode[] table;
	
	HashTable(){
		table = new ListNode[100];
	}

	private static class ListNode{
		
		ListNode next;
		String key;
		int val;
		
		ListNode(String key, int val){//constructor
			this.key = key;
			this.val = val;
			next = null;
		}
		
	}
	
	public ListNode get(String key){
		int hashCode;
		hashCode = Math.abs(key.hashCode() % 100);
		
		if(table[hashCode].key.equals(key)){
			return table[hashCode];
		}
		else{
			ListNode runner = table[hashCode];
			while(runner.next != null && !runner.key.equals(key)){
				runner = runner.next;
			}
			return runner;
		}
		
	}
	
	public void put(String key, int value){
		int hashCode;
		hashCode = Math.abs(key.hashCode() % 100);
		if(table[hashCode] == null){
			table[hashCode] = new ListNode(key, value);
		}
		else{
			ListNode runner = table[hashCode];
			while(runner.next != null){
				runner = runner.next;
			}
			runner.next = new ListNode(key, value);
		}
	}
	
	public void remove(String key){
		int hashCode;
		hashCode = Math.abs(key.hashCode() % 100);
		
		if(table[hashCode].key == key){
			table[hashCode] = table[hashCode].next;
		}
		else{
			ListNode prev = table[hashCode];
			ListNode curr = table[hashCode].next;
			while(curr != null && !curr.key.equals(key)){
				prev = curr;
				curr = curr.next;
			}
			prev.next = curr.next;
		}
	}
	
	public boolean containsKey(String key){
		if(get(key) == null){
			return true;
		}
		else
			return false;
	}
	
	public int size(){
		int counter = 0;
		for(ListNode node:table){
			if(node != null){
				ListNode runner = node;
				counter++;
				while(runner.next != null){
					runner = runner.next;
					counter++;
				}
			}
		}
		
		return counter;
	}
	
	public static void main(String[] args){
		
		HashTable hashTable = new HashTable();
		StringBuilder keyBuilder;
		String key;
		int val;
		String[] randList = new String[5];
		
		for(int i = 0; i < 50; i ++){
			keyBuilder = new StringBuilder();
			for(int j = 0; j < 7; j++){
				keyBuilder.append((char)((int)(Math.random() * 26) + 'a'));
			}
			
			val = (int)(Math.random() * 10000);
			key = keyBuilder.toString();
			hashTable.put(key, val);
			System.out.println(hashTable.get(key).key + "   " + hashTable.get(key).val);
			
		}
		
		System.out.println(hashTable.size());
		
	}
	
}