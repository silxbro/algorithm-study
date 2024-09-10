package src.problem.baekjoon.level14_집합과_맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

class N7785_회사에_있는_사람 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Set<String> inCompany = new TreeSet<>((o1, o2) -> {
            return o2.compareTo(o1);
        });
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String command = st.nextToken();
            if (command.equals("enter")) {
                inCompany.add(name);
                continue;
            }
            if (command.equals("leave")) {
                inCompany.remove(name);
            }
        }

        StringBuilder stb = new StringBuilder();
        for (String name : new ArrayList<String>(inCompany)) {
            stb.append(name).append("\n");
        }

        System.out.println(stb);
    }
}