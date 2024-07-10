package src.book.알고리즘_코딩테스트.ch03;

import java.io.IOException;
import java.util.Scanner;

public class exam005_나머지합 {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    long[] S = new long[N];
    long[] C = new long[N];
    long answer = 0;
    S[0] = sc.nextInt();
    for (int i = 1; i < N; i++) { // 수열 합 배열 만들기
      S[i] = S[i - 1] + sc.nextInt();
    }
    for (int i = 0; i < N; i++) {
      int remainder = (int) (S[i] % M);
      // 0~i까지의 구간 합 자체가 0일 때 정답에 더하기
      if (remainder == 0) answer++;
      // 나저미가 같은 인덱스의 개수 카운팅하기
      C[remainder]++;
    }
    for (int i = 0; i < M; i++) {
      if (C[i] > 1) {
        answer += C[i] * (C[i] - 1) / 2;
      }
    }
    System.out.println(answer);
  }
}
