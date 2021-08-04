import java.util.*;

public class Loops {
  //1.hoisting
  public static void normLoop(List<Double> list) {
    if (list == null || list.size() <= 0) {
      return;
    }
    for (int i = 0; i < list.size(); i++) {
      list.set(i, Math.sqrt(Math.PI) * i); //redundant calculation
    }
  }

  public static void hoistedLoop(List<Double> list) {
    if (list == null || list.size() <= 0) {
      return;
    }
    double sqrt = Math.sqrt(Math.PI);
    for (int i = 0; i < list.size(); i++) {
      list.set(i, sqrt * i); // only calculate loop-relevant variable
    }
  }

  //2.sentinels
  //3.loop unrolling
  //4.loop fusion
  public static void normLoop4(int[] A, int[] B, int[] C, int[] D, int n) {
    for (int i = 0; i < n; i++) {
      C[i] = (A[i] <= B[i]) ? A[i] : B[i];
    }
    for (int i = 0; i < n; i++) {
      D[i] = (A[i] <= B[i]) ? B[i] : A[i];
    }
  }

  public static void fusedLoop(int[] A, int[] B, int[] C, int[] D, int n) {
    for (int i = 0; i < n; i++) {
      C[i] = (A[i] <= B[i]) ? A[i] : B[i];
      D[i] = (A[i] <= B[i]) ? B[i] : A[i];
    }
  }

  //5.eliminating wasted iteration(modify loop bounds) for-i loop is more flexible because the for-i loop has inner filtering layer
  //generally,I love for-each,a syntax sugar.however,classic for-loop execute the filter statement,then operate the loop statement,eventually run the adding part
  //10000000 11ms
  public static int normLoop5(int[] arr) {
    int count = 0;
    if (arr == null || arr.length == 0) {
      return count;
    }
    for (int a : arr) {
      if (a == 0) {
        continue;
      }
      count += a;
    }
    return count;
  }

  //10000000 7ms
  public static int modBndLoop(int[] arr) {
    int count = 0;
    if (arr == null || arr.length == 0) {
      return count;
    }
    for (int i = 0; i < arr.length && arr[i] != 0; i++) {
      count += arr[i];
    }
    return count;
  }

  public static void main(String[] args) {
    int[] ints = new int[10000000];
    for (int i = 0; i < 10000000; i++) {
      ints[i] = 1;
    }
    long start = System.currentTimeMillis();
    normLoop5(ints);
    long end = System.currentTimeMillis();
    System.out.println("this procedure takes" + (end - start) + " ms");
  }


}
