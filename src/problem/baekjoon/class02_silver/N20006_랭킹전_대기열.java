package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class N20006_랭킹전_대기열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] levelRange = new int[p + 1][2];
        PriorityQueue<Player>[] players = new PriorityQueue[p + 1];
        int lastRoom = -1;

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();
            boolean select = false;
            for (int j = 0; j <= lastRoom; j++) {
                if (players[j].size() < m && level >= levelRange[j][0] && level <= levelRange[j][1]) {
                    players[j].add(new Player(level, nickname));
                    select = true;
                    break;
                }
            }
            if (!select) {
                lastRoom++;
                players[lastRoom] = new PriorityQueue<>(Comparator.comparing(o -> o.nickname));
                players[lastRoom].add(new Player(level, nickname));
                levelRange[lastRoom][0] = Math.max(1, level - 10);
                levelRange[lastRoom][1] = Math.min(500, level + 10);
            }
        }

        StringBuilder stb = new StringBuilder();
        for (int i = 0; i <= lastRoom; i++) {
            stb.append(players[i].size() == m ? "Started!" : "Waiting!").append("\n");
            while (!players[i].isEmpty()) {
                Player player = players[i].poll();
                stb.append(String.format("%d %s", player.level, player.nickname)).append("\n");
            }
        }
        System.out.println(stb);
    }
}

class Player {
    int level;
    String nickname;
    Player(int level, String nickname) {
        this.level = level;
        this.nickname = nickname;
    }
}
