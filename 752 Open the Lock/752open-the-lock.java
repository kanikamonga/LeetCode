class Solution {
    Set<String> visit = new HashSet<>();

    public int openLock(String[] deadends, String target) {



            visit.addAll(Arrays.asList(deadends));

            if(visit.contains("0000")) return -1;

            LinkedList<String[]> q = new LinkedList<>();

            q.add(new String[]{"0000","0"});

            while(!q.isEmpty()){
                String[] ele = q.pop();
                String lock = ele[0];
                int turns = Integer.valueOf(ele[1]);
                System.out.println(lock);
                System.out.println(turns);
                if(lock.equals(target)) return turns;

                for(String child : getChildren(lock)){
                    if(!visit.contains(child)){
                        q.add(new String[]{child,String.valueOf(turns+1)});
                        visit.add(child);
                    }
                }   
            }

            return -1;
    }


    public List<String> getChildren(String s){
        List<String> result = new ArrayList<>();
        for(int i=0;i<4;i++){
            int digit =  s.charAt(i) - '0';
            StringBuilder sb = new StringBuilder("");
            sb.append(s.substring(0,i)).append((digit+1)%10).append(s.substring(i+1));
            result.add(sb.toString());
            sb = new StringBuilder("");
            sb.append(s.substring(0,i)).append((digit-1+10)%10).append(s.substring(i+1));
            result.add(sb.toString());
          
        }

        return result;
    }

}


