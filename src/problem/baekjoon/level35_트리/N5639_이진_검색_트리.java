package src.problem.baekjoon.level35_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class N5639_이진_검색_트리 {

    static List<Integer> preOrdered;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        preOrdered = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            preOrdered.add(Integer.parseInt(line));
        }
        System.out.println(postOrder(0, preOrdered.size() - 1));
    }

    private static String postOrder(int start, int end) {
        if (start > end) {
            return "";
        }

        int root = preOrdered.get(start);
        int middle = start;
        while (middle <= end) {
            if (preOrdered.get(middle) > root) {
                break;
            }
            middle++;
        }

        StringBuilder stb = new StringBuilder();
        return stb.append(postOrder(start + 1, middle - 1)).append(postOrder(middle, end)).append(root).append("\n").toString();
    }
}