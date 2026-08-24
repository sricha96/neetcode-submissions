class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();

        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            int prerequisite = pre[1];
            int course = pre[0];
            adjList.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        int noOfCourseCompleted = 0;

        while(!queue.isEmpty()){
            int currCourse = queue.poll();
            noOfCourseCompleted++;

            for(int nextCourse : adjList.get(currCourse)){
                indegree[nextCourse]--;

                if(indegree[nextCourse] == 0){
                    queue.add(nextCourse);
                }
            }
        }
        
        return noOfCourseCompleted == numCourses;
    }
}
