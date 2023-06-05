class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
                visit(0,rooms,visited);        
       
        for(int i=0;i<rooms.size();i++){
            if(!visited.contains(i)) return false;
        }

        return true;

    }

    public void visit(Integer key,List<List<Integer>> rooms,Set<Integer> visited){
        if(visited.contains(key)){
            return;
        }

        visited.add(key);
         for(Integer room : rooms.get(key)){
                   visit(room,rooms,visited); 
        }

    }


}