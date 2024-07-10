package src.book.알고리즘_코딩테스트.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam072_최솟값 {
  static int[] tree;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int nodeNumber = Integer.parseInt(st.nextToken());  // 수의 개수
    int getCount = Integer.parseInt(st.nextToken());    // 구간의 최솟값을 구하는 횟수

    int tempNumber = nodeNumber;
    int treeHeight = 0;
    while (tempNumber > 0) {
      treeHeight++;
      tempNumber /= 2;
    }
    int treeSize = (int)Math.pow(2, treeHeight + 1);
    int leftNodeStartIndex = treeSize / 2 - 1;
    // 트리 초기화하기
    tree = new int[treeSize + 1];
    Arrays.fill(tree, Integer.MAX_VALUE);
    // 데이터 입력받기
    for (int i = 1; i <= nodeNumber; i++) {
      tree[i + leftNodeStartIndex] = Integer.parseInt(br.readLine());
    }
    setTree(treeSize - 1);   // tree 만들기

    for (int i = 0; i < getCount; i++) {
      st = new StringTokenizer(br.readLine());
      int startIndex = Integer.parseInt(st.nextToken());
      int endIndex = Integer.parseInt(st.nextToken());
      startIndex = startIndex + leftNodeStartIndex;
      endIndex = endIndex + leftNodeStartIndex;
      System.out.println(getMin(startIndex, endIndex));
    }
    br.close();
  }

  private static void setTree(int index) {                     // 초기 트리 생성 함수 구현하기
    while (index > 1) {
      if (tree[index / 2] > tree[index]) {
        tree[index / 2] = tree[index];
      }
      index--;
    }
  }

  private static int getMin(int startIndex, int endIndex) {    // 범위의 최솟값을 구하는 함수
    int minValue = Integer.MAX_VALUE;
    while (startIndex <= endIndex) {
      if (startIndex % 2 == 1) {
        minValue = Math.min(minValue, tree[startIndex]);
        startIndex++;
      }
      if (endIndex % 2 == 0) {
        minValue = Math.min(minValue, tree[endIndex]);
        endIndex--;
      }
      startIndex /= 2;
      endIndex /= 2;
    }
    return minValue;
  }
}
