class Solution {
    private int comp, k;
    private int[] values;
    private List<Integer>[] tree;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.k = k;
        this.values = values;
        this.comp = 0;
        this.tree = new LinkedList[n];

        for(int i=0;i<n;i++) tree[i] = new LinkedList<>();
        for(int[] edge: edges){
            int u = edge[0], v = edge[1];
            tree[u].add(v);
            tree[v].add(u);
        }

        if(divide(0, 0)!=0) return -1; //For the case where sum(values) % k != 0
        return comp;
    }

    private int divide(int node, int parent){
        int res = values[node]%k;
        for(int next: tree[node]) 
            if(next!=parent)
                res = (res+divide(next, node))%k;

        if(res==0) comp++;
        return res;
    }
}