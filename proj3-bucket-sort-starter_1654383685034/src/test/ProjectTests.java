package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.*;
import app.*;

public class ProjectTests {
   IntegerBucketSorter sorter;

   /**
    * Fixture initialization (common initialization for all tests).
    **/
   @Before
   public void setUp() {
      sorter = new IntegerBucketSorter();
   }

   @Test
   public void getPlaceValueTest1() {
      int place = 1;
      int num = 49;
      int correct = 9;
      int res = sorter.getPlaceValue(place, num);
      assertEquals("Test the getPlaceValue method on place = 1, num = 49.", correct, res);
   }

   @Test
   public void getPlaceValueTest2() {
      int place = 2;
      int num = 49;
      int correct = 4;
      int res = sorter.getPlaceValue(place, num);
      assertEquals("Test the getPlaceValue method on place = 2, num = 49.", correct, res);
   }

   @Test
   public void getPlaceValueTest3() {
      int place = 3;
      int num = 49;
      int correct = 0;
      int res = sorter.getPlaceValue(place, num);
      assertEquals("Test the getPlaceValue method on place = 3, num = 49.", correct, res);
   }

   @Test
   public void findIntLengthTest1() {
      boolean exThrown = false;
      int correct = 5;
      int res = 0;
      try {
         res = sorter.findIntLength(10000);
      } catch (Exception ex) {
         exThrown = true;
      }
      assertEquals("Test the findIntLength method threw an Exception on valid input.", false, exThrown);
      assertEquals("Test the findIntLength method on an int == MAX_DIGIT_LIMIT.", correct, res);
   }

   @Test
   public void findIntLengthTest2() {
      boolean exThrown = false;
      try {
         sorter.findIntLength(100000);
      } catch (Exception ex) {
         exThrown = true;
      }
      assertEquals("Test the findIntLength method on an int > MAX_DIGIT_LIMIT.", true, exThrown);
   }

   @Test
   public void findIntLengthTest() throws Exception {
      int testNum = 0, corrLen = 0;
      boolean correct = true;
      for (int i = 0; i < 5; i++) {
         testNum = (int) Math.pow(10, i);
         corrLen = sorter.findIntLength(testNum);
         if (corrLen != i + 1) {
            correct = false;
            break;
         }
      }
      assertEquals("Test the findIntLength method.", true, correct);
   }

   @Test
   public void findMaxIntLengthTest1() {
      int[] testArr = {};
      int ans = -1;
      try {
         ans = sorter.findMaxIntLength(testArr);
      } catch (Exception e) {
      }
      assertEquals("Test the findMaxIntLength method on an empty array.", 0, ans);
   }

   @Test
   public void findMaxIntLengthTest2() {
      int[] testArr = { 15, 20, 500, 90, 3, 37000 };
      int ans = -1;
      try {
         ans = sorter.findMaxIntLength(testArr);
      } catch (Exception e) {
      }
      assertEquals("Test the findMaxIntLength method on an array.", 5, ans);
   }

   @Test
   public void findMaxIntLengthTest3() {
      int[] testArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
      int ans = -1;
      try {
         ans = sorter.findMaxIntLength(testArr);
      } catch (Exception e) {
      }
      assertEquals("Test the findMaxIntLength method on an array.", 1, ans);
   }

   @Test
   public void findMaxIntLengthTest4() {
      int[] testArr = { 1000000 };
      boolean exThrown = false;
      try {
         sorter.findMaxIntLength(testArr);
      } catch (Exception ex) {
         exThrown = true;
      }
      assertEquals("Test the findMaxWordLength method on an int > MAX_DIGIT_LIMIT.", true, exThrown);
   }

   @Test
   public void resetBucketValuesTest1() {
      boolean notNeg1 = false;
      try {
         Field f = sorter.getClass().getDeclaredField("buckets"); // NoSuchFieldException}
         f.setAccessible(true);
         int[] data = {100, 10, 23};
         sorter.sort(data);
         sorter.resetBucketValues();

         int[][] buckets = (int[][]) f.get(sorter);

         for (int i = 0; i < 10; i++) {
            for (int j = 0; j < buckets[i].length; j++) {
               if (buckets[i][j] != -1) {
                  notNeg1 = true;
                  break;
               }
            }
         }
      } catch (Exception e) {
         assertEquals("No buckets field found in class", true, false);
         return;
      }

      assertEquals("Test the resetBucketValues", notNeg1, false);
   }
}