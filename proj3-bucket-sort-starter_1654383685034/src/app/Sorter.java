package app;
/**
 * Generic sorting interface. At this time, only arrays of integers is supported.
 */
public interface Sorter  {
   
   public int[] sort(int[] unsorted) throws Exception;

}