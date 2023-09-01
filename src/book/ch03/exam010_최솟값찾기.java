package src.book.ch03;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class exam010_최솟값찾기 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    Deque<Node> mydeque = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      int now = Integer.parseInt(st.nextToken());
      // 새로운 값이 들어올 때마다 정렬 대신 현재 수보다 큰 값을 덱에서 제거해 시간 복잡도를 줄임
      while (!mydeque.isEmpty() && mydeque.getLast().value > now) {
        mydeque.removeLast();
      }
      mydeque.addLast(new Node(i, now));
      // 범위에서 벗어난 값은 덱에서 제거
      if (i - L >= mydeque.getFirst().index) {
        mydeque.removeFirst();
      }
      bw.write(mydeque.getFirst().value + " ");
    }
    bw.flush();
    bw.close();
    br.close();
  }

  static class Node {
    public int index;
    public int value;
    Node(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }
}
