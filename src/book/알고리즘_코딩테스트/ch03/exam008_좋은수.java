package src.book.알고리즘_코딩테스트.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam008_좋은수 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int Result = 0;
    long[] A = new long[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(A);
    for (int k = 0; k < N; k++) {
      long find = A[k];
      int i = 0;
      int j = N - 1;
      while (i < j) {
        if (A[i] + A[j] == find) {
          if (i != k && j != k) {
            Result++;
            break;      // *** 주의
          } else if (i == k) {
            i++;
          } else if (j == k) {
            j--;
          }
        } else if (A[i] + A[j] > find) {
          j--;
        } else if (A[i] + A[j] < find) {
          i++;
        }
      }
    }
    System.out.println(Result);
    br.close();
  }
}
