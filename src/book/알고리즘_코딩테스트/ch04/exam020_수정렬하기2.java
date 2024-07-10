package src.book.알고리즘_코딩테스트.ch04;

import java.io.*;

public class exam020_수정렬하기2 {
  public static int[] arr, tmp;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    arr = new int[n];
    tmp = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    mergeSort(0, n-1);
    for (int i = 0; i < n; i++) {
      bw.write(arr[i] + "\n");
    }
    bw.flush();
    bw.close();
  }
  private static void mergeSort(int start, int end) {
    if (end - start < 1)
      return;
    int middle = (start + end) / 2;
    // 재귀 함수 형태로 구현
    mergeSort(start, middle);
    mergeSort(middle + 1, end);
    for (int i = start; i <= end; i++) {
      tmp[i] = arr[i];
    }
    int index1 = start;
    int index2 = middle + 1;
    int indexTemp = start;
    while (index1 <= middle && index2 <= end) {  // 두 그룹을 병합하는 로직
      // 양쪽 그룹의 index가 가리키는 값을 비교해 더 작은 수를 선택해 배열에 저장하고,
      // 선택된 데이터의 index 값을 오른쪽으로 한 칸 이동하기
      if (tmp[index1] > tmp[index2]) {
        arr[indexTemp] = tmp[index2];
        index2++;
        indexTemp++;
      } else {
        arr[indexTemp] = tmp[index1];
        index1++;
        indexTemp++;
      }
    }
    // 한쪽 그룹이 모두 선택된 후 남아 있는 값 정리하기
    while (index1 <= middle) {
      arr[indexTemp] = tmp[index1];
      index1++;
      indexTemp++;
    }
    while (index2 <= end) {
      arr[indexTemp] = tmp[index2];
      index2++;
      indexTemp++;
    }
  }
}
