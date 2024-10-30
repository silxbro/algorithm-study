package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class N7568_덩치 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Person[] people = new Person[N];
        int[] order = new int[N];
        Arrays.fill(order, 1);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            people[i] = new Person(w, h);
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (people[i].compareTo(people[j]) < 0) {
                    order[j]++;
                } else if (people[i].compareTo(people[j]) > 0) {
                    order[i]++;
                }
            }
        }

        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < order.length; i++) {
            stb.append(order[i]).append(" ");
        }
        System.out.println(stb);
    }
}

class Person implements Comparable<Person> {
    int w;
    int h;
    Person(int w, int h) {
        this.w = w;
        this.h = h;
    }

    @Override
    public int compareTo(Person o) {
        if (w < o.w && h < o.h) {
            return 1;
        }
        if (w > o.w && h > o.h) {
            return -1;
        }
        return 0;
    }
}
