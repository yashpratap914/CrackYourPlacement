class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet<>();
        int x = 0;
        int y = 0;
        visited.add(x + "," + y);
        
        for (char direction : path.toCharArray()) {
            if (direction == 'N') {
                y++;
            } else if (direction == 'S') {
                y--;
            } else if (direction == 'E') {
                x++;
            } else if (direction == 'W') {
                x--;
            }
            
            String currentPosition = x + "," + y;
            if (visited.contains(currentPosition)) {
                return true;
            }
            
            visited.add(currentPosition);
        }
        
        return false;
        
    }
}