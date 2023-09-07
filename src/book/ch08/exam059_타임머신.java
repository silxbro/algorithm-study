package src.book.ch08;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam059_타임머신 {
  static long[] minTimeToCity;
  static tEdge[] busInfo;
  static int cityNumber, busNumber;
  static boolean isMinusCycle;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    cityNumber = Integer.parseInt(st.nextToken());
    busNumber = Integer.parseInt(st.nextToken());
    minTimeToCity = new long[cityNumber + 1];
    busInfo = new tEdge[busNumber];
    for (int i = 0; i < busNumber; i++) {            // 에지 리스트에 데이터 저장
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int time = Integer.parseInt(st.nextToken());
      busInfo[i] = new tEdge(start, end, time);
    }
    Arrays.fill(minTimeToCity, Integer.MAX_VALUE);   // 최단 거리 배열 초기화

    // 벨만-포드 알고리즘 수행하기
    minTimeToCity[1] = 0;
    for (int i = 1; i < cityNumber; i++) {  // N보다 1개 적은 수만큼 반복
      for (int j = 0; j < busInfo.length; j++) {
        tEdge now = busInfo[j];
        if (minTimeToCity[now.start] != Integer.MAX_VALUE
            && minTimeToCity[now.end] > minTimeToCity[now.start] + now.time) {
          minTimeToCity[now.end] = minTimeToCity[now.start] + now.time;
        }
      }
    }

    // 음수 사이클 존재 여부 확인
    isMinusCycle = false;
    for (int i = 0; i < busInfo.length; i++) {
      tEdge now = busInfo[i];
      if (minTimeToCity[now.start] != Integer.MAX_VALUE
          && minTimeToCity[now.end] > minTimeToCity[now.start] + now.time) {
        isMinusCycle = true;
        break;
      }
    }

    if (!isMinusCycle) {    // 음의 사이클이 없을 때
      for (int i = 2; i <= cityNumber; i++) {
        if (minTimeToCity[i] != Integer.MAX_VALUE) {
          bw.write(minTimeToCity[i] + "\n");
        } else {
          bw.write(-1 + "\n");
        }
      }
    } else {                // 음의 사이클이 있을 때
      bw.write(-1 + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
class tEdge {   // 에지 리스트를 편하게 다루기 위해 클래스 별도 구현하기
  // 시작점, 도착점, 이동 시간
  int start;
  int end;
  int time;
  tEdge (int start, int end, int time) {
    this.start = start;
    this.end = end;
    this.time = time;
  }
}
