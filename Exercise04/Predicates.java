import java.util.Collections;
import java.util.ArrayList;

public class Predicates<T> implements Predicate{
	
	public static <T> void remove(Collection<T> coll, Predicate<T> pred){
		Iterator<T> iter = coll.iterator();
		while(iter.hasNext()){
			T item = iter.next();
			if(pred.test(item)){
				coll.remove(item);
			}
		}
	}
	   // Remove every object, obj, from coll for which
	   // pred.test(obj) is true.
   
	public static <T> void retain(Collection<T> coll, Predicate<T> pred){
		Iterator<T> iter = coll.iterator();
		while(iter.hasNext()){
			T item = iter.next();
			if(!pred.test(item)){
				coll.remove(item);
			}
		}
	}
	   // Remove every object, obj, from coll for which
	   // pred.test(obj) is false.  (That is, retain the
	   // objects for which the predicate is true.)
   
	public static <T> List<T> collect(Collection<T> coll, Predicate<T> pred){
		
		List<T> objects = new ArrayList<T>();
		for(T element:coll){
			if(pred.test(element)){
				objects.add(element);
			}
		}
		
		return objects;
		
	}
	   // Return a List that contains all the objects, obj,
	   // from the collection, coll, such that pred.test(obj)
	   // is true.
   
	public static <T> int find(ArrayList<T> list, Predicate<T> pred){
		
		for(T element:list){
			if(pred.test(element)){
				return list.indexOf(element);
			}
		}
		
		return -1;
		
	}
	   // Return the index of the first item in list
	   // for which the predicate is true, if any.
	   // If there is no such item, return -1.
	
}