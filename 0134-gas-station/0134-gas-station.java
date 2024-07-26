class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totaldiff =0, fuel =0, index=0;
        for(int i=0; i<gas.length; i++){
            int diff = gas[i]-cost[i];
            totaldiff += diff;
            fuel += diff;
            if(fuel<0){  // agr pehle hi fuel khatam hogya matlab hai ki aage ki index mei hi possible ans hoga
                index = i+1; // aage ki index stored
                fuel =0;  // dobara shunya se shuru
            }
        }
        return (totaldiff<0)?-1:index;
        
        
        
        
    }
}