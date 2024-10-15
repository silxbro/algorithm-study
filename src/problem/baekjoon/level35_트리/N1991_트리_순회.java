package src.problem.baekjoon.level35_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N1991_트리_순회 {

    static char[][] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        nodes = new char[26][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int node = st.nextToken().charAt(0) - 'A';
            nodes[node][0] = st.nextToken().charAt(0);
            nodes[node][1] = st.nextToken().charAt(0);
        }

        StringBuilder stb = new StringBuilder();
        stb.append(preOrder(0)).append("\n")
            .append(inOrder(0)).append("\n")
            .append(postOrder(0));

        System.out.println(stb);
    }

    private static String preOrder(int node) {
        if (node == -1) {
            return "";
        }
        StringBuilder stb = new StringBuilder();
        int left = nodes[node][0] == '.' ? -1 : nodes[node][0] - 'A';
        int right = nodes[node][1] == '.' ? -1 : nodes[node][1] - 'A';
        return stb.append((char)(node + 'A')).append(preOrder(left)).append(preOrder(right)).toString();
    }

    private static String inOrder(int node) {
        if (node == -1) {
            return "";
        }
        StringBuilder stb = new StringBuilder();
        int left = nodes[node][0] == '.' ? -1 : nodes[node][0] - 'A';
        int right = nodes[node][1] == '.' ? -1 : nodes[node][1] - 'A';
        return stb.append(inOrder(left)).append((char)(node + 'A')).append(inOrder(right)).toString();
    }

    private static String postOrder(int node) {
        if (node == -1) {
            return "";
        }
        StringBuilder stb = new StringBuilder();
        int left = nodes[node][0] == '.' ? -1 : nodes[node][0] - 'A';
        int right = nodes[node][1] == '.' ? -1 : nodes[node][1] - 'A';
        return stb.append(postOrder(left)).append(postOrder(right)).append((char)(node + 'A')).toString();
    }
}