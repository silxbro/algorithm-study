package src.book.알고리즘_코딩테스트.ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam065_다리만들기 {
  static int row, col;
  static int[] dr = {1, 0, -1, 0};  // 가로 이동 방향
  static int[] dc = {0, 1, 0, -1};  // 세로 이동 방향
  static int[][] map;
  static boolean[][] visited;
  static int[] parent;
  static ArrayList<ArrayList<int[]>> sumList;
  static ArrayList<int[]> tempList;
  static int sumNum;
  static PriorityQueue<pEdge> pQueue;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    row = Integer.parseInt(st.nextToken());  // 가로 크기
    col = Integer.parseInt(st.nextToken());  // 세로 크기
    map = new int[row][col];
    visited = new boolean[row][col];


    for (int i = 0; i < row; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < col; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());  // 맵 정보 저장하기
      }
    }
    sumNum = 0;


    for (int i = 0; i < row; i++) {   // 각 자리에서 BFS 탐색으로 섬들을 분리하기
      for (int j = 0; j < col; j++) {
        if (!visited[i][j] && map[i][j] == 1) {
          sumNum++;
          tempList = new ArrayList<>();
          BFS(i,j);
          sumList.add(tempList);
        }
      }
    }
    pQueue = new PriorityQueue<>();
    makeEdgeList();   // 섬의 각 지점에서 만들 수 있는 모든 에지를 저장하기

    int minSpanningLength = 0;
    int useEdge = 0;
    parent = new int[sumNum + 1];
    for (int i = 1; i <= sumNum; i++) {
      parent[i] = i;
    }
    while (!pQueue.isEmpty()) {     // 최소 신장 트리 알고리즘 수행하기
      pEdge now = pQueue.poll();
      if (find(now.start) != find(now.end)) {  // 같은 부모가 아니라면 연결할 수 있음
        union(now.start, now.end);
        minSpanningLength += now.value;
        useEdge++;
      }
    }
    if (useEdge == sumNum - 1) {
      System.out.println(minSpanningLength);
    } else {
      System.out.println(-1);
    }

  }
  private static void BFS(int a, int b) {  // BFS를 이용해 연결된 섬을 찾아줌
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {a,b});
    tempList.add(new int[] {a,b});
    visited[a][b] = true;
    map[a][b] = sumNum;
    
    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      int nowR = now[0];
      int nowC = now[1];
      for (int d = 0; d < 4; d++) {  // 네 방향 검색하기
        int nextR = nowR + dr[d];
        int nextC = nowC + dc[d];
        if (nextR >= 0 && nextR < row && nextC >= 0 && nextC < col) {
          // 현재 방문한 적이 없고 바다가 아니면 같은 섬으로 취급하기
          if (!visited[nextR][nextC] && map[nextR][nextC] != 0) {
            visited[nextR][nextC] = true;
            map[nextR][nextC] = sumNum;
            tempList.add(new int[] {nextR, nextC});
            queue.add(new int[] {nextR, nextC});
          }
        }
      }
    }
  }
  private static void makeEdgeList() {
    for (int i = 0; i < sumList.size(); i++) {
      ArrayList<int[]> now = sumList.get(i);
      for (int j = 0; j < now.size(); j++) {
        int nowR = now.get(j)[0];
        int nowC = now.get(j)[1];
        for (int d = 0; d < 4; d++) {  // 네 방향 검색하기
          int length = 0;
          int dR = dr[d];
          int dC = dc[d];
          while (nowR + dR >= 0 && nowR + dR < row && nowC + dC >= 0 && nowC + dC < col) {
            // 1. 바다인 경우 ---> 다리 길이 1 늘리면서 탐색 진행
            if (map[nowR + dR][nowC + dC] == 0) {
              length++;
              if (dR > 0) dR++;
              else if (dR < 0) dR--;
              else if (dC > 0) dC++;
              else if (dC < 0) dC--;
            }
            // 2. 다른 섬이면서 다리 길이가 2 이상인 경우 ---> 에지를 저장하고, 탐색 종료
            else if (map[nowR][nowC] != map[nowR + dR][nowC + dC] && length > 1) {
              pQueue.add(new pEdge(map[nowR][nowC], map[nowR + dR][nowC + dC], length));
              break;
            }
            // 3. 같은 섬인 경우 or 다른 섬이지만 길이가 1 이하일 때 ---> 탐색 종료
            else break;
          }
        }
      }
    }
  }
  private static void union(int a, int b) {  // union 연산 : 대표 노드끼리 연결하기
    a = find(a);
    b = find(b);
    if (a != b) {
      parent[b] = a;
    }
  }
  private static int find(int a) {           // find 연산
    if (a == parent[a]) {
      return a;
    }
    return parent[a] = find(parent[a]);  // 재귀 함수 형태로 구현 -> 경로 압축 부분
  }
}
class pEdge implements Comparable<pEdge> {
  int start;
  int end;
  int value;
  pEdge (int start, int end, int value) {
    this.start = start;
    this.end = end;
    this.value = value;
  }
  public int compareTo(pEdge o) {
    return this.value - o.value;
  }
}
