class Solution {
        static class Edge implements Comparable<Edge> {
            int s;
            int d;
            int t;

            Edge(int src, int dst, int type) {
                s = src;
                d = dst;
                t = type;
            }

            @Override
            public int compareTo(Edge e) {
                if(e.t != this.t)
                    return e.t - this.t;

                if(e.s != this.s)
                    return e.s - this.s;

                return e.d - this.d;
            }

            @Override
            public boolean equals(Object o) {
                Edge e = ((Edge)o);
                return e.t == this.t &&
                        (
                                (e.s == this.s && e.d == this.d) ||
                                        (e.s == this.d && e.d == this.s)
                        );
            }

            @Override
            public int hashCode() {
                return 31 * t * s * d;
            }
        }

        private Set<Edge> getMST(List<Edge> adj[], int n, int type) {
            Set<Edge> out = new HashSet();
            PriorityQueue<Edge> q = new PriorityQueue();
            q.add(new Edge(0, 0, -1));

            boolean vis[] = new boolean[n];

            while(!q.isEmpty()) {
                Edge r = q.poll();

                if(vis[r.d])
                    continue;

                vis[r.d] = true;

                if(r.t != -1)
                    out.add(r);

                for(Edge e: adj[r.d]) {
                    if(!vis[e.d] && (e.t == 3 || e.t == type)) {
                        q.add(e);
                    }
                }

            }

            for(int i=0;i<n;i++) {
                if(!vis[i])
                    return Collections.emptySet();
            }

            return out;
        }

        public int maxNumEdgesToRemove(int n, int[][] edges) {

            List<Edge> adj[] = new List[n];
            for(int i=0;i<n;i++)
                adj[i] = new ArrayList();

            for(int i=0;i<edges.length;i++) {
                adj[edges[i][1]-1].add(new Edge(edges[i][1]-1, edges[i][2]-1, edges[i][0]));
                adj[edges[i][2]-1].add(new Edge(edges[i][2]-1, edges[i][1]-1, edges[i][0]));
            }

            Set<Edge> aliceMST = getMST(adj, n, 1);
            Set<Edge> bobMST = getMST(adj, n, 2);

            if(aliceMST.isEmpty() || bobMST.isEmpty())
                return -1;

            aliceMST.addAll(bobMST);

            return edges.length - aliceMST.size();
        }
    }
