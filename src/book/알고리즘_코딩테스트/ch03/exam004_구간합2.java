package src.book.알고리즘_코딩테스트.ch03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam004_구간합2 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] A = new int[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int[][] D = new int[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        // 구간 합 구하기
        D[i][j] = D[i-1][j] + D[i][j-1] - D[i-1][j-1] + A[i][j];
      }
    }
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      // 구간 합 배열로 질의에 답변하기
      int result = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1];
      System.out.println(result);
    }
  }
}
