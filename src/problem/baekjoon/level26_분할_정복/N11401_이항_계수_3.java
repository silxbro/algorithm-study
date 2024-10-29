package src.problem.baekjoon.level26_분할_정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N11401_이항_계수_3 {

    final static long DEL = 1000000007;
    static long[] factorial;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        factorial = new long[N + 1];
        factorial[0] = 1;

        // 모든 팩토리얼 값을 미리 계산하여 저장
        for (int i = 1; i <= N; i++) {
            factorial[i] = factorial[i - 1] * i % DEL;
        }

        // 페르마의 소정리를 사용하여 역원 계산
        long denominator = (factorial[K] * factorial[N - K]) % DEL;
        long answer = (factorial[N] * modInverse(denominator, DEL)) % DEL;

        System.out.println(answer);
    }

    // 모듈러 역원 계산 (페르마의 소정리)
    private static long modInverse(long a, long p) {
        return pow(a, p - 2, p);
    }

    // 분할 정복을 이용한 거듭제곱
    private static long pow(long base, long exp, long mod) {
        if (exp == 0) return 1;
        long half = pow(base, exp / 2, mod);
        if (exp % 2 == 0) {
            return (half * half) % mod;
        } else {
            return (half * half % mod) * base % mod;
        }
    }
}
