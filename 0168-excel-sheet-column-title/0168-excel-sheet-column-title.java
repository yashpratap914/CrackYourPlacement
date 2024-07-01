class Solution {
    public String convertToTitle(int cn) {
        StringBuilder sb= new StringBuilder();
        String alph="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if(cn<27){
            return String.valueOf(alph.charAt(cn-1));
        }
        while(cn>26){
            int temp= cn%26;
            System.out.println(temp);
            if(temp>0)
            {
                sb.append(alph.charAt(temp-1));
                cn=cn/26;
            }
            else{
                sb.append('Z');
                cn /= 26;
                cn -= 1;
            }
        }
        sb.append(alph.charAt(cn-1));
        return String.valueOf(sb.reverse());
        
    }
}