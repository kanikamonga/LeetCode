class Solution {
    class Node {
        String dest;
        double value;
        public Node(String d, double v) {
            dest = d;
            value = v;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
          Map<String, List<Node>> graph = createGraph(equations, values);

        double[] ans = new double[queries.size()];
        
        for(int i=0; i<queries.size(); i++) {
            ans[i] = dfs(queries.get(i).get(0),queries.get(i).get(1),new HashSet<>(),graph);
        }

        return ans;
    }
    public double dfs(String s, String d, Set<String> visited, Map<String,List<Node>> graph) {
        if(!(graph.containsKey(s) && graph.containsKey(d))) {
            return -1.0;
        }
        if(s.equals(d)) {
            return 1.0;
        }
        visited.add(s);
        for(Node neigh : graph.get(s)) {
            if(!visited.contains(neigh.dest)) {
                double ans = dfs(neigh.dest, d, visited, graph);
                if(ans != -1.0) {
                    return ans * neigh.value;
                }
            }
        }
        return -1.0;
    }
    public Map<String,List<Node>> createGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Node>> graph = new HashMap<>();

        for(int i=0; i<values.length; i++) {
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            graph.putIfAbsent(src, new ArrayList());
            graph.putIfAbsent(dest, new ArrayList());
            graph.get(src).add(new Node(dest, values[i]));
            graph.get(dest).add(new Node(src, 1/values[i]));
        }

        return graph;
    }
}