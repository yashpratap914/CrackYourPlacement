class Solution {
    public long wonderfulSubstrings(String word) {
        long result = 0l;
        int mask = 0;
        // the count array contains the number of times a particualr mask value is seen until now. 
        // Why size of 1024? Because we have 10 char allowed - a to j, so maximum value of mask can be 2^10 =1024.
        // Eg: mask value 0, 1, 2, 3, 4, .. 1023.. each corresponding to a-j
              // 9 8 7 6 5 4 3 2 1 0
              // j i h g f e d c b a
   //max value = 1 1 1 1 1 1 1 1 1 1
        // = 2^10 = 1024
        int[] count = new int[1024];
        
        // also set count[0] = 1, to represent empty string, mask 0 happened once.
        count[0] = 1;
        
        // iterate over each char one pass, and 
        // a) find mask value at current position
        // b) count substrings with all even occurences
        // c) count substrings with just 1 odd occurence
		// d) update count array to increment the number of occurence we saw the mask by 1
        for(char c: word.toCharArray()) {
            // for even count substrings
            mask = mask ^ (1 << c - 'a');
            result = result + count[mask];
            // for max 1 odd count substrings
            for(int i = 0; i < 10; i++) {
                // lets see if we have seen substrings with 1 odd char count (a-j)
                result = result + count[mask^ (1<<i)];
            }
            
            // update count array that we have seen mask=m now
            count[mask]++;
        }
        return result;
        
    }
}