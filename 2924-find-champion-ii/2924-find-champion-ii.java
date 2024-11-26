class Solution {
    public int findChampion(int n, int[][] edges) {
        HashSet<Integer> weak_player = new HashSet<>();
        for(int[] a : edges) weak_player.add(a[1]);
        
        int strong_player_index = 0;
        int strong_player_count = 0;
        
        for(int i = 0; i < n; i++) {
            if(!weak_player.contains(i)) {
                strong_player_index = i;
                strong_player_count++;
            }

            // optimization 
            if(strong_player_count > 1) return -1;
        }
        
        return strong_player_index;
    }
}