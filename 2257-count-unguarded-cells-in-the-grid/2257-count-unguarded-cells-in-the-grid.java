class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        
        int vis[][]=new int[m][n];
        for(int a[]:vis){
            Arrays.fill(a,-1);
        }
        
        int totalCell=m*n;

        int ans=0;
        for(int x[]:guards){
            int r=x[0];
            int c=x[1];
            ans++;
            vis[r][c]=1;
        }

        for(int x[]:walls){  
            int r=x[0];
            int c=x[1];
            ans++;

            vis[r][c]=0;
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==1){
                    
                    ans+=checkRightRow(m,n,i,j+1,vis);
                    
                    ans+=checkLeftRow(m,n,i,j-1,vis);
                    
                    ans+=checkDownCol(m,n,i+1,j,vis);
                    
                    ans+=checkUpCol(m,n,i-1,j,vis);
                    
                }
            }
        }

        return totalCell-ans;
    }
    public int checkRightRow(int m,int n,int r,int c,int vis[][]){
        if(c==n || vis[r][c]==0 || vis[r][c]==1){
            return 0;
        }
        
        if(vis[r][c]==2){
            // System.out.println("rr");
            // System.out.println(c);
            return checkRightRow(m,n,r,c+1,vis);
        }
        else{
            vis[r][c]=2;
            return 1+checkRightRow(m,n,r,c+1,vis);
        }
    }
    public int checkLeftRow(int m,int n,int r,int c,int vis[][]){
        
        if(c==-1 || vis[r][c]==0 || vis[r][c]==1){
            return 0;
        }
        if(vis[r][c]==2){
            return checkLeftRow(m,n,r,c-1,vis);
        }
        else{
        vis[r][c]=2;
        return 1+checkLeftRow(m,n,r,c-1,vis);
        }
    }

    public int checkDownCol(int m,int n,int r,int c,int vis[][]){
        
        if(r==m || vis[r][c]==0 || vis[r][c]==1){
            return 0;
        }
        if(vis[r][c]==2){
            return checkDownCol(m,n,r+1,c,vis);
        }
        else{
        vis[r][c]=2;
        return 1+checkDownCol(m,n,r+1,c,vis);
        }
    }

        public int checkUpCol(int m,int n,int r,int c,int vis[][]){
        if(r==-1 || vis[r][c]==0 || vis[r][c]==1){
            return 0;
        }
        if(vis[r][c]==2){
            return checkUpCol(m,n,r-1,c,vis);
        }
        else{
        vis[r][c]=2;
        return 1+checkUpCol(m,n,r-1,c,vis);
        }
        
    }
}