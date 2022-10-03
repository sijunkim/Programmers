import java.util.Scanner;

class Main {
  static int N, M;
  static int[] arr;
  static boolean[] isUsed;

  public static void main(String[] args) {
    new Main().solution();
  }

  void solution() {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();

    isUsed = new boolean[N + 1];
    arr = new int[M + 1];

    sc.close();
    System.out.println("---");

    backstracking(0);
  }

  void backstracking(int idx) {
    if (idx == M) {
      printResult();
      return;
    }

    for (int i = 1; i <= N; i++) {
      if (!isUsed[i]) {
        isUsed[i] = true;
        arr[idx] = i;
        backstracking(idx + 1); // arr의 인덱스를 +1 시켜준다.
        isUsed[i] = false;
      }
    }
  }

  void printResult() {
    for (int i = 0; i < M; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}
