package src.book.ch08;

import java.util.ArrayList;
import java.util.Scanner;

public class exam052_거짓말 {
  static int[] parent;
  static ArrayList<ArrayList<Integer>> party;
  static int[] truePerson;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int possibleParty = 0;
    int personNumber = sc.nextInt();
    int partyNumber = sc.nextInt();
    int truePersonNumber = sc.nextInt();
    party = new ArrayList<>();
    parent = new int[personNumber + 1];
    truePerson = new int[truePersonNumber];
    for (int i = 0 ; i < truePersonNumber; i++) {    // 진실을 아는 사람 저장하기
      truePerson[i] = sc.nextInt();
    }
    for (int i = 0; i < partyNumber; i++) {          // 파티 데이터 저장하기
      party.add(new ArrayList<>());
      int partySize = sc.nextInt();
      for (int j = 0; j < partySize; j++) {
        party.get(i).add(sc.nextInt());
      }
    }
    for (int i = 1; i <= personNumber; i++) {        // 대표 노드를 자기 자신으로 초기화하기
      parent[i] = i;
    }

    for (int i = 0; i < partyNumber; i++) {          // 각 파티에 참여한 사람들을 1개의 그룹으로 만들기
      int firstPeople = party.get(i).get(0);
      int size = party.get(i).size();
      for (int j = 1; j < size; j++) {
        union(firstPeople, party.get(i).get(j));
      }
    }
    // 각 파티의 대표 노드와 진실을 아는 사람들의 대표 노드가 같다면 과장할 수 없음
    for (int i = 0; i < partyNumber; i++) {
      boolean possible = true;
      int group = find(party.get(i).get(0));
      for (int j = 0; j < truePersonNumber; j++) {
        if (group == find(truePerson[j])) {
          possible = false;
          break;
        }
      }
      if (possible) possibleParty++;    // 모두 다를 경우 결괏값 1 증가
    }
    System.out.println(possibleParty);
  }

  private static void union(int personA, int personB) {  // union 연산
    personA = find(personA);
    personB = find(personB);
    if (personA != personB) {
      parent[personB] = personA;
    }
  }

  private static int find(int person) {                  // find 연산
    if (person == parent[person]) {
      return person;
    }
    return parent[person] = find(parent[person]);        // 재귀 함수의 형태로 구현하기
  }
}
