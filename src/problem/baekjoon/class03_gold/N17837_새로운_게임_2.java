package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class N17837_새로운_게임_2 {

    static int N, K;
    static int[][] color;
    static Deque<Piece>[][] chess;
    static PiecePosition[] piecePositions;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        color = new int[N][N];
        chess = new Deque[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
                chess[i][j] = new LinkedList<>();
            }
        }

        piecePositions = new PiecePosition[K + 1];
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            piecePositions[i] = new PiecePosition(r - 1, c - 1);
            chess[r - 1][c - 1].add(new Piece(i, d - 1));
        }

        int answer = -1;
        for (int i = 1; i <= 1000; i++) {
            boolean isFourStacked = false;
            for (int c = 1; c <= K; c++) {
                isFourStacked = moveChess(c);
                if (isFourStacked) {
                    break;
                }
            }
            if (isFourStacked) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);

    }

    private static boolean moveChess(int num) {
        PiecePosition position = piecePositions[num];
        Deque<Piece> square = chess[position.r][position.c];
        Deque<Piece> temp = new LinkedList<>();
        int dir;
        while (true) {
            Piece piece = square.removeFirst();
            temp.addLast(piece);
            if (piece.num == num) {
                dir = piece.dir;
                break;
            }
        }
        int nextR = position.r + dr[dir];
        int nextC = position.c + dc[dir];
        if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N || color[nextR][nextC] == 2) {
            dir = dir % 2 == 0 ? dir + 1 : dir - 1;
            temp.getLast().dir = dir;
            nextR = position.r + dr[dir];
            nextC = position.c + dc[dir];
            if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N || color[nextR][nextC] == 2) {
                while (!temp.isEmpty()) {
                    square.addFirst(temp.removeLast());
                }
                return false;
            }
        }
        if (color[nextR][nextC] == 0) {
            while (!temp.isEmpty()) {
                Piece piece = temp.removeLast();
                piecePositions[piece.num] = new PiecePosition(nextR, nextC);
                chess[nextR][nextC].addFirst(piece);
            }
        }
        else if (color[nextR][nextC] == 1) {
            while (!temp.isEmpty()) {
                Piece piece = temp.removeFirst();
                piecePositions[piece.num] = new PiecePosition(nextR, nextC);
                chess[nextR][nextC].addFirst(piece);
            }
        }
        return chess[nextR][nextC].size() >= 4;
    }

}

class Piece {
    int num;
    int dir;

    public Piece(int num, int dir) {
        this.num = num;
        this.dir = dir;
    }
}

class PiecePosition {
    int r;
    int c;

    public PiecePosition(int r, int c) {
        this.r = r;
        this.c = c;
    }
}