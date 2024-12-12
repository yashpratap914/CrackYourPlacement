class Solution {
    public long pickGifts(int[] gifts, int k) {
        while (k-- > 0) {
            Arrays.sort(gifts);
            int pile = gifts[gifts.length - 1];
            gifts[gifts.length - 1] = (int) Math.sqrt(pile);
        }
        long ans = 0;
        for (int gift : gifts) {
            ans += gift;
        }
        return ans;
    }
}