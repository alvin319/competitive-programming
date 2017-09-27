from collections import defaultdict

class Solution(object):
    def distributeCandies(self, candies):
        """
        :type candies: List[int]
        :rtype: int
        """
        m = defaultdict(int)
        for v in candies:
            m[v] += 1
        total = sum(m[v] for v in m)
        expected = total / 2
        index = 0
        ans = 0
        while index < len(m) and ans != expected:
            ans += 1
            index += 1
        return ans