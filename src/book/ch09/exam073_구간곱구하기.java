package src.book.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam073_구간곱구하기 {
  static long[] tree;
  static int MOD = 1000000007;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int nodeNumber = Integer.parseInt(st.nextToken());   // 수의 개수
    int chgCount = Integer.parseInt(st.nextToken());     // 변경이 일어나는 횟수
    int mulCount = Integer.parseInt(st.nextToken());     // 구간 곱을 구하는 횟수

    int treeHeight = 0;
    int tempNumber = nodeNumber;
    while (tempNumber > 0) {
      treeHeight++;
      tempNumber /= 2;
    }
    int treeSize = (int)Math.pow(2, treeHeight + 1);
    int leftNodeStartIndex = treeSize / 2 - 1;
    tree = new long[treeSize + 1];
    Arrays.fill(tree, 1);    // 곱셈이므로 초깃값을 1로 설정
    for (int i = 1; i <= nodeNumber; i++) {
      tree[i + leftNodeStartIndex] = Long.parseLong(br.readLine());  // 데이터를 리프 노드에 입력받기
    }
    setTree(treeSize - 1);       // tree 만들기(초기화)

    for (int i = 0; i < chgCount + mulCount; i++) {
      st = new StringTokenizer(br.readLine());
      int cmd = Integer.parseInt(st.nextToken());
      int num1 = Integer.parseInt(st.nextToken());
      long num2 = Long.parseLong(st.nextToken());
      if (cmd == 1) {            // 변경하기
        changeVal(num1 + leftNodeStartIndex, num2);
      }
      else if (cmd == 2) {       // 구간 곱
        num1 = num1 + leftNodeStartIndex;
        num2 = num2 + leftNodeStartIndex;
        System.out.println(getMul(num1, (int)num2));
      }
      else return;
    }
    br.close();
  }
  // 모든 함수에서 곱셈이 발생할 때마다 MOD 연산 수행하기
  private static void setTree(int index) {
    while (index > 1) {
      tree[index / 2] = (tree[index / 2] * tree[index]) % MOD;
      index--;
    }
  }

  private static void changeVal(int index, long value) {
    tree[index] = value;
    while(index > 1) {   // 현재 노드의 양쪽 자식 노드를 찾아 곱하는 로직
      index = index / 2;
      tree[index] = tree[index * 2] * tree[index * 2 + 1] % MOD;
    }
  }

  private static long getMul(int startIndex, int endIndex) {
    long mulValue = 1;
    while (startIndex <= endIndex) {
      if (startIndex % 2 == 1) {
        mulValue = mulValue * tree[startIndex] % MOD;
        startIndex++;
      }
      if (endIndex % 2 == 0) {
        mulValue = mulValue * tree[endIndex] % MOD;
        endIndex--;
      }
      startIndex /= 2;
      endIndex /= 2;
    }
    return mulValue;
  }
}
