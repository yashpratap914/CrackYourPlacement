class Solution {
    public int countSeniors(String[] details) {
        //substring method
        int count =0;
        for(String detail: details){
            String age = detail.substring(11,13); // age place extracted
            int ageval = Integer.parseInt(age);// converted to integer
            if(ageval>60){ // condition given
                count++;
            }
        }
        return count;
        
        
    }
}