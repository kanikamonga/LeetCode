public class Solution {

    public int minCostConnectPoints(int[][] points) {
        // Define a very large number for the initial distances
        final int INFINITY = 1 << 30;

        // Get the number of points
        int numberOfPoints = points.length;

        // Create a graph represented by an adjacency matrix
        int[][] graph = new int[numberOfPoints][numberOfPoints];

        // Calculate all the distances between each pair of points
        for (int i = 0; i < numberOfPoints; ++i) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = i + 1; j < numberOfPoints; ++j) {
                int x2 = points[j][0], y2 = points[j][1];
                int distance = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                graph[i][j] = distance;
                graph[j][i] = distance;
            }
        }

        // Create an array to store the minimum distance from the selected point to the MST
        int[] minDistances = new int[numberOfPoints];

        // Keep track of visited points
        boolean[] visited = new boolean[numberOfPoints];

        // Initialize distances with a very large number
        Arrays.fill(minDistances, INFINITY);

        // The distance of the first point from itself is zero
        minDistances[0] = 0;

        // Accumulate the minimum cost of connecting all points
        int totalCost = 0;

        // Build the Minimum Spanning Tree (MST) using Prim's algorithm
        for (int i = 0; i < numberOfPoints; ++i) {
            int nearestPoint = -1; // Index of the closest unvisited point

            // Find the unvisited point with the minimum distance to the MST
            for (int k = 0; k < numberOfPoints; ++k) {
                if (!visited[k] && (nearestPoint == -1 || minDistances[k] < minDistances[nearestPoint])) {
                    nearestPoint = k;
                }
            }

            // Include this nearest unvisited point to the MST
            visited[nearestPoint] = true;

            // Add its distance to the total cost
            totalCost += minDistances[nearestPoint];

            // Update the minDistances array with the new possible shorter distances
            for (int k = 0; k < numberOfPoints; ++k) {
                if (!visited[k]) {
                    minDistances[k] = Math.min(minDistances[k], graph[nearestPoint][k]);
                }
            }
        }

        // Return the total cost of connecting all the points
        return totalCost;
    }
}