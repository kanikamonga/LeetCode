class Solution {
    public List<String> findAllRecipes(
        String[] recipes, List<List<String>> ingredients, String[] supplies) {
      
        // Initialize a graph to represent ingredients pointing to recipes
        Map<String, List<String>> graph = new HashMap<>();
        // Initialize a map to store the indegree of each recipe
        Map<String, Integer> indegreeMap = new HashMap<>();
      
        // Build the graph and indegree map
        for (int i = 0; i < recipes.length; ++i) {
            for (String ingredient : ingredients.get(i)) {
                // Add the recipe to the list of recipes that the ingredient can make
                graph.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipes[i]);
            }
            // Set the initial indegree for the recipe based on number of ingredients required
            indegreeMap.put(recipes[i], ingredients.get(i).size());
        }
      
        // Queue to perform the topological sort
        Deque<String> queue = new ArrayDeque<>();
      
        // Offer all initial supplies to the queue
        for (String supply : supplies) {
            queue.offer(supply);
        }
      
        // List to store the available recipes to be returned
        List<String> availableRecipes = new ArrayList<>();
      
        // Process the graph using BFS - topological sort approach
        while (!queue.isEmpty()) {
            int size = queue.size(); // Number of elements to process in current level
          
            // Process all nodes in the current level
            for (int i = 0; i < size; ++i) {
                // Poll an ingredient from the queue
                String ingredient = queue.pollFirst();
              
                // Get all recipes that can be made with this ingredient
                for (String recipe : graph.getOrDefault(ingredient, Collections.emptyList())) {
                    // Decrease the indegree of the recipe
                    indegreeMap.put(recipe, indegreeMap.get(recipe) - 1);
                  
                    // If the recipe's indegree is zero, it can be made with available ingredients
                    if (indegreeMap.get(recipe) == 0) {
                        availableRecipes.add(recipe);
                        // Offer this recipe as a new available ingredient
                        queue.offer(recipe);
                    }
                }
            }
        }
      
        // Return the list of available recipes
        return availableRecipes;
    }
}