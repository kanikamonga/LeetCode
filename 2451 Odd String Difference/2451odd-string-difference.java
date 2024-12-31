class Solution {
    public String oddString(String[] words) {


 ArrayList<Integer> fn = diffofListOfString(words);
        Map<Integer, Integer> hm = new HashMap<>();
        int index = 0;
        for (int sf : fn) {
            if (!hm.containsKey(sf)) {
                hm.put(sf, 1);
            } else {
                hm.put(sf, hm.get(sf) + 1);
        
            }
        }
       int df = -1;
       
        for (Map.Entry<Integer, Integer> m : hm.entrySet()) {
            if (m.getValue() == 1) {

               df=m.getKey();


            }
        }
     index= fn.indexOf(df);
    return words[index];   
    }
    
     public static ArrayList<Integer> diffofListOfString( String[] sd)
    {
        ArrayList<Integer> fn = new ArrayList<>();
        for (int i = 0; i < sd.length; i++)
        {
            fn.add(diffofString(sd[i]));
        } 
        return fn;
    }
 
      public static int diffofString(String ss) {
        ArrayList<Integer> differences = new ArrayList<>();
        for (int i = 0; i < ss.length() - 1; i++)
        {
            differences.add(ss.charAt(i + 1) - ss.charAt(i));
        }
        return differences.hashCode();
    }

    }