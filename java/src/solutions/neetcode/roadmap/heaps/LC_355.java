package solutions.neetcode.roadmap.heaps;

import solutions.Solution;

import java.util.*;

public class LC_355 implements Solution {
    @Override
    public void solve() {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
    }

    class Twitter {
        record Tweet(int tweetId, int time) {
        }

        // should we have a third map that creates a feed for each userId when somebody
        // posts and somebody else follows them?
        private Map<Integer, Set<Integer>> follows; // userid, set(userid)s
        private Map<Integer, List<Tweet>> tweets; // userId, Tweets
        private int time;

        Twitter() {
            this.time = 0;
            this.tweets = new HashMap<>();
            this.follows = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            this.tweets.putIfAbsent(userId, new ArrayList<>());
            this.tweets.get(userId).add(new Tweet(tweetId, this.time));
            this.time += 1;
        }

        record TweetFeed(int time, int tweetId, int followeeId, int nextRecentIdx) {
        }

        public List<Integer> getNewsFeed(int userId) {
            this.follows.putIfAbsent(userId, new HashSet<>());
            this.follows.get(userId).add(userId);
            // compose 10 most recent from heaps
            List<Integer> recentTweets = new ArrayList<>(10);
            PriorityQueue<TweetFeed> minHeap = new PriorityQueue<>(Comparator.comparing(TweetFeed::time).reversed());
            for (int followeeId : this.follows.get(userId)) {
                if (this.tweets.containsKey(followeeId)) {
                    int idx = this.tweets.get(followeeId).size() - 1;
                    Tweet t = this.tweets.get(followeeId).get(idx);
                    minHeap.add(new TweetFeed(t.time, t.tweetId, followeeId, idx - 1));
                }
            }
            while (!minHeap.isEmpty() && recentTweets.size() < 10) {
                TweetFeed tf = minHeap.remove();
                recentTweets.add(tf.tweetId);
                if (tf.nextRecentIdx >= 0) {
                    Tweet t = this.tweets.get(tf.followeeId).get(tf.nextRecentIdx);
                    minHeap.add(new TweetFeed(t.time, t.tweetId, tf.followeeId, tf.nextRecentIdx - 1));
                }
            }
            return recentTweets;
        }

        public void follow(int followerId, int followeeId) {
            this.follows.putIfAbsent(followerId, new HashSet<>());
            this.follows.get(followerId).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            this.follows.putIfAbsent(followerId, new HashSet<>());
            this.follows.get(followerId).remove(followeeId);
        }
    }

}