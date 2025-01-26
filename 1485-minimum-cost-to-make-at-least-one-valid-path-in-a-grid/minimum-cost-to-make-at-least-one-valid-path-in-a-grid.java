import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] cost = new int[m][n];
        
        // Initialize cost array with a high value
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        
        // Deque for BFS
        Deque<int[]> deque = new LinkedList<>();
        deque.offer(new int[]{0, 0}); // Start from (0, 0)
        cost[0][0] = 0;
        
        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int x = current[0];
            int y = current[1];
            
            // Explore all 4 directions
            for (int d = 0; d < 4; d++) {
                int newX = x + directions[d][0];
                int newY = y + directions[d][1];
                
                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    int newCost = cost[x][y] + (grid[x][y] == d + 1 ? 0 : 1);
                    
                    // If this path offers a lower cost, update and process
                    if (newCost < cost[newX][newY]) {
                        cost[newX][newY] = newCost;
                        
                        // Add to deque based on cost
                        if (grid[x][y] == d + 1) {
                            deque.offerFirst(new int[]{newX, newY});
                        } else {
                            deque.offerLast(new int[]{newX, newY});
                        }
                    }
                }
            }
        }
        
        return cost[m - 1][n - 1];
    }
}
