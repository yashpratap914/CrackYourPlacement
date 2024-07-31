class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        return dfs(0, 0, 0, books, shelfWidth, new Integer[books.length][shelfWidth + 1]);
    }

    private int dfs(int index, int currWidth, int currHeight, int[][] books, int shelfWidth, Integer[][] memo) {
        if (index == books.length) {
            return currHeight;
        }
        if (memo[index][currWidth] != null) {
            return memo[index][currWidth];
        }

        // place on this shelf
        int way1 = Integer.MAX_VALUE;
        if (currWidth + books[index][0] <= shelfWidth) {
            int newWidth = currWidth + books[index][0];
            int newHeight = Math.max(currHeight, books[index][1]);
            way1 = dfs(index + 1, newWidth, newHeight, books, shelfWidth, memo);
        }
        // place on a new shelf
        int way2 = currHeight + dfs(index + 1, books[index][0], books[index][1], books, shelfWidth, memo);

        return memo[index][currWidth] = Math.min(way1, way2);
    }
}