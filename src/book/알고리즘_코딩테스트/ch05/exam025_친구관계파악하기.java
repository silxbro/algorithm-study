package src.book.알고리즘_코딩테스트.ch05;

import java.util.ArrayList;
import java.util.Scanner;

public class exam025_친구관계파악하기 {
  static ArrayList<Integer>[] friendGraph;
  static boolean[] visited;
  static int relationDepth;
  static int personNum;
  static int relationNum;
  static boolean arrive;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    personNum = sc.nextInt();
    relationNum = sc.nextInt();
    friendGraph = new ArrayList[personNum];
    visited = new boolean[personNum];
    for (int i = 0; i < personNum; i++) {
      friendGraph[i] = new ArrayList<>();
    }
    for (int i = 0; i < relationNum; i++) {
      int personA = sc.nextInt();
      int personB = sc.nextInt();
      friendGraph[personA].add(personB);
      friendGraph[personB].add(personA);
    }
    for (int i = 0; i < personNum; i++) {
      DFS(i,1);    // depth 1부터 시작
      if (arrive) break;
    }
    if (arrive)
      System.out.println("1");
    else
      System.out.println("0");
  }
  static void DFS(int person, int depth) {
    if (depth == 5) {     // depth가 5가 되면 프로그램 종료
      arrive = true;
      return;
    }
    visited[person] = true;
    for (int nextPerson : friendGraph[person]) {
      if (!visited[nextPerson]) {
        DFS(nextPerson, depth + 1);    // 재귀 호출이 될 때마다 depth를 1씩 증가
      }
    }
    visited[person] = false;
  }
}
