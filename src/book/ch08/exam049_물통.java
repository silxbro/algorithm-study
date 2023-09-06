package src.book.ch08;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class exam049_물통 {
  // 6가지 이동 케이스를 표현하기 위하 ㄴ배열
  static int[] Sender = {0, 0, 1, 1, 2 ,2};
  static int[] Receiver = {1, 2, 0, 2, 0, 1};
  static int[] size = new int[3];
  static boolean[] answerC = new boolean[201];
  static boolean[][] visited = new boolean[201][201];  // A,B의 무게만 있으면 C의 무게가 고정되므로 2개만 체크
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < size.length; i++) {
      size[i] = sc.nextInt();
    }
    BFS();
    for (int i = 0; i < answerC.length; i++) {
      if (answerC[i]) {
        System.out.print(i + " ");
      }
    }
  }
  private static void BFS() {
    Queue<AB> queue = new LinkedList<>();
    queue.add(new AB(0, 0));
    visited[0][0] = true;
    answerC[size[2]] = true;
    while (!queue.isEmpty()) {
      AB now = queue.poll();
      int nowA = now.amountA;
      int nowB = now.amountB;
      int nowC = size[2] - nowA - nowB;  // C는 전체 물의 양에서 A와 B를 뺀 것
      for (int event = 0; event < 6; event++) {   // A->B, A->C, B->A, B->C, C->A, C->B
        int[] next = {nowA, nowB, nowC};
        next[Receiver[event]] += next[Sender[event]];
        next[Sender[event]] = 0;
        if (next[Receiver[event]] > size[Receiver[event]]) {   // 물이 넘칠 때
          // 초과하는 만큼 다시 이전 물통에 넣어 줌
          next[Sender[event]] = next[Receiver[event]] - size[Receiver[event]];
          next[Receiver[event]] = size[Receiver[event]];  // 대상 물통은 최대로 채워 줌
        }
        if (!visited[next[0]][next[1]]) {                 // A와 B의 물의 양을 이용해 방문 배열 체크
          visited[next[0]][next[1]] = true;
          queue.add(new AB(next[0], next[1]));
          if (next[0] == 0) {  // A의 물의 양이 0일 때 C의 물의 무게를 정답 변수에 저장
            answerC[next[2]] = true;
          }
        }
      }
    }
  }
}
// AB 클래스 선언 -> A와 B의 값만 지니고 있으면 C는 유추할 수 있으므로 두 변수만 사용하기
class AB {
  int amountA;
  int amountB;
  public AB (int amountA, int amountB) {
    this.amountA = amountA;
    this.amountB = amountB;
  }
}
