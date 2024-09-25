package src.problem.baekjoon.level23_동적_계획법_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N9184_신나는_함수_실행 {

    public static void main(String[] args) throws IOException {
        int[][][] function = new int[101][101][101];

        for (int i = -50; i <= 50; i++) {
            for (int j = -50; j <= 50; j++) {
                for (int k = -50; k <= 50; k++) {
                    if (i <= 0 || j <= 0 || k <= 0) {
                        function[i + 50][j + 50][k + 50] = 1;
                    }
                }
            }
        }

        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                for (int k = 1; k <= 20; k++) {
                    function[i + 50][j + 50][k + 50] = function[i + 49][j + 50][k + 50] + function[i + 49][j + 49][k + 50] + function[i + 49][j + 50][k + 49] - function[i + 49][j + 49][k + 49];
                }
            }
        }

        for (int i = 1; i <= 20; i++) {
            for (int j = i + 1; j <= 20; j++) {
                for (int k = j + 1; k <= 20; k++) {
                    function[i + 50][j + 50][k + 50] = function[i + 50][j + 50][k + 49] + function[i + 50][j + 49][k + 49] - function[i + 50][j + 49][k + 50];
                }
            }
        }



        for (int i = 1; i <= 50; i++) {
            for (int j = 1; j <= 50; j++) {
                for (int k = 1; k <= 50; k++) {
                    if (i > 20 || j > 20 || k > 20) {
                        function[i + 50][j + 50][k + 50] = function[70][70][70];
                    }
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder stb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            stb.append(String.format("w(%d, %d, %d) = %d", a, b, c, function[a + 50][b + 50][c + 50])).append("\n");
        }

        System.out.println(stb);
    }
}