package src.book.알고리즘_코딩테스트.ch07;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class exam043_최대공약수 {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    long firstNumber = sc.nextLong();
    long secondNumber = sc.nextLong();
    long gcd = gcdFunc(firstNumber, secondNumber);
    while (gcd > 0) {
      bw.write("1");
      gcd--;
    }
    bw.flush();
    bw.close();
  }
  public static long gcdFunc(long value1, long value2) {
    if (value2 == 0) {
      return value1;
    }
    return gcdFunc(value2, value1 % value2);
  }
}
