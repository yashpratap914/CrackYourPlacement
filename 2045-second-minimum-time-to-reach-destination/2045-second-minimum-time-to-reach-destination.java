class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] edge : edges) {
            adjList.putIfAbsent(edge[0], new ArrayList<>());
            adjList.putIfAbsent(edge[1], new ArrayList<>());
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int[] dist = new int[n+1];
        int[] dist_two = new int[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(dist_two, Integer.MAX_VALUE);
        dist[1] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});

        while(q.isEmpty() == false) {
            int[] curr = q.poll();
            for(int nbr : adjList.get(curr[0])) {
                int newDistance = curr[1] + 1;
                if(dist[nbr] > newDistance) {
                    q.add(new int[]{nbr, newDistance});
                    dist[nbr] = newDistance;
                }
                else if(dist_two[nbr] > newDistance && newDistance != dist[nbr]) {
                    q.add(new int[]{nbr, newDistance});
                    dist_two[nbr] = newDistance;
                }
            }
        }
        System.out.println("distance two is " + dist_two[n]);
        return getUpdatedTime(dist_two[n], change, time);

    }

    int getUpdatedTime(int steps, int change, int time) {
        int curr = 0;
        while(steps-- > 0) {
            if((curr / change) % 2 == 1) {
                curr = (((curr / change) + 1) * change);
            }
            curr += time;
        }

        return curr;
    }
}