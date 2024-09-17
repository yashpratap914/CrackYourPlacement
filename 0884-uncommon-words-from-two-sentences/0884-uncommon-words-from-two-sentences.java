class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String str1[]=s1.split(" ");
        String str2[]=s2.split(" ");
       

        HashMap<String, Integer>wordCount=new HashMap<>();
        for(String str:str1)
        {
           wordCount.put(str, wordCount.getOrDefault(str, 0)+1);
        }
          for(String str:str2)
        {
            wordCount.put(str, wordCount.getOrDefault(str, 0)+1);
        }
         ArrayList<String>list=new ArrayList<>();
         for(String str:wordCount.keySet())
         {
            if(wordCount.get(str)==1)
            {
                list.add(str);
            }
         }
        return list.toArray(new String[list.size()]);
        
    }
}