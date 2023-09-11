package src.book.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam071_구간합구하기3 {
  static long[] tree;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int nodeNumber = Integer.parseInt(st.nextToken());  // 수의 개수
    int chgCount = Integer.parseInt(st.nextToken());    // 변경이 일어나는 횟수
    int sumCount = Integer.parseInt(st.nextToken());    // 구간 합을 구하는 횟수

    int tempNumber = nodeNumber;
    int treeHeight = 0;
    while (tempNumber > 0) {
      treeHeight++;
      tempNumber /= 2;
    }
    int treeSize = (int)Math.pow(2, treeHeight + 1);
    int leftStartNodeIndex = treeSize / 2 - 1;
    tree = new long[treeSize + 1];
    // 데이터를 리프 노드에 입력받기
    for (int i = 1; i <= nodeNumber; i++) {
      tree[i + leftStartNodeIndex] = Long.parseLong(br.readLine());
    }
    setTree(treeSize - 1);   // tree 만들기(초기화)

    for (int i = 0; i < chgCount + sumCount; i++) {
      st = new StringTokenizer(br.readLine());
      int cmd = Integer.parseInt(st.nextToken());
      int num1 = Integer.parseInt(st.nextToken());
      long num2 = Long.parseLong(st.nextToken());
      if (cmd == 1) {       // 변경
        changeVal(num1 + leftStartNodeIndex, num2);
      }
      else if (cmd == 2) {  // 구간 합
        num1 = num1 + leftStartNodeIndex;
        num2 = num2 + leftStartNodeIndex;
        System.out.println(getSum(num1, (int)num2));
      }
      else return;
    }
    br.close();

  }
  private static void setTree(int index) {                   // 초기 트리를 구성하는 함수
    while (index > 1) {
      tree[index / 2] += tree[index];
      index--;
    }
  }

  private static void changeVal(int index, long value) {     // 값을 변경하는 함수
    long diff = value - tree[index];
    while (index > 0) {
      tree[index] += diff;
      index = index / 2;
    }
  }

  private static long getSum(int startIndex, int endIndex) { // 구간 합을 구하는 함수
    long sum = 0;
    while (startIndex <= endIndex) {
      if (startIndex % 2 == 1) {
        sum += tree[startIndex];
        startIndex++;
      }
      if (endIndex % 2 == 0) {
        sum += tree[endIndex];
        endIndex--;
      }
      startIndex /= 2;
      endIndex /= 2;
    }
    return sum;
  }
}
