public class LoopOrderPerf {
  //the first loop order i,j,k 5ms
  private static void LoopOrderTest() {
    int n = 100;
    int[][] A = new int[n][n];
    int[][] B = new int[n][n];
    int[][] C = new int[n][n];
    long start = System.currentTimeMillis();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          C[i][j] += A[i][j] * B[k][j];
        }
      }
    }
    long end = System.currentTimeMillis();
    System.out.println("i,j,k takes " + (end - start)+"ms");
  }

  //the first loop order i,k,j 0
  private static void LoopOrderTest1() {
    int n = 100;
    int[][] A = new int[n][n];
    int[][] B = new int[n][n];
    int[][] C = new int[n][n];
    long start = System.currentTimeMillis();
    for (int i = 0; i < n; i++) {
      for (int k = 0; k < n; k++) {
        for (int j = n; j < n; j++){
          C[i][j] += A[i][j] * B[k][j];
        }
      }
    }
    long end = System.currentTimeMillis();
    System.out.println("i,k,j takes " + (end - start)+"ms");
  }

  //the first loop order k,i,j 8ms
  private static void LoopOrderTest2() {
    int n = 100;
    int[][] A = new int[n][n];
    int[][] B = new int[n][n];
    int[][] C = new int[n][n];
    long start = System.currentTimeMillis();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          C[i][j] += A[i][j] * B[k][j];
        }
      }
    }
    long end = System.currentTimeMillis();
    System.out.println("k,i,j takes " + (end - start)+"ms");
  }




  public static void main(String[] args) {
    LoopOrderTest2();

  }

}
