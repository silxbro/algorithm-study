package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class N25757_임스와_함께하는_미니게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        char game = st.nextToken().charAt(0);
        int group = game == 'Y' ? 1 : game == 'F' ? 2 : 3;

        Set<String> players = new HashSet<>();
        for (int i = 0; i < N; i++) {
            players.add(br.readLine());
        }

        System.out.println(players.size() / group);
    }
}