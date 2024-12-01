class Solution {
    public boolean checkIfExist(int[] arr) {
        int n = arr.length;

        Set<Integer> set = new HashSet<>();

        for(int ele : arr){
            if(set.contains(2*ele) || (ele % 2 == 0 && set.contains(ele/2))) return true;
            else set.add(ele);
        }

        return false;
    }
}