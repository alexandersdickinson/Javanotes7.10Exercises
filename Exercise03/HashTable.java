public class HashTable{
	
	ListNode[] ary = new ListNode[100];

	private static class ListNode{
		
		ListNode next;
		String key;
		int val;
		
		ListNode(String key, int val, ListNode next){//constructor
			this.key = key;
			this.val = val;
			this.next = next;
		}
		
	}
	
	public ListNode get(String key){
		int hashCode;
		hashCode = Math.abs(key.hashCode() % 100);
		
		if(ary[hashCode].key == key){
			return ary[hashCode];
		}
		else{
			ListNode runner = ary[hashCode].next;
			while(runner.key != key){
				runner = runner.next;
			}
			return runner;
		}
		
	}
	
	public void put(String key, int value){
		int hashCode;
		hashCode = Math.abs(key.hashCode() % 100);
		if(ary[hashCode] == null){
			ary[hashCode] = new ListNode(key, value, null);
		}
		else{
			ListNode runner = ary[hashCode].next;
			while(runner != null){
				runner = runner.next;
			}
			runner = new ListNode(key, value, null);
		}
	}
	
	public void remove(String key){
		int hashCode;
		hashCode = Math.abs(key.hashCode() % 100);
		
		if(ary[hashCode].key == key){
			ary[hashCode] = null;
		}
		else{
			ListNode runner = ary[hashCode];
			while(ary[hashCode].next.key != key){
				runner = runner.next;
			}
			runner.next = null;
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
		for(ListNode node:ary){
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
		
		StringBuilder key;
		int val;
		String[] randList = new String[5];
		int k;//determines index of randList
		
		for(int i = 0; i < 50; i ++){
			key = new StringBuilder();
			for(int j = 0; j < 7; j++){
				key.append((char)((int)(Math.random() * 26) + 'a'));
				val = (int)(Math.random() * 10000);
				ary.put(key.toString(), val);
			}
			if(i % 10 == 0){
				k = i/10;
				randList[k] = get(key);
			}
		}
		
		System.out.println(size());
		
	}
	
}