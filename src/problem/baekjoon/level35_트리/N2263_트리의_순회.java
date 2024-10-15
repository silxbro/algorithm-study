package src.problem.baekjoon.level35_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N2263_트리의_순회 {

    static StringBuilder stb = new StringBuilder();
    static int[] inOrder;
    static int[] postOrder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        inOrder = new int[n];
        postOrder = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        preOrder(0, n - 1, 0, n - 1);

        System.out.println(stb);
    }

    private static void preOrder(int inS, int inE, int postS, int postE) {
        int root = postOrder[postE];
        int rootIndex = 0;
        while (true) {
            if (inOrder[rootIndex] == root) {
                break;
            }
            rootIndex++;
        }
        stb.append(root).append(" ");

        if (rootIndex > inS) {
            preOrder(inS, rootIndex - 1, postS, postS + (rootIndex - 1 - inS));
        }
        if (rootIndex < inE) {
            preOrder(rootIndex + 1, inE, postS + (rootIndex - inS), postE - 1);
        }
    }
}