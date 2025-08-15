class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
         Map<Integer,List<int[]>>graph=new HashMap<>();

        for(int[] edge:times){
            int u=edge[0],v=edge[1],w=edge[2];
            graph.putIfAbsent(u,new ArrayList<>());
            graph.get(u).add(new int[]{v,w});
        }

        int distance[]=new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);

        distance[k]=0;

        PriorityQueue<int[]>pq=new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        pq.add(new int[]{k,0});

        while(!pq.isEmpty()){
            int[] node=pq.poll();
            int u=node[0],time=node[1];

            
            List<int[]>neighbours=graph.getOrDefault(u,new ArrayList<>());
            for(int[] neighbour:neighbours){
                int v=neighbour[0],w=neighbour[1];

                if(time+w < distance[v]){
                    distance[v]=time+w;
                    pq.offer(new int[]{v,distance[v]});
                }

            }
        }
         for(int i=1;i<=n;i++)
          if(distance[i]==Integer.MAX_VALUE)
              return -1;

     int max=0;
     for(int i=1;i<=n;i++)
       max=Math.max(max,distance[i]);

                return max;

    }

}