class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // indegree[i] = number of prerequisites for course i
        int[] indegree = new int[numCourses];

        // Adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        // prerequisite -> course
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];

            adj.get(prerequisite).add(course);
            indegree[course]++;
        }

        // Add all courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int index = 0;

        // Kahn's Algorithm (BFS)
        while (!queue.isEmpty()) {

            int curr = queue.poll();
            order[index++] = curr;

            for (int next : adj.get(curr)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // If all courses are processed, return the order
        if (index == numCourses) {
            return order;
        }

        // Cycle exists
        return new int[0];
    }
}
