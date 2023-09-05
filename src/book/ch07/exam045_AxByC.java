package src.book.ch07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class exam045_AxByC {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    long gcdAB = gcdFunc(a,b);
    if (c % gcdAB != 0) {
      System.out.println(-1);
    } else {
      int mulNumber = (int)(c/gcdAB);
      long[] ret = Execute(a,b);
      System.out.println(ret[0] * mulNumber + " " + ret[1] * mulNumber);
    }
  }
  private static long[] Execute(long value1, long value2) {
    long[] ret = new long[2];
    if (value2 == 0) {
      ret[0] = 1; ret[1] = 0;
      return ret;
    }
    long quot = value1 / value2;
    long[] temp = Execute(value2, value1 % value2);   // 재귀 형태로 유클리드 호제법 수행하기
    ret[0] = temp[1];
    ret[1] = temp[0] - temp[1] * quot;
    return ret;
  }
  private static long gcdFunc(long value1, long value2) {
    if (value2 == 0) {
      return value1;
    }
    return gcdFunc(value2, value1 % value2);
  }
  // 다른 방식으로 gcdFunc 구현
  /*
  private static long gcdFunc(long value1, long value2) {
    while (value2 != 0) {
      long temp = value1 % value2;
      value1 = value2;
      value2 = temp;
    }
    return Math.abs(value1);
  }
   */
}
