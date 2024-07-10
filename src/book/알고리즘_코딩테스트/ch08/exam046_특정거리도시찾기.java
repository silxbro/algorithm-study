package src.book.알고리즘_코딩테스트.ch08;

import java.util.*;

public class exam046_특정거리도시찾기 {
  static int citySize, edgeSize, findDistance, startCity;
  static ArrayList<ArrayList<Integer>> linkInfo = new ArrayList<>();
  static int[] distance;
  static List<Integer> answerCity = new ArrayList<>();
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 초기화
    citySize = sc.nextInt();     // 도시 수
    edgeSize = sc.nextInt();     // 도로 수
    findDistance = sc.nextInt(); // 목표 거리
    startCity = sc.nextInt();    // 시작점
    for (int i = 0; i <= citySize; i++) {  // 도시 연결 정보 초기화
      linkInfo.add(new ArrayList<>());
    }
    distance = new int[citySize + 1];     // 거리 배열 초기화
    Arrays.fill(distance, -1);           // *** -1로 초기화함으로써 시작 도시와 미방문 도시 구분
    for (int i = 0; i < edgeSize; i++) {
      int start = sc.nextInt();
      int end = sc.nextInt();
      linkInfo.get(start).add(end);
    }
    BFS(startCity);
    for (int i = 1; i <= citySize; i++) {
      if (distance[i] == findDistance) {
        answerCity.add(i);
      }
    }
    if (!answerCity.isEmpty()) {
      Collections.sort(answerCity);
      for (int city : answerCity) {
        System.out.println(city);
      }
    } else {
      System.out.println(-1);
    }
  }
  // BFS 구현하기
  private static void BFS(int city) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(city);
    distance[city]++;
    while (!queue.isEmpty()) {
      int nowCity = queue.poll();
      for (int nextCity : linkInfo.get(nowCity)) {
        if (distance[nextCity] == -1) {
          distance[nextCity] = distance[nowCity] + 1;
          queue.add(nextCity);
        }
      }
    }
  }
}
