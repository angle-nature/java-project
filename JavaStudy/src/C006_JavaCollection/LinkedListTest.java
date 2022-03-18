/**
   @version 1.10 2004-08-02
   @author Cay Horstmann
*/
package C006_JavaCollection;
import java.util.*;


/**
   This program demonstrates operations on linked lists.
*/
public class LinkedListTest
{  
   public static void main(String[] args)
   {  	  
	   test1();
   }
   
   public static void test1(){
		List<String> a = new LinkedList<String>();
		a.add("Amy");
		a.add("Carl");
		a.add("Erica");
		a.add("Bob");
		a.add("Doug");
		a.add("Frances");

		System.out.println(a);

		ListIterator<String> aIter = a.listIterator();
		while (aIter.hasNext()) {
			System.out.println(aIter.next());
		}
   }
   
   public static void test2(){
		List<String> a = new LinkedList<String>();
		
		a.add("Amy");
		a.add("Carl");
		a.add("Erica");
		System.out.println(a);
		
		ListIterator<String> aIter = a.listIterator();
		aIter.next();
		aIter.add("Bob");
		aIter.next();
		aIter.add("Doug");
		aIter.next();
		aIter.add("Frances");
		System.out.println(a);
  }
   
   public static void test3(){
	   List<String> a = new LinkedList<String>();
	      a.add("Amy");
	      a.add("Carl");
	      a.add("Erica");

	      List<String> b = new LinkedList<String>();
	      b.add("Bob");
	      b.add("Doug");
	      b.add("Frances");
	      b.add("Gloria");

	      // merge the words from b into a

	      ListIterator<String> aIter = a.listIterator();
	      Iterator<String> bIter = b.iterator();

	      while (bIter.hasNext())
	      {  
	         if (aIter.hasNext()) aIter.next();
	         aIter.add(bIter.next());
	      }

	      System.out.println(a);

	      // remove every second word from b

	      bIter = b.iterator();
	      while (bIter.hasNext())
	      {  
	         bIter.next(); // skip one element
	         if (bIter.hasNext())
	         {  
	            bIter.next(); // skip next element
	            bIter.remove(); // remove that element
	         }
	      }

	      System.out.println(b);

	      // bulk operation: remove all words in b from a

	      a.removeAll(b);

	      System.out.println(a);
	   
   }
}


