package src.book.알고리즘_코딩테스트.ch08;

import java.io.*;
import java.util.StringTokenizer;

public class exam063_케빈베이컨의6단계법칙 {
  static int peopleNumber;
  static int relationshipNumber;
  static int[][] kevinBaconCount;
  static final int INF = 999999999;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    peopleNumber = Integer.parseInt(st.nextToken());
    relationshipNumber = Integer.parseInt(st.nextToken());
    kevinBaconCount = new int[peopleNumber + 1][peopleNumber + 1];
    for (int i = 1; i <= peopleNumber; i++) {       // 인접 행렬 초기화하기
      for (int j = 1; j <= peopleNumber; j++) {
        if (i == j) {
          kevinBaconCount[i][j] = 0;
        } else {
          kevinBaconCount[i][j] = INF;  // 충분히 큰 수로 저장하기
        }
      }
    }
    for (int i = 0; i < relationshipNumber; i++) {  // 친구 관계이므로 양방향 저장을 하며 1로 가중치 통일
      st = new StringTokenizer(br.readLine());
      int peopleA = Integer.parseInt(st.nextToken());
      int peopleB = Integer.parseInt(st.nextToken());
      kevinBaconCount[peopleA][peopleB] = 1;
      kevinBaconCount[peopleB][peopleA] = 1;
    }
    for (int k = 1; k <= peopleNumber; k++) {       // 플로이드-워셜 알고리즘 수행하기
      for (int i = 1; i <= peopleNumber; i++) {
        for (int j = 1; j <= peopleNumber; j++) {
          kevinBaconCount[i][j] = Math.min(kevinBaconCount[i][j], kevinBaconCount[i][k] + kevinBaconCount[k][j]);
        }
      }
    }
    int answerPeople = 0;
    int minKBCount = INF;
    for (int i = 1; i <= peopleNumber; i++) {
      int thisKBCount = 0;
      for (int j = 1; j <= peopleNumber; j++) {
        thisKBCount += kevinBaconCount[i][j];
      }
      if (minKBCount > thisKBCount) {  // 가장 작은 케빈 베이컨의 수를 지니고 있는 i 찾기
        minKBCount = thisKBCount;
        answerPeople = i;
      }
    }
    bw.write(answerPeople + "\n");
    bw.flush();
    bw.close();
    br.close();
  }
}
