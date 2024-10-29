import java.io.*;
import java.util.*;

public class Main {

    private static ArrayList<Line>[] tree;
    private static int v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken()); // 노드 수
        int e = Integer.parseInt(st.nextToken()); // 간선 수

        // 인접 리스트 초기화
        tree = new ArrayList[v + 1];
        for (int i = 0; i <= v; i++) {
            tree[i] = new ArrayList<>();
        }

        // 간선 정보 입력 받기
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());

            tree[i1].add(new Line(i2, w));
            tree[i2].add(new Line(i1, w));
        }

        // 프림 알고리즘으로 최소 스패닝 트리의 가중치 합 출력
        System.out.println(prim(1));
    }

    // 프림 알고리즘 구현
    private static long prim(int start) {
        PriorityQueue<Line> pq = new PriorityQueue<>(Comparator.comparingLong(l -> l.weight));
        boolean[] visited = new boolean[v + 1];
        long totalWeight = 0;

        // 시작 노드의 모든 간선을 우선순위 큐에 추가
        pq.add(new Line(start, 0));

        while (!pq.isEmpty()) {
            Line current = pq.poll();

            if (visited[current.target]) continue; // 이미 방문한 노드는 스킵
            visited[current.target] = true; // 방문 처리
            totalWeight += current.weight; // 가중치 추가

            // 현재 노드에서 갈 수 있는 모든 인접 노드 탐색
            for (Line neighbor : tree[current.target]) {
                if (!visited[neighbor.target]) {
                    pq.add(neighbor); // 방문하지 않은 노드만 큐에 추가
                }
            }
        }

        return totalWeight;
    }

    // 간선 정보 저장 클래스
    private static class Line {
        final int target;
        final long weight;

        private Line(int target, long weight) {
            this.target = target;
            this.weight = weight;
        }
    }
}
