package src.book.알고리즘_코딩테스트.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class exam016_버블소트1 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    mData[] arr = new mData[N];
    for (int i = 0; i < N; i++) {
      arr[i] = new mData(i, Integer.parseInt(br.readLine()));
    }
    Arrays.sort(arr);
    int maxSwap = 0;
    for (int i = 0; i < N; i++) {
      if (arr[i].index - i > maxSwap) {   // 정렬 전 index - 정렬 후 index 계산의 최댓값 저장하기
        maxSwap = arr[i].index - i;
      }
    }
    System.out.println(maxSwap + 1);
  }
}

class mData implements Comparable<mData> {
  int index;
  int value;
  public mData(int index, int value) {
    this.index = index;
    this.value = value;
  }
  @Override
  public int compareTo(mData o) {    // value 기준 오름차순 정렬하기
    return this.value - o.value;
  }
}
