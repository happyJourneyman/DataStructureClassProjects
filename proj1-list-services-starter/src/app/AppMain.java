package app;
import java.util.ArrayList;

public class AppMain {

   public static void main(String[] args)  {
   // uncomment or comment to run different tests:
      System.out.println("Testing with Integers:");
      intTest();
    //  System.out.println("Testing with Students:");
     // studentTest();
   }

   public static void intTest() {
      // create instance of ArrayListServices:
      ArrayListServices<Integer> als = new ArrayListServices<Integer>();
      // create test set 1:
      ArrayList<Integer> dataSet1 = new  ArrayList<Integer>();
      dataSet1.add(100);
      dataSet1.add(33);
      dataSet1.add(22);
      dataSet1.add(100);
      dataSet1.add(54);
      dataSet1.add(95);
      dataSet1.add(33);
      dataSet1.add(100);
      System.out.println("Data Set 1:");
      printArray(dataSet1);
      // create test set 2:
      ArrayList<Integer> dataSet2 = new  ArrayList<Integer>();
      dataSet2.add(92);
      dataSet2.add(54);
      dataSet2.add(87);
      dataSet2.add(33);
      dataSet2.add(54);
      dataSet2.add(200);
      System.out.println("Data Set 2:");
      printArray(dataSet2);
      //test the three methods in ArrayListServices:
      ArrayList<Integer> deDup1 = als.deDuplicate(dataSet1); 
      System.out.println("Deduplicted set 1:"); 
      printArray(deDup1); 
      ArrayList<Integer> deDup2 = als.deDuplicate(dataSet2); 
      System.out.println("Deduplicted set 2:"); 
      printArray(deDup2);

      ArrayList<Integer> diff = als.getSetDifference(dataSet1, dataSet2); 
      System.out.println("Set Difference:"); 
      printArray(diff);
      ArrayList<Integer> intersect = als.getSetIntersection(dataSet1, dataSet2); 
      System.out.println("Set Intersection:"); 
      printArray(intersect);
   }

   public static void studentTest() {
      // create instance of ArrayListServices:
      ArrayListServices<Student> als = new ArrayListServices<Student>();
      // create set 1:
      ArrayList<Student> data1 = new  ArrayList<Student>();
      data1.add(new Student("100934","Nisha","Vendrian","nvendrian@gmail.com","223 345-1299",3.8,2));
      data1.add(new Student("100421","Homer","Solent","hsolent@gmail.com","123 456-7890",4.0,3));
      data1.add(new Student("101879","Jorge","Velasquez","jvelasuez@gmail.com","345 121-3205",3.5,1));
      data1.add(new Student("100882","Tiskan","Wallander","twallander@gmail.com","890 123-5478",2.5,4));
      data1.add(new Student("100934","Nisha","Vendrian","nvendrian@gmail.com","223 345-1299",3.8,2));
      System.out.println("Input Set 1:");
      printArray(data1);
      //create set 2:
      ArrayList<Student> data2 = new  ArrayList<Student>();
      data2.add(new Student("103733","Anusha","Malik","amalik@gmail.com","345 889-9934",3.5,3));
      data2.add(new Student("101223","Homer","Chen","hchen@gmail.com","990 456-3827",2.9,2));
      data2.add(new Student("101944","Salena","Aldero","saldero@gmail.com","345 133-3202",3.3,1));
      data2.add(new Student("100882","Tiskan","Wallander","twallander@gmail.com","890 123-5478",2.5,4));
      System.out.println("Input Set 2:");
      printArray(data2);
      ArrayList<Student> deDup1 = als.deDuplicate(data1);
      System.out.println("Deduplicted Set 1:");
      printArray(deDup1); 
      ArrayList<Student> deDup2 = als.deDuplicate(data2);
      System.out.println("Deduplicted Set 2:");
      printArray(deDup2); 
      ArrayList<Student> diff = als.getSetDifference(data1, data2); 
      System.out.println("Set Difference:"); 
      printArray(diff);
      ArrayList<Student> intersect = als.getSetIntersection(data1, data2); 
      System.out.println("Set Intersection:"); 
      printArray(intersect);
   }
   
   public static void printArray(ArrayList list){
      for (int i=0; i<list.size();i++)
         System.out.print(list.get(i) + " ");
      System.out.println(" ");
   }
}