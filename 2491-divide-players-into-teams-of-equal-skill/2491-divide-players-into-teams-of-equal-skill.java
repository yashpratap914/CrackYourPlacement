class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long ans = 0;
        int i = 0;
        int j = skill.length - 1;
        int check = skill[i] + skill[j];
        while (i < j) {
            if (skill[i] + skill[j] != check) {
                return -1;
            }
            ans += skill[i] * skill[j];
            // System.out.println(skill[i] + " - " + skill[j] + " - " + ans);
            i++;
            j--;
        }

        return ans;
        
    }
}