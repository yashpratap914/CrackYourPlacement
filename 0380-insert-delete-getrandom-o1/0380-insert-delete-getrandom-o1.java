class RandomizedSet {
    // Arraylist -> HashMap
    HashMap<Integer, Integer> hm;
    List<Integer> list;

    public RandomizedSet() {
        hm = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(hm.containsKey(val)) return false;//false for duplicate
        list.add(val); // add new val to list
        hm.put(val,list.size()-1); // make new key value pair
        return true;
    }
    
    public boolean remove(int val) {
        if(hm.containsKey(val) == false) return false; // if it doesnt exist in list return false
        int ind = hm.get(val);  // if it exists get index(value)
        Collections.swap(list, ind, list.size()-1); // swap with last element
        int swappedwith = list.get(ind); // stored removed index
        hm.put(swappedwith, ind); // changed index value(last that was swapped)
        list.remove(list.size()-1); //removed last ele from list
        hm.remove(val); // remove from hashmap
        return true;
    }
    
    public int getRandom() {
        Random random = new Random();
        int n = random.nextInt(list.size());
        return list.get(n);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */