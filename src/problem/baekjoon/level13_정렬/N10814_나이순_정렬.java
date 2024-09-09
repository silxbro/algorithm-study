package src.problem.baekjoon.level13_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class N10814_나이순_정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members.add(new Member(i, age, name));
        }
        Collections.sort(members);

        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            stb.append(member.age).append(" ").append(member.name).append("\n");
        }
        System.out.println(stb);
    }
}

class Member implements Comparable<Member> {
    int order;
    int age;
    String name;

    Member (int order, int age, String name) {
        this.order = order;
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Member o) {
        if (this.age == o.age) {
            return this.order - o.order;
        }
        return this.age - o.age;
    }
}