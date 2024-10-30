package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class N11723_집합 {
    static Set<Integer> set;
    static StringBuilder stb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        set = new HashSet<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("all")) {
                for (int n = 1; n <= 20; n++) {
                    set.add(n);
                }
                continue;
            }
            if (command.equals("empty")) {
                set.clear();
                continue;
            }

            int num = Integer.parseInt(st.nextToken());

            operate(command, num);
        }

        System.out.println(stb);
    }

    private static void operate(String command, int num) {
        if (command.equals("add")) {
            set.add(num);
        } else if (command.equals("remove")) {
            set.remove(num);
        } else if (command.equals("check")) {
            stb.append(set.contains(num) ? 1 : 0).append("\n");
        } else if (command.equals("toggle")) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
    }
}