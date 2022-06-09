package test;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import app.ArrayListServices;

public class ProjectTests {
  ArrayListServices<Integer> alsInteger = null;

  @Before
  public void before() {
    alsInteger = new ArrayListServices<Integer>();
  }


    // Test the deduplicate method:
  @Test
  public void testDeduplicateEmptyArg() {
     ArrayList<Integer> intList = new ArrayList<Integer>();
     ArrayList<Integer> resList = alsInteger.deDuplicate(intList);
     assertTrue(resList.size()==0);
  }

  @Test
  public void testDeduplicateOneElem() {
     ArrayList<Integer> intList = new ArrayList<Integer>();
     intList.add(25);
     ArrayList<Integer> resList = alsInteger.deDuplicate(intList);
     assertTrue(resList.size()==1);
     assertTrue(resList.contains(25));
  }

  @Test
  public void testDeduplicateTwoDuplicateElems() {
     ArrayList<Integer> intList = new ArrayList<Integer>();
     intList.add(25);
     intList.add(25);
     ArrayList<Integer> resList = alsInteger.deDuplicate(intList);
     assertTrue(resList.size()==1);
     assertTrue(resList.contains(25));
  }

  @Test
  public void testDeduplicateTwoElems() {
     ArrayList<Integer> intList = new ArrayList<Integer>();
     intList.add(25);
     intList.add(6);
     ArrayList<Integer> resList = alsInteger.deDuplicate(intList);
     assertTrue(resList.size()==2);
     assertTrue(resList.contains(25) && resList.contains(6));
  }

  @Test
  public void testDeduplicateManyDuplicateElems1() {
     ArrayList<Integer> intList = new ArrayList<Integer>();
     intList.add(6);
     intList.add(6);
     intList.add(6);
     intList.add(6);
     intList.add(6);
     intList.add(6);
     ArrayList<Integer> resList = alsInteger.deDuplicate(intList);
     assertTrue(resList.size()==1);
     assertTrue(resList.contains(6));
  }

  @Test
  public void testDeduplicateManyDuplicateElems2() {
     ArrayList<Integer> intList = new ArrayList<Integer>();
     intList.add(25);
     intList.add(6);
     intList.add(6);
     intList.add(6);
     intList.add(6);
     intList.add(6);
     intList.add(25);
     intList.add(25);
     intList.add(6);
     ArrayList<Integer> resList = alsInteger.deDuplicate(intList);
     assertTrue(resList.size()==2);
     assertTrue(resList.contains(25) && resList.contains(6));
  }

  @Test
  public void testDeduplicateManyElemsNoDuplicates() {
     ArrayList<Integer> intList = new ArrayList<Integer>();
     intList.add(25);
     intList.add(6);
     intList.add(3);
     intList.add(18);
     intList.add(22);
     intList.add(15);
     intList.add(5);
     intList.add(7);
     ArrayList<Integer> resList = alsInteger.deDuplicate(intList);
     assertTrue(resList.size()==8);
     assertTrue(resList.contains(25) && resList.contains(6) && resList.contains(3) && resList.contains(18) &&
     resList.contains(22) && resList.contains(15) && resList.contains(5) && resList.contains(7));
  }

  @Test
  public void testDeduplicateManyElemsSomeDuplicates() {
     ArrayList<Integer> intList = new ArrayList<Integer>();
     intList.add(25);
     intList.add(6);
     intList.add(3);
     intList.add(18);
     intList.add(22);
     intList.add(18);
     intList.add(5);
     intList.add(25);
     ArrayList<Integer> resList = alsInteger.deDuplicate(intList);
     assertTrue(resList.size()==6);
     assertTrue(resList.contains(25) && resList.contains(6) && resList.contains(3) && resList.contains(18) &&
     resList.contains(22) && resList.contains(5));
  }

  // Test the getSetIntersection method:

  @Test
  public void testGetSetIntersectionEmptyArgs() {
     ArrayList<Integer> dataSet1 = new  ArrayList<Integer>();
     ArrayList<Integer> dataSet2 = new  ArrayList<Integer>();
     ArrayList<Integer> resList = alsInteger.getSetIntersection(dataSet1, dataSet2);
     assertTrue(resList.size()==0);
  }

  @Test
  public void testGetSetIntersectionOneEmptyArg() {
     ArrayList<Integer> dataSet1 = new  ArrayList<Integer>();
     ArrayList<Integer> dataSet2 = new  ArrayList<Integer>();
     dataSet2.add(92);
     dataSet2.add(54);
     dataSet2.add(87);
     ArrayList<Integer> resList = alsInteger.getSetIntersection(dataSet1, dataSet2);
     assertTrue(resList.size()==0);
  }

  @Test
  public void testGetSetIntersection1() {
     ArrayList<Integer> dataSet1 = new  ArrayList<Integer>();
     dataSet1.add(100);
     dataSet1.add(22);
     dataSet1.add(100);
     dataSet1.add(95);
     dataSet1.add(22);
     dataSet1.add(100);
     // create test set 2:
     ArrayList<Integer> dataSet2 = new  ArrayList<Integer>();
     dataSet2.add(92);
     dataSet2.add(54);
     dataSet2.add(87);
     dataSet2.add(33);
     dataSet2.add(54);
     dataSet2.add(200);
     ArrayList<Integer> resList = alsInteger.getSetIntersection(dataSet1, dataSet2);
     assertTrue(resList.size()==0);
  }

  @Test
  public void testGetSetIntersection2() {
     ArrayList<Integer> dataSet1 = new  ArrayList<Integer>();
     dataSet1.add(100);
     dataSet1.add(33);
     dataSet1.add(22);
     dataSet1.add(100);
     dataSet1.add(54);
     dataSet1.add(95);
     dataSet1.add(33);
     dataSet1.add(100);
     // create test set 2:
     ArrayList<Integer> dataSet2 = new  ArrayList<Integer>();
     dataSet2.add(92);
     dataSet2.add(54);
     dataSet2.add(87);
     dataSet2.add(33);
     dataSet2.add(54);
     dataSet2.add(200);
     ArrayList<Integer> resList = alsInteger.getSetIntersection(dataSet1, dataSet2);
     assertTrue(resList.size()==2);
     assertTrue(resList.contains(33) && resList.contains(54));
  }
    // Test the getSetDifference method:

    @Test
    public void testGetSetDifferenceEmptyArgs() {
       ArrayList<Integer> dataSet1 = new  ArrayList<Integer>();
       ArrayList<Integer> dataSet2 = new  ArrayList<Integer>();
       ArrayList<Integer> resList = alsInteger.getSetDifference(dataSet1, dataSet2);
       assertTrue(resList.size()==0);
    }

    @Test
    public void testGetSetDifferenceOneEmptyArg() {
       ArrayList<Integer> dataSet1 = new  ArrayList<Integer>();
       ArrayList<Integer> dataSet2 = new  ArrayList<Integer>();
       dataSet2.add(92);
       dataSet2.add(54);
       dataSet2.add(87);
       ArrayList<Integer> resList = alsInteger.getSetDifference(dataSet1, dataSet2);
       assertTrue(resList.size()==3);
       assertTrue(resList.contains(92) && resList.contains(54) && resList.contains(87));
    }

    @Test
    public void testGetSetDifference1() {
       ArrayList<Integer> dataSet1 = new  ArrayList<Integer>();
       dataSet1.add(100);
       dataSet1.add(22);
       dataSet1.add(100);
       dataSet1.add(95);
       dataSet1.add(22);
       dataSet1.add(100);
       // create test set 2:
       ArrayList<Integer> dataSet2 = new  ArrayList<Integer>();
       dataSet2.add(92);
       dataSet2.add(54);
       dataSet2.add(200);
       dataSet2.add(22);
       dataSet2.add(54);
       dataSet2.add(200);
       ArrayList<Integer> resList = alsInteger.getSetDifference(dataSet1, dataSet2);
       assertTrue(resList.size()==5);
       assertTrue(resList.contains(100) && resList.contains(95) && resList.contains(92) && resList.contains(54) &&
       resList.contains(200));
    }

    @Test
    public void testGetSetDifference2() {
       ArrayList<Integer> dataSet1 = new  ArrayList<Integer>();
       dataSet1.add(100);
       dataSet1.add(33);
       dataSet1.add(22);
       dataSet1.add(100);
       dataSet1.add(95);
       dataSet1.add(33);
       dataSet1.add(100);
       // create test set 2:
       ArrayList<Integer> dataSet2 = new  ArrayList<Integer>();
       dataSet2.add(92);
       dataSet2.add(54);
       dataSet2.add(54);
       dataSet2.add(37);
       dataSet2.add(54);
       dataSet2.add(200);
       ArrayList<Integer> resList = alsInteger.getSetDifference(dataSet1, dataSet2);
       assertTrue(resList.size()==8);
       assertTrue(resList.contains(100) && resList.contains(33) && resList.contains(22) && resList.contains(95) &&
       resList.contains(92) && resList.contains(54) && resList.contains(37) && resList.contains(200));
    }

}
