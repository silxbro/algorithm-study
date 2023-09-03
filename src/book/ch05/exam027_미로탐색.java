package src.book.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class exam027_미로탐색 {
  static int[][] path;
  static boolean[][] visited;
  static int row, col;
  static int[] dr = {0, 1, 0, -1};
  static int[] dc = {1, 0, -1, 0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    row = Integer.parseInt(st.nextToken());
    col = Integer.parseInt(st.nextToken());
    path = new int[row][col];
    visited = new boolean[row][col];
    for (int r = 0; r < row; r++) {
      st = new StringTokenizer(br.readLine());
      String line = st.nextToken();
      for (int c = 0; c < col; c++) {
        path[r][c] = Integer.parseInt(line.substring(c, c+1));
      }
    }
    BFS(0,0);
    System.out.println(path[row-1][col-1]);
  }
  public static void BFS(int a, int b) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {a,b});
    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      for (int direct = 0; direct < 4; direct++) {
        int nextRow = now[0] + dr[direct];
        int nextCol = now[1] + dc[direct];
        if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col) {  // 좌표 유효성 검사
          if (!visited[nextRow][nextCol] && path[nextRow][nextCol] != 0) {     // 갈 수 있는 칸 && 방문 검사
            visited[nextRow][nextCol] = true;
            path[nextRow][nextCol] = path[now[0]][now[1]] + 1;      // 깊이 업데이트
            queue.add(new int[] {nextRow, nextCol});
          }
        }
      }
    }
  }
}
