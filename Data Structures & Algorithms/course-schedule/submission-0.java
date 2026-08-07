class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            indegree[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();
        while(!queue.isEmpty()){
            int curr = queue.poll();
            topo.add(curr);
            for(int n : adj.get(curr)){
                indegree[n]--;
                if(indegree[n] == 0){
                    queue.add(n);
                }
            }
        }
        if(topo.size() == numCourses){
            return true;
        }
        return false;
    }
}
