class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int st =0;
        int end = people.length-1;
        int count = 0;
        
        while(st<=end){
            if(people[st]+people[end] > limit){
                end--;
                
            }
            else{
                st++;
                end--;
            }
            count++;
        }
        return count;
    }
}