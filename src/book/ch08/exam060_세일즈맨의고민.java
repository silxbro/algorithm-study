package src.book.ch08;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam060_세일즈맨의고민 {
  static int cityNumber;
  static int transNumber;
  static int startCity, arriveCity;
  static long[] finalMoney, cityMoney;
  static TransCost[] transInfo;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    cityNumber = Integer.parseInt(st.nextToken());
    startCity = Integer.parseInt(st.nextToken());
    arriveCity = Integer.parseInt(st.nextToken());
    transNumber = Integer.parseInt(st.nextToken());
    transInfo = new TransCost[transNumber];
    for (int i = 0; i < transNumber; i++) {   // 에지 리스트에 데이터 저장하기
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int arrive = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      transInfo[i] = new TransCost(start, arrive, cost);
    }
    finalMoney = new long[cityNumber];
    Arrays.fill(finalMoney, Long.MIN_VALUE);  // 최단 거리 배열 초기화하기
    cityMoney = new long[cityNumber];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < cityNumber; i++) {
      cityMoney[i] = Integer.parseInt(st.nextToken());
    }

    // 변형된 벨만-포드 알고리즘 수행
    finalMoney[startCity] = cityMoney[startCity];
    for (int i = 0; i < cityNumber + 100; i++) {  // 양수 사이클이 전파되도록 충분히 큰 수로 반복하기
      for (int j = 0; j < transNumber; j++) {
        TransCost now = transInfo[j];
        // 출발 노드가 방문하지 않은 노드이면 skip
        if (finalMoney[now.start] == Long.MIN_VALUE) continue;
        // 출발 노드가 양수 사이클에 연결된 노드라면 종료 노드도 연결 노드로 업데이트
        else if (finalMoney[now.start] == Long.MAX_VALUE) {
          finalMoney[now.arrive] = Long.MAX_VALUE;
        }
        // 더 많은 돈을 벌 수 있는 새로운 경로가 발견됐을 때 새로운 경로값으로 업데이트
        else if (finalMoney[now.arrive] < finalMoney[now.start] - now.cost + cityMoney[now.arrive]) {
          finalMoney[now.arrive] = finalMoney[now.start] - now.cost + cityMoney[now.arrive];
          if (i >= cityNumber - 1) {  // N-1 반복 이후 업데이트되는 종료 노드는 양수 사이클 연결 노드로 변경
            finalMoney[now.arrive] = Long.MAX_VALUE;
          }
        }
      }
    }

    // 결괏값 출력
    if (finalMoney[arriveCity] == Long.MIN_VALUE) {           // 도착 불가능
      bw.write("gg\n");
    } else if (finalMoney[arriveCity] == Long.MAX_VALUE) {    // 양수 사이클이 연결돼 무한대 돈을 벌 수 있을 때
      bw.write("Gee\n");
    } else {                                                  // 이외의 경우
      bw.write(finalMoney[arriveCity] + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
class TransCost {  // 에지 리스트를 편하게 다루기 위해 클래스로 별도 구현하기
  int start;
  int arrive;
  int cost;
  TransCost(int start, int arrive, int cost) {
    this.start = start;
    this.arrive = arrive;
    this.cost = cost;
  }
}
