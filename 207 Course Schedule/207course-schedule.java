class Solution {

    // By BFS (Khan's Algo)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites) {
            indegree[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while(!queue.isEmpty()) {
            int currNode = queue.poll();
            count++;
            for(int neighbour : adj.get(currNode)) {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return count == numCourses;
    }
}