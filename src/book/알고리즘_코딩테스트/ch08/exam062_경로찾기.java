package src.book.알고리즘_코딩테스트.ch08;

import java.io.*;
import java.util.StringTokenizer;

public class exam062_경로찾기 {
  static int[][] graph;
  static int nodeNumber;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    nodeNumber = Integer.parseInt(br.readLine());
    graph = new int[nodeNumber][nodeNumber];
    for (int i = 0; i < nodeNumber; i++) {   // 입력되는 인접 행렬의 값을 그대로 저장하기
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < nodeNumber; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for (int k = 0; k < nodeNumber; k++) {   // 변형된 플로이드-워셜 알고리즘 수행하기
      for (int i = 0; i < nodeNumber; i++) {
        for (int j = 0; j < nodeNumber; j++) {
          if (graph[i][k] == 1 && graph[k][j] == 1) {
            graph[i][j] = 1;
          }
        }
      }
    }
    for (int i = 0; i < nodeNumber; i++) {
      for (int j = 0; j < nodeNumber; j++) {
        bw.write(graph[i][j] + " ");
      }
      bw.write("\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
