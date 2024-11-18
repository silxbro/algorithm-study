package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

class N1202_보석_도둑 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewel> queue = new PriorityQueue<>(Comparator.comparing(o -> o.v, Comparator.reverseOrder()));
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            queue.add(new Jewel(m, v));
        }

        TreeMap<Integer, Integer> bags = new TreeMap();
        for (int i = 0; i < K; i++) {
            int bagMass = Integer.parseInt(br.readLine());
            bags.put(bagMass, bags.getOrDefault(bagMass, 0) + 1);
        }

        long sumValue = 0;
        while (!queue.isEmpty()) {
            Jewel now = queue.poll();
            Map.Entry<Integer, Integer> ceiling = bags.ceilingEntry(now.m);
            if (ceiling != null) {
                sumValue += now.v;
                if (ceiling.getValue() == 1) {
                    bags.remove(ceiling.getKey());
                } else {
                    bags.put(ceiling.getKey(), ceiling.getValue() - 1);
                }
            }
        }

        System.out.println(sumValue);
    }
}

class Jewel {
    int m;
    int v;

    public Jewel(int m, int v) {
        this.m = m;
        this.v = v;
    }
}