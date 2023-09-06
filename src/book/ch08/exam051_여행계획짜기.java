package src.book.ch08;

import java.util.Scanner;

public class exam051_여행계획짜기 {
  static int[] parent;
  static int[] travelRoute;
  static int[][] linkInfo;
  static int cityNumber;
  static int travelNumber;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    cityNumber = sc.nextInt();
    travelNumber = sc.nextInt();
    linkInfo = new int[cityNumber + 1][cityNumber + 1];
    travelRoute = new int[travelNumber];
    parent = new int[cityNumber + 1];
    for (int i = 1; i <= cityNumber; i++) {
      parent[i] = i;
    }
    for (int i = 1; i <= cityNumber; i++) {     // 도시 연결 데이터 저장하기
      for (int j = 1; j <= cityNumber; j++) {
        linkInfo[i][j] = sc.nextInt();
      }
    }
    for (int i = 0; i < travelNumber; i++) {    // 여행 도시 정보 저장하기
      travelRoute[i] = sc.nextInt();
    }
    possible = true;

    for (int i = 1; i <= cityNumber; i++) {     // 인접 행렬에서 도시가 연결돼 있으면 union 실행하기
      for (int j = 1; j <= cityNumber; j++) {
        if (linkInfo[i][j] == 1) {
          union(i,j);
        }
      }
    }
    // 여행 계획 도시들이 1개의 대표 도시로 연결돼 있는지 확인하기
    int standard = find(travelRoute[0]);
    for (int i = 1; i < travelNumber; i++) {
      if (find(i) != standard) {
        System.out.println("NO");
        return;
      }
    }
    System.out.println("YES");
  }
  private static void union(int cityA, int cityB) {   // union 연산 : 대표 노드끼리 연결하기
    cityA = find(cityA);
    cityB = find(cityB);
    if (cityA != cityB) {
      parent[cityB] = cityA;
    }
  }
  private static int find(int city) {                 // find 연산
    if (city == parent[city]) {
      return city;
    }
    return parent[city] = find(parent[city]);         // 재귀 함수의 형태로 구현 → 경로 압축 부분
  }
}
