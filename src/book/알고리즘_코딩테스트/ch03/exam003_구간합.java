package src.book.알고리즘_코딩테스트.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam003_구간합 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int suNo = Integer.parseInt(st.nextToken());
    int quizNo = Integer.parseInt(st.nextToken());
    long[] S = new long[suNo + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= suNo; i++) {
      S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
    }
    for (int q = 0; q < quizNo; q++) {
      st = new StringTokenizer(br.readLine());
      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());
      System.out.println(S[j] - S[i - 1]);
    }
  }
}