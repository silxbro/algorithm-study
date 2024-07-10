package src.book.알고리즘_코딩테스트.ch08;

import java.awt.image.BufferedImageFilter;
import java.io.*;
import java.sql.Array;
import java.util.*;

public class exam058_K번째최단경로찾기 {
  static int cityNumber, roadNumber;
  static int K;
  static PriorityQueue<Integer>[] kPathLength;
  static ArrayList<tNode>[] moveTimeInfo;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    cityNumber = Integer.parseInt(st.nextToken());
    roadNumber = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    kPathLength = new PriorityQueue[cityNumber + 1];
    moveTimeInfo = new ArrayList[cityNumber + 1];
    for (int i = 1; i <= cityNumber; i++) {
      kPathLength[i] = new PriorityQueue<>(K, Collections.reverseOrder());
      moveTimeInfo[i] = new ArrayList<>();
    }
    for (int i = 0; i < roadNumber; i++) {
      st = new StringTokenizer(br.readLine());
      int startCity = Integer.parseInt(st.nextToken());
      int endCity = Integer.parseInt(st.nextToken());
      int time = Integer.parseInt(st.nextToken());
      moveTimeInfo[startCity].add(new tNode(endCity, time));
    }
    
    executeDijkstra();    // 다익스트라 알고리즘 실행
    
    for (int i = 1; i < kPathLength.length; i++) {   // K번째 경로 출력하기
      if (kPathLength[i].size() == K) {
        bw.write(kPathLength[i].peek() + "\n");
      } else {
        bw.write(-1 + "\n");
      }
    }
    bw.flush();
    bw.close();
    br.close();
  }
  private static void executeDijkstra() {
    PriorityQueue<tNode> queue = new PriorityQueue<>();
    queue.add(new tNode(1, 0));
    kPathLength[1].add(0);
    while (!queue.isEmpty()) {
      tNode now = queue.poll();
      for (tNode next : moveTimeInfo[now.index]) {
        // 저장된 경로가 K개 미만일 경우 바로 추가하기
        if (kPathLength[next.index].size() < K) {
          queue.add(new tNode(next.index, now.value + next.value));
          kPathLength[next.index].add(now.value + next.value);
        }
        // 저장된 경로가 K개이고, 현재 가장 큰 값보다 작을 때만 추가하기
        else if (kPathLength[next.index].peek() > now.value + next.value) {
          queue.add(new tNode(next.index, now.value + next.value));
          kPathLength[next.index].poll();  // 기존 큐에서 Max값 먼저 삭제
          kPathLength[next.index].add(now.value + next.value);
        }
      }
    }
  }
}
//노드 클래스 작성하기
class tNode implements Comparable<tNode> {
  int index;
  int value;
  tNode(int index, int value) {
    this.index = index;
    this.value = value;
  }
  public int compareTo(tNode o) {
    return this.value - o.value;
  }
}
