package src.book.알고리즘_코딩테스트.ch08;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class exam047_효율적인해킹 {
  static int computerSize;
  static int faithSize;
  static ArrayList<Integer>[] computerList;
  static boolean[] visited;
  static int[] faith;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    computerSize = Integer.parseInt(st.nextToken());
    faithSize = Integer.parseInt(st.nextToken());
    faith = new int[computerSize + 1];
    computerList = new ArrayList[computerSize + 1];
    for (int i = 1; i <= computerSize; i++) {
      computerList[i] = new ArrayList<>();
    }
    for (int i = 0; i < faithSize; i++) {
      st = new StringTokenizer(br.readLine());
      int giveFaith = Integer.parseInt(st.nextToken());
      int takeFaith = Integer.parseInt(st.nextToken());
      computerList[giveFaith].add(takeFaith);
    }
    for (int i = 1; i <= computerSize; i++) {    // 모든 노드로 BFS 실행하기
      visited = new boolean[computerSize + 1];
      BFS(i);
    }
    int maxFaithCount = Integer.MIN_VALUE;
    for (int i = 1; i <= computerSize; i++) {
      if (faith[i] > maxFaithCount) {
        maxFaithCount = faith[i];
      }
    }
    for (int i = 1; i <= computerSize; i++) {
      if (faith[i] == maxFaithCount) {
        bw.write(i + " ");
      }
    }
    bw.flush();
    bw.close();
    br.close();
  }
  private static void BFS(int comNumber) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(comNumber);
    visited[comNumber] = true;
    while (!queue.isEmpty()) {
      int nowCom = queue.poll();
      for (int nextCom : computerList[nowCom]) {
        if (!visited[nextCom]) {
          visited[nextCom] = true;
          queue.add(nextCom);
          faith[nextCom]++;  // 신규 노드 인덱스의 신뢰도 배열 증가시킴
        }
      }
    }
  }
}
