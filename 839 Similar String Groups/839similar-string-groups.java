class Solution {
    public boolean isSimilar(String a, String b){
        int m = a.length();
        int count = 0;
        for(int i = 0; i < m; i++){
            if(a.charAt(i) != b.charAt(i)){
                count++;
            }
            if(count > 2){
                return false;
            }
        }
        return (count == 0 || count == 2);
    }

    public void dfs(String[] strs, boolean[] visited, int index){
        int n = strs.length;
        for(int i = 0; i < n; i++){
            if(visited[i]){
                continue;
            }
            if(isSimilar(strs[index], strs[i])){
                visited[i] = true;
                dfs(strs, visited, i);
            }
        }
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int groups = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                groups++;
                dfs(strs, visited, i);
            }
        }
        return groups;
    }
}