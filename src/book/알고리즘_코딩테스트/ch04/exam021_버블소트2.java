package src.book.알고리즘_코딩테스트.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam021_버블소트2 {
  public static int[] arr, tmp;
  public static long result;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    arr = new int[n];
    tmp = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    mergeSort(0, n-1);
    System.out.println(result);
  }
  private static void mergeSort(int start, int end) {
    if (end - start < 1)
      return;
    int middle = (start + end) / 2;
    mergeSort(start, middle);
    mergeSort(middle + 1, end);
    for (int i = start; i <= end; i++) {
      tmp[i] = arr[i];
    }
    int index1 = start;
    int index2 = middle + 1;
    int indexTemp = start;
    while (index1 <= middle && index2 <= end) {
      if (tmp[index1] > tmp[index2]) {
        arr[indexTemp] = tmp[index2];
        result = result + index2 - indexTemp;
        index2++;
        indexTemp++;
      } else {
        arr[indexTemp] = tmp[index1];
        index1++;
        indexTemp++;
      }
    }
    while (index1 <= middle) {
      arr[indexTemp] = tmp[index1];
      index1++;
      indexTemp++;
    }
    while (index2 <= middle) {
      arr[indexTemp] = tmp[index2];
      index2++;
      indexTemp++;
    }
  }
}