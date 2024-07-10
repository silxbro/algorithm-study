package src.book.알고리즘_코딩테스트.ch08;

import java.io.*;
import java.util.StringTokenizer;

public class exam061_플로이드 {
  static int cityNumber;
  static int busNubmer;
  static int[][] distance;
  static final int INF = 999999999;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    cityNumber = Integer.parseInt(br.readLine());
    busNubmer  = Integer.parseInt(br.readLine());
    distance = new int[cityNumber + 1][cityNumber + 1];
    for (int i = 1; i <= cityNumber; i++) {     // 인접 행렬 초기화하기
      for (int j = 1; j <= cityNumber; j++) {
        if (i == j) {
          distance[i][j] = 0;
        } else {
          distance[i][j] = INF;  // 충분히 큰 수로 저장하기
        }
      }
    }
    for (int i = 0; i < busNubmer; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      if (distance[start][end] > cost) {
        distance[start][end] = cost;
      }
    }
    for (int k = 1; k <= cityNumber; k++) {    // 플로이드-워셜 알고리즘 수행하기
      for (int i = 1; i <= cityNumber; i++) {
        for (int j = 1; j <= cityNumber; j++) {
          distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
        }
      }
    }

    // 모든 경로의 최소 비용 출력
    for (int i = 1; i <= cityNumber; i++) {
      for (int j = 1; j <= cityNumber; j++) {
        if (distance[i][j] != INF) {
          bw.write(distance[i][j] + " ");
        } else {
          bw.write(0 + " ");
        }
      }
      bw.write("\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
