class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int [][] graph=new int[n][n];
        for(int []t:graph) Arrays.fill(t,99999);
        for(int i=0;i<n;i++) graph[i][i]=0;
        for(int i=0;i<edges.length;i++){
            graph[edges[i][0]][edges[i][1]]=edges[i][2];
            graph[edges[i][1]][edges[i][0]]=edges[i][2];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    graph[j][k]=Math.min(graph[j][k],graph[j][i]+graph[i][k]);
                }
            }
        }
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(graph[i][j]!=0 && graph[i][j]<=distanceThreshold) count++;
            }
            if(min>count){
                max=i;
                min=count;
            }
            else if(min==count) max=Math.max(max,i);
        }
        return max;
        
    }
}