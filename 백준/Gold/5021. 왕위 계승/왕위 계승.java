import java.io.*;
import java.util.*;

public class Main {
    static HashMap<String, Integer> id = new HashMap<>();
    static ArrayList<String> name = new ArrayList<>();

    static int getId(String s) {
        Integer v = id.get(s);
        if (v != null) return v;
        int newId = name.size();
        id.put(s, newId);
        name.add(s);
        return newId;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String kingName = br.readLine().trim();
        int king = getId(kingName);

        // 최악치로 넉넉히 (관계 N줄 * 3이름 + 주장자 M)
        int CAP = N * 3 + M + 1;

        int[] p1 = new int[CAP];
        int[] p2 = new int[CAP];
        Arrays.fill(p1, -1);
        Arrays.fill(p2, -1);

        ArrayList<Integer>[] children = new ArrayList[CAP];
        for (int i = 0; i < CAP; i++) children[i] = new ArrayList<>();

        int[] indeg = new int[CAP];
        double[] blood = new double[CAP];

        // 관계 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String childN = st.nextToken();
            String p1N = st.nextToken();
            String p2N = st.nextToken();

            int c = getId(childN);
            int a = getId(p1N);
            int b = getId(p2N);

            p1[c] = a;
            p2[c] = b;

            children[a].add(c);
            children[b].add(c);
            indeg[c] += 2;
        }

        // 위상정렬로 피 전파
        blood[king] = 1.0;

        ArrayDeque<Integer> q = new ArrayDeque<>();
        int people = name.size();
        for (int i = 0; i < people; i++) {
            if (indeg[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int c : children[x]) {
                blood[c] += blood[x] / 2.0;
                indeg[c]--;
                if (indeg[c] == 0) q.add(c);
            }
        }

        // 주장자 중 최대 blood
        String ans = null;
        double best = -1;

        for (int i = 0; i < M; i++) {
            String claimant = br.readLine().trim();
            int cid = getId(claimant); // 주장자 이름이 관계에 없어도 등장할 수 있음

            // 주의: 주장자가 새로 추가되면 people 범위 밖이 될 수 있어서 갱신 필요
            if (blood[cid] > best) {
                best = blood[cid];
                ans = claimant;
            }
        }

        System.out.println(ans);
    }
}