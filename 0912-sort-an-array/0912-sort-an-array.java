class Solution {
    public int[] sortArray(int[] n) {
        sort(n, 0, n.length-1);
        return n;
    }
    private void sort(int[] n, int l, int r){
        if(l==r)return;  // 1 length arr
        int m = (l +r)/2; // middle of array
        sort(n,l,m);  // left
        sort(n,m+1,r); // right 
        int[] x = new int[r-l+1]; // new array
        int li=l,  // new ptr left array
        ri=m+1;    // new ptr right array
        for(int i=0; i<x.length; i++){ //traversing new array
            if(ri>r){ // right arr iteration over -> add left ele
                x[i]=n[li++];
            }
            else if(li>m){//left arr iteration over -> add left ele
                x[i]=n[ri++];
            }
            else if(n[li]<=n[ri]){//left arr ele less -> add
                x[i]=n[li++];
            }
            else{ //right arr ele less -> add
                x[i]=n[ri++];
            } 
        }
        for(int i=0; i<x.length; i++){ // print each ele
            n[l+i]=x[i];
        }
    }
}