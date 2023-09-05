package src.book.ch07;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class exam044_칵테일 {
  static ArrayList<ArrayList<rNode>> ratioGraph = new ArrayList<>();
  static boolean[] visited;
  static long[] materialAmount;
  static long lcm, gcd;
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int materialCount = sc.nextInt();
    materialAmount = new long[materialCount];
    visited = new boolean[materialCount];
    for (int i = 0; i < materialCount; i++) {
      ratioGraph.add(new ArrayList<>());
    }
    lcm = 1;
    for (int i = 0; i < materialCount - 1; i++) {
      int material1 = sc.nextInt();
      int material2 = sc.nextInt();
      int ratio1 = sc.nextInt();
      int ratio2 = sc.nextInt();
      ratioGraph.get(material1).add(new rNode(material2, ratio1, ratio2));  // *** 양방향 그래프 (틀린 부분)
      ratioGraph.get(material2).add(new rNode(material1, ratio2, ratio1));
      lcm *= (ratio1 * ratio2) / gcdFunc(ratio1, ratio2);
    }

    materialAmount[0] = lcm;
    gcd = materialAmount[0];
    DFS(0);
    for (int i = 0; i < materialCount; i++) {
      bw.write(materialAmount[i] / gcd + " ");
    }
    bw.flush();
    bw.close();

  }
  public static void DFS(int nowNode) {                  // DFS 구현하기
    visited[nowNode] = true;
    for (rNode nextNode : ratioGraph.get(nowNode)) {
      if (!visited[nextNode.index]) {
        materialAmount[nextNode.index] = materialAmount[nowNode] * nextNode.ratioB / nextNode.ratioA;
        gcd = gcdFunc(gcd, materialAmount[nextNode.index]);
        DFS(nextNode.index);
      }
    }
  }
  public static long gcdFunc(long value1, long value2) {  // 최대 공약수 함수 구현하기
    if (value2 == 0) {
      return value1;
    }
    return gcdFunc(value2, value1 % value2);  // 주어진 비율로 다음 노드값 갱신하기
  }
}
class rNode {
  int index;
  int ratioA;
  int ratioB;
  rNode(int index, int ratioA, int ratioB) {
    this.index = index;
    this.ratioA = ratioA;
    this.ratioB = ratioB;
  }
}
