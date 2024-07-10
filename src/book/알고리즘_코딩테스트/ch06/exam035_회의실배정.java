package src.book.알고리즘_코딩테스트.ch06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class exam035_회의실배정 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int meetingCount = sc.nextInt();
    int[][] meetingArr = new int[meetingCount][2];
    for (int i = 0; i < meetingCount; i++) {
      meetingArr[i][0] = sc.nextInt();    // 시작 시간
      meetingArr[i][1] = sc.nextInt();    // 종료 시간
    }
    Arrays.sort(meetingArr, new Comparator<int[]>() {
      @Override
      public int compare(int[] arr1, int[] arr2) {
        if (arr1[1] == arr2[1]) {  // 종료 시간이 같을 때
          return arr1[0] - arr2[0];
        }
        return arr1[1] - arr2[1];
      }
    });
    int possibleMeetingCount = 0;
    int endTime = -1;
    for (int i = 0; i < meetingCount; i++) {
      if (meetingArr[i][0] >= endTime) {   // 겹치지 않는 다음 회의가 나온 경우
        possibleMeetingCount++;
        endTime = meetingArr[i][1];        // 종료 시간 업데이트
      }
    }
    System.out.println(possibleMeetingCount);
  }
}
