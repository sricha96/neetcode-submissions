class Twitter {

    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<int[]>> tweetMap;
    int count;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        count = 0;
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>())
            .add(new int[]{count++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        List<Integer> res = new ArrayList<>();

        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        for(int followee : followMap.get(userId)){
            if(tweetMap.containsKey(followee)){
                List<int[]> tweetList = tweetMap.get(followee);
                int index = tweetList.size() - 1;
                int[] tweets = tweetList.get(index);
                maxHeap.add(new int[]{tweets[0], tweets[1], followee, index});
            }
        }

        while(!maxHeap.isEmpty() && res.size() < 10){
            int[] curr = maxHeap.poll();
            res.add(curr[1]);
            int followerId = curr[2];
            int index = curr[3];
            if(index > 0){
                List<int[]> tweets = tweetMap.get(followerId);
                int[] tweet = tweets.get(index - 1);
                maxHeap.add(new int[]{tweet[0], tweet[1], followerId, index - 1});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followeeList = followMap.get(followerId);
        if(followeeList.contains(followeeId)){
            followeeList.remove(followeeId);
        }
        followMap.put(followerId, followeeList);
    }
}
