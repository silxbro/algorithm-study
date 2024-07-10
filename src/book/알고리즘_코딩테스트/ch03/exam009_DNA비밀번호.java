package src.book.알고리즘_코딩테스트.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam009_DNA비밀번호 {
  static int Result;             // 비밀번호 개수 (정답)
  static int checkSecret;        // 조건 충족 문자
  static int[] checkArr, myArr;  // 최소 개수 조건, 현재 개수

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int allLen = Integer.parseInt(st.nextToken());
    int secLen = Integer.parseInt(st.nextToken());
    char[] allStr = new char[allLen];
    checkArr = new int[4];
    myArr = new int[4];
    Result = 0;
    checkSecret = 0;
    allStr = br.readLine().toCharArray();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      checkArr[i] = Integer.parseInt(st.nextToken());
      if (checkArr[i] == 0) checkSecret++;
    }
    for (int i = 0; i < secLen; i++) {    // 초기 P 부분 문자열 처리 부분
      Add(allStr[i]);
    }
    if (checkSecret == 4) Result++;
    // 슬라이딩 윈도우 처리 부분
    for (int i = secLen; i < allLen; i++) {
      int j = i - secLen;
      Add(allStr[i]);
      Remove(allStr[j]);
      if (checkSecret == 4) Result++;  // 4자릿수가 관련된 크기가 모두 충족될 때 유효한 비밀번호
    }
    System.out.println(Result);
  }

  private static void Add(char c) {
    switch(c) {
      case 'A' :
        myArr[0]++;
        if (myArr[0] == checkArr[0]) checkSecret++;
        break;
      case 'C' :
        myArr[1]++;
        if (myArr[1] == checkArr[1]) checkSecret++;
        break;
      case 'G' :
        myArr[2]++;
        if (myArr[2] == checkArr[2]) checkSecret++;
        break;
      case 'T' :
        myArr[3]++;
        if (myArr[3] == checkArr[3]) checkSecret++;
        break;
    }
  }
  private static void Remove(char c) {
    switch(c) {
      case 'A' :
        if (myArr[0] == checkArr[0]) checkSecret--;
        myArr[0]--;
        break;
      case 'C' :
        if (myArr[1] == checkArr[1]) checkSecret--;
        myArr[1]--;
        break;
      case 'G' :
        if (myArr[2] == checkArr[2]) checkSecret--;
        myArr[2]--;
        break;
      case 'T' :
        if (myArr[2] == checkArr[2]) checkSecret--;
        myArr[2]--;
        break;
    }
  }
}
