package src.book.ch06;

import java.util.Scanner;

public class exam036_잃어버린괄호 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int answerSum = 0;
    String modLine = sc.nextLine();
    String[] modLineMinusSplit = modLine.split("-");
    for (int split = 0; split < modLineMinusSplit.length; split++) {
      int partSum = sumFunc(modLineMinusSplit[split]);
      if (split == 0) {
        answerSum += partSum;    // 가장 앞에 있는 값만 더함
      } else {
        answerSum -= partSum;    // 나머지 뒷부분은 더한 값들을 뺌
      }
    }
    System.out.println(answerSum);
  }
  public static int sumFunc(String str) {    // 나뉜 그룹의 더하기 연산 수행 함수
    int returnSum = 0;
    String[] strSplitPlus = str.split("[+]");
    for (String partStr : strSplitPlus) {
      returnSum += Integer.parseInt(partStr);
    }
    return returnSum;
  }
}
