package app;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *  This class provides methods that perform operations on a list of generic objects.
 *  The Objects are assumed to have an appropriate implementation of the equals method.
 */
public class ArrayListServices <T> {

   /**
    * This method takes an ArrayList as a parameter and returns a new ArrayList that 
    * does not contain any duplicate data. For example, if this list was passed in: 
    * [A, B, D, A, A, E, B], the method would return a list containing: [A, B, D, E]. 
    * The ordering of the data does not matter. 
    * Assume that the parameter is not null, but it may be an empty ArrayList, in which case 
    * your method returns a new, empty ArrayList.
    * Also note that the ArrayList that is returned must be a new ArrayList which is not the 
    * same as the ArrayList passed in. In other words, the parameter must not be changed by your method code.
    */
   public ArrayList<T> deDuplicate(ArrayList<T> inputList){
      //Write your comments on how you implemented the method.
      /**
       I first created a new arrayList to return called the outputList which is meant to return the 
       deduplicated contents. Then, I made a for loop to run through the inputList,
       and add elements from the inputList to the outputList that were NOT already
       in the outputList before hand. This removes all the duplicates in the new list. 
       I then simply returned the deduplicated outputList.  
      **/
      
	   ArrayList<T> outputList = new ArrayList<T>(); 
	   
	   for (int i = 0; i < inputList.size(); i++) {
		   if (!outputList.contains(inputList.get(i))) {
			   outputList.add(inputList.get(i)); 
		   }
	   }
	   
	   
      //TODO: Implement this method.
      return outputList;
   }

   /**
    * This method takes two ArrayLists as parameters and returns a new ArrayList that 
    * contains the intersection of the data in the ArrayLists passed in. The intersection 
    * contains the elements that occur in both lists.
    * For example, if these lists were passed in: [A, B, D, A, A, E, B], [B, E, C], the method 
    * would return a list containing: [B, E]. The ordering of the data does not matter. Note that 
    * the result does not contain any duplicates.
    * Assume that the parameters are not null, but one or both may be an empty ArrayList, in which 
    * case your method returns a new, empty ArrayList.
    * Also note that the ArrayList that is returned must be a new ArrayList which is not the same as 
    * the ArrayList passed in. In other words, the parameter must not be changed by your method code.
    */
   public ArrayList<T> getSetIntersection(ArrayList<T> listA, ArrayList<T> listB){
      //Write your comments on how you implemented the method.
      /**
       I initialized a new arraylist with the contents of List A called setIntersection.
       I then used the retainAll method to make the setIntersection keep the elements
       which it's contents (ListA's) share with List B. I then returned the deduplicated
       setIntersection.  
      **/   
	   
	   ArrayList<T> setIntersection = new ArrayList<T>(listA);
		setIntersection.retainAll(listB); 
		
      //TODO: Implement this method.
		return deDuplicate(setIntersection);
   }

   /**
    *  This method takes two ArrayLists as parameters and returns a new ArrayList that 
    * contains the set difference of the data in the ArrayLists passed in. The set difference 
    * contains the elements that occur only in one or the other list, but not in both.
    * For example, if these lists were passed in: [A, B, D, A, A, E, B], [B, E, C], the method 
    * would return a list containing: [A, C]. The ordering of the data does not matter. Note 
    * that the result does not contain any duplicates.
    * Assume that the parameters are not null, but one or both may be an empty ArrayList. In the 
    * case where one list is empty, your method returns a new ArrayList that contains all of the 
    * elements on the other list- with no duplicates. In the case where both lists are empty, your 
    * method returns a new, empty ArrayList.
    * Also note that the ArrayList that is returned must be a new ArrayList which is not the same 
    * as the ArrayList passed in. In other words, the parameter must not be changed by your method code.
    */
   public ArrayList<T> getSetDifference(ArrayList<T> listA, ArrayList<T> listB){
      //Write your comments on how you implemented the method.
      /**
       I first initialzed an arraylist with contents of listA and removed all the shared 
       contents of listB from listA using method removeAll. I repeated the same with 
       listB and used the removeAll method to remove all shared contents of listA
       from listB. I then added the two different arraylists' contents to one arraylist,
       and returned the deduplicated difference. 
      **/
	   
	   ArrayList<T> listAdiffB = new ArrayList<T>(listA);
	   listAdiffB.removeAll(listB); 
	   ArrayList <T> listBdiffA = new ArrayList<T>(listB);
	   listBdiffA.removeAll(listA); 
	   ArrayList<T> difference = new ArrayList<T>(listAdiffB);
	   difference.addAll(listBdiffA); 
	   
	   
      
      //TODO: Implement this method.
      return deDuplicate(difference);
   }

}