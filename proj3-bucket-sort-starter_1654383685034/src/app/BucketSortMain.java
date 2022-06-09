package app;

public class BucketSortMain {

   public static void main(String[] args) throws Exception{
      Sorter s = new IntegerBucketSorter ();
      System.out.println("input:");
      int[] testArr = {100, 23, 92, 498, 12, 29, 48, 354, 1, 57, 33};
      System.out.println(printArr(testArr));
      // correct output: 1, 12, 23, 29, 33, 48, 57, 92, 100, 354, 498
      int[] resultArr = s.sort(testArr);
      System.out.println("output:");
      System.out.println(printArr(resultArr));
   }
   
   public static String printArr(int[] arr){
       StringBuilder sb = new StringBuilder();
       for(int i=0;i<arr.length;i++){
          sb.append(arr[i]);
          if (i<arr.length-1)
             sb.append(", ");
       }
      return sb.toString();      
   }
}