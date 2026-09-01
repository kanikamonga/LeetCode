class Solution {

    public int maximumScore(int[] scores, int[][] edges) {
        int nodeCount = scores.length;

        // Keep the 3 highest-scoring neighbors for every node.
        PriorityQueue<Integer>[] topNeighbors = new PriorityQueue[nodeCount];

        for (int node = 0; node < nodeCount; node++) {
            topNeighbors[node] = new PriorityQueue<>(
                (a, b) -> Integer.compare(scores[a], scores[b])
            );
        }

        // Build the top-3 neighbor list for every node.
        for (int[] edge : edges) {
            int nodeA = edge[0];
            int nodeB = edge[1];

            addNeighbor(topNeighbors[nodeA], nodeB, scores);
            addNeighbor(topNeighbors[nodeB], nodeA, scores);
        }

        int maximumScore = -1;

        // Treat every edge as the middle two nodes of the sequence:
        // nodeA -> nodeB
        for (int[] edge : edges) {
            int nodeA = edge[0];
            int nodeB = edge[1];

            // Pick one neighbor of nodeA and one neighbor of nodeB.
            for (int neighborA : topNeighbors[nodeA]) {
                for (int neighborB : topNeighbors[nodeB]) {

                    // All four nodes must be distinct.
                    if (neighborA == nodeB ||
                        neighborB == nodeA ||
                        neighborA == neighborB) {
                        continue;
                    }

                    int sequenceScore =
                        scores[neighborA]
                        + scores[nodeA]
                        + scores[nodeB]
                        + scores[neighborB];

                    maximumScore = Math.max(maximumScore, sequenceScore);
                }
            }
        }

        return maximumScore;
    }

    private void addNeighbor(
            PriorityQueue<Integer> neighbors,
            int neighbor,
            int[] scores) {

        neighbors.offer(neighbor);

        // Only the 3 highest-scoring neighbors are needed.
        if (neighbors.size() > 3) {
            neighbors.poll();
        }
    }
}