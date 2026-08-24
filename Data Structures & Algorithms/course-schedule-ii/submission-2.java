class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] indegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int prerequisite = pre[1];
            int course = pre[0];
            adjList.get(prerequisite).add(course);
            indegree[course]++;
        }

        int[] res = new int[numCourses];
        int index = 0;

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            Integer currCourse = queue.poll();
            res[index++] = currCourse;

            for(int nextCourse : adjList.get(currCourse)){
                indegree[nextCourse]--;

                if(indegree[nextCourse] == 0){
                    queue.add(nextCourse);
                }
            }
        }
        return index == numCourses ? res : new int[]{};
    }
}
