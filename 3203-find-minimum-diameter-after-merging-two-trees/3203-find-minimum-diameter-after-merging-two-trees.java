class Solution {
    private int res;

    private int dfs(List<Integer>[] G, int u, int p) {
        int h1 = 0, h2 = 0;
        for (int v: G[u]) {
            if (v == p) continue;
            int h = dfs(G, v, u);
            if (h >= h1) {
                h2 = h1;
                h1 = h;
            } else if (h > h2) {
                h2 = h;
            }
        }
        res = Math.max(res, h1 + h2);
        return h1 + 1;
    }

    private int diameter(List<Integer>[] G) {
        res = 0;
        dfs(G, 0, -1);
        return res;
    }

    private List<Integer>[] buildGraph(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] G = new ArrayList[n];
        for (int i = 0; i < n; i++)
            G[i] = new ArrayList<>();
        for (int[] e: edges) {
            G[e[0]].add(e[1]);
            G[e[1]].add(e[0]);
        }
        return G;
    }

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int d1 = diameter(buildGraph(edges1)), d2 = diameter(buildGraph(edges2));
        return Math.max(Math.max(d1, d2), ((d1 + 1) >> 1) + ((d2 + 1) >> 1) + 1);
    }
}