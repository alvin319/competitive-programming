from collections import defaultdict

class Twitter(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.follow_map = defaultdict(set)
        self.tweet_map = defaultdict(list)
        self.true_id_map = dict()
        self.id_count = 0
        

    def postTweet(self, userId, tweetId):
        """
        Compose a new tweet.
        :type userId: int
        :type tweetId: int
        :rtype: void
        """
        self.tweet_map[userId].append(tweetId)
        self.true_id_map[tweetId] = self.id_count
        self.id_count += 1
        

    def getNewsFeed(self, userId):
        """
        Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
        :type userId: int
        :rtype: List[int]
        """
        posts = set()
        for tweet_id in self.tweet_map[userId]:
            posts.add(tweet_id)
        
        for followee_id in self.follow_map[userId]:
            for tweet_id in self.tweet_map[followee_id]:
                posts.add(tweet_id)
        return sorted(list(posts), key=lambda x: self.true_id_map[x], reverse=True)[:10]
        

    def follow(self, followerId, followeeId):
        """
        Follower follows a followee. If the operation is invalid, it should be a no-op.
        :type followerId: int
        :type followeeId: int
        :rtype: void
        """
        self.follow_map[followerId].add(followeeId)
        

    def unfollow(self, followerId, followeeId):
        """
        Follower unfollows a followee. If the operation is invalid, it should be a no-op.
        :type followerId: int
        :type followeeId: int
        :rtype: void
        """
        self.follow_map[followerId].discard(followeeId)
        


# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)