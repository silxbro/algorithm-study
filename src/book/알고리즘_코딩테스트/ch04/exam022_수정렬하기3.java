package src.book.알고리즘_코딩테스트.ch04;

import java.io.*;

public class exam022_수정렬하기3 {
  public static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    br.close();
    radixSort(arr, 5);
    for (int i = 0; i < n; i++) {
      bw.write(arr[i] + "\n");
    }
    bw.flush();
    bw.close();
  }
  private static void radixSort(int[] array, int maxSize) {
    int[] output = new int[arr.length];
    int jarisu = 1;
    int count = 0;
    while (count != maxSize) {
      int[] bucket = new int[10];   // *** 초기화위치 주의하기 ***
      for (int i = 0; i < arr.length; i++) {
        bucket[(arr[i] / jarisu) % 10]++;
      }
      for (int i = 1; i < 10; i++) {
        bucket[i] += bucket[i-1];
      }
      for (int i = arr.length - 1; i >= 0; i--) {
        output[bucket[(arr[i] / jarisu) % 10] - 1] = arr[i];
        bucket[(arr[i] / jarisu) % 10]--;
      }
      for (int i = 0; i < arr.length; i++) {
        arr[i] = output[i];
      }
      jarisu = jarisu * 10;
      count++;
    }
  }
}
/*
- 일반적인 기수 정렬은 우선순위 큐를 사용해 비교적 간단하게 구하는 방법이 있지만, 시간 복잡도를 느리게 하는 요소가 있으므로
  위 코드와 같이 구간 합을 이용하는 방법으로 구현
- bucket 배열의 정확한 의미 & bucket 배열로 현재 자리를 기준으로 정렬하는 방법을 디버깅을 통해 정확하게 이해하는 것이 중요
 */

