class Twitter {

    // Global timestamp to maintain tweet order
    int time;

    // userId -> set of users that this user follows
    Map<Integer, Set<Integer>> followMap;

    // userId -> list of tweets posted by the user
    Map<Integer, List<Tweet>> tweetMap;

    public Twitter() {
        time = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    // Post a new tweet
    public void postTweet(int userId, int tweetId) {

        // Create tweet list for the user if it doesn't exist
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>());

        // Store tweet with current timestamp
        tweetMap.get(userId).add(new Tweet(tweetId, time));

        // Increment global timestamp
        time++;
    }

    // Return the 10 most recent tweet ids
    public List<Integer> getNewsFeed(int userId) {

        List<Integer> res = new ArrayList<>();

        // Max Heap based on timestamp
        PriorityQueue<Node> maxHeap =
                new PriorityQueue<>((a, b) -> b.time - a.time);

        // User should always see his own tweets
        followMap.computeIfAbsent(userId, k -> new HashSet<>());
        followMap.get(userId).add(userId);

        // Add the latest tweet of every followed user into heap
        for(int followee : followMap.get(userId)){

            List<Tweet> tweets = tweetMap.get(followee);

            if(tweets == null || tweets.isEmpty()){
                continue;
            }

            // Last tweet is the latest one
            int index = tweets.size() - 1;

            Tweet t = tweets.get(index);

            maxHeap.offer(new Node(
                    t.time,
                    t.tweetId,
                    followee,
                    index
            ));
        }

        // Get at most 10 latest tweets
        while(!maxHeap.isEmpty() && res.size() < 10){

            Node curr = maxHeap.poll();

            res.add(curr.tweetId);

            // Move to previous tweet of the same user
            int prevIndex = curr.index - 1;

            if(prevIndex >= 0){

                Tweet prevTweet =
                        tweetMap.get(curr.userId).get(prevIndex);

                maxHeap.offer(new Node(
                        prevTweet.time,
                        prevTweet.tweetId,
                        curr.userId,
                        prevIndex
                ));
            }
        }

        return res;
    }

    // user follows followee
    public void follow(int followerId, int followeeId) {

        followMap.computeIfAbsent(followerId,
                k -> new HashSet<>());

        followMap.get(followerId).add(followeeId);
    }

    // user unfollows followee
    public void unfollow(int followerId, int followeeId) {

        if(followMap.containsKey(followerId)
                && followerId != followeeId){

            followMap.get(followerId).remove(followeeId);
        }
    }
}

// Stores one tweet
class Tweet{

    int tweetId;
    int time;

    Tweet(int tweetId, int time){
        this.tweetId = tweetId;
        this.time = time;
    }
}

// Used inside Max Heap
class Node{

    int time;
    int tweetId;
    int userId;
    int index;

    Node(int time,
         int tweetId,
         int userId,
         int index){

        this.time = time;
        this.tweetId = tweetId;
        this.userId = userId;
        this.index = index;
    }
}