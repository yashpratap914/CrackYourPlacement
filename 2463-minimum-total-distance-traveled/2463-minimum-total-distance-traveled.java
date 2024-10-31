class Solution {
    long[][] memo;
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        if(robot.isEmpty()) return 0;
        List<Integer> factories = new ArrayList<>();

        // add how many times a factory can repair a robot to a list
        //transform from this [[2,2][6,6]] to [2, 2, 6, 6]
        for(int[] f: factory) {
            while(f[1] > 0) {
                factories.add(f[0]);
                f[1]--;
            }
        }
        memo = new long[robot.size()+1][factories.size()+1];
        for(long[] arr: memo) {
            Arrays.fill(arr, -1l);
        }
        Collections.sort(factories);
        Collections.sort(robot);
        return getMinCost(robot, factories, 0, 0);
    }

    private long getMinCost(List<Integer> robot, List<Integer> factory, int i, int j) {
        if(robot.size()-i > factory.size()-j) return Long.MAX_VALUE;
        if(i == robot.size()) {
            return 0;
        }

        if(memo[i][j] != -1) {
            return memo[i][j];
        }
        // case when robot i was repaired at factory j
        long cost1 = getMinCost(robot, factory, i+1, j+1) + 
                         Math.abs(factory.get(j)-robot.get(i));
        // case when robot i was not repaired yet
        long cost2 = getMinCost(robot, factory, i, j+1);
        
        long min = Math.min(cost1, cost2);
        memo[i][j] = min;
        return min;
        
    }
}