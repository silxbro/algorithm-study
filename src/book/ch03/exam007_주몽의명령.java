package src.book.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam007_주몽의명령 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    int[] A = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(A);
    int count = 0;
    int start = 0;
    int end = N - 1;
    while (start < end) {     // 투 포인터 이동 원칙에 따라 포인터를 이동하며 처리
      if (A[start] + A[end] > M) {
        end--;
      } else if (A[start] + A[end] < M) {
        start++;
      } else {
        count++;
        start++;
        end--;
      }
    }
    System.out.println(count);
    br.close();
  }
}
