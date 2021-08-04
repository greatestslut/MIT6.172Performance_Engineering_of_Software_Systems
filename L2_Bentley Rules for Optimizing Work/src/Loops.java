import java.util.*;

public class Loops {
  //Summary:1.for-i loop is just a special function. From decoupling point view, just write the loop-relevant calculation inside the function.
  //        2.special parts.initialization,break check,advancement

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

  //5.eliminating wasted iteration(modify loop bounds) for-i has three parts initialization statement,exit-check predicate,advancement statement.
  //when we need to exit loop,don't need to explicitly write this.
  //10000000 6ms
  public static int normLoop5(int[] arr) {
    int count = 0;
    if (arr == null || arr.length == 0) {
      return count;
    }
    for (int a : arr) {
      if (a == 0) {
        break;
      }
      count += a;
    }
    return count;
  }

  //10000000 6ms
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

  /***
   * 老大在实际开发中写的，将exit-loop predicate内容写在for循环语句中
   */
  //  for (int i = 0; count[0] < DEL_THRESHOLD_NUM && start && i < deleteSubDirs.length; i++) {
  //    String curDelSubDir = FileUtils.GetCanonicalPath(deleteSubDirs[i]);
  //    String processingDir = FileUtils.GetCanonicalPath(FileUtils.PathCombine(AppInfo.GetAppDataDirectory(), "data", DELETED_FOLDER_NAME, RSBDateTime.now().toString("yyyyMMddHH")));
  //    if (Utilities.equalIgnoreCaseInvariant(curDelSubDir, processingDir)) continue;
  //
  //    FileUtils.walk(curDelSubDir, FileUtils.WALKORDER_POSTFIX, (path, isDirectory)->{
  //      if (!start) {
  //        return false;
  //      }
  //      try {
  //        /*#if (isDirectory) Directory.Delete(path); else File.Delete(path);#*/
  //        /*@*/if(new File(path).delete())/*@*/
  //        count[0]++;
  //      } catch (Throwable ex) {
  //        logger.log(LogType.DEBUG, Utilities.formatString(LOG_UNABLE_DELETE_ITEM, path));
  //      }
  //      return count[0] < DEL_THRESHOLD_NUM;
  //    });
  //  }
  public static void main(String[] args) {
    int[] ints = new int[3];
    for (int i = 0; i < 0; i++) {
      System.out.println(ints[i]);
    }
  }


}
