class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum =0;
        for(int i=0; i<chalk.length; i++){ // cal chalks used in one traversal (sum of array)
            sum+=chalk[i];
        }
        int remchalks = (int)(k%sum); // find chalks left after complete traversal round
        for(int i=0; i<chalk.length; i++){ // again checking when will chalk end or will become less than required
            if(remchalks<chalk[i]){
                return i;
            }
            remchalks -= chalk[i];
        }
        return -1;
    }
}