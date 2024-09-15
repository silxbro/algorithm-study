package src.problem.baekjoon.level20_심화_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class N25192_인사성_밝은_곰곰이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        Set<String> hello = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String nickname = br.readLine();
            if (nickname.equals("ENTER")) {
                hello.clear();
                continue;
            }
            if (hello.add(nickname)) {
                count++;
            }
        }
        System.out.println(count);
    }
}