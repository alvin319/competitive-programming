from collections import defaultdict

class Solution:
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        d = defaultdict(int)
        
        for c in s:
            d[c] += 1
        
        s = set()
        ans = 0
        found = False
        
        for k in sorted(d.keys(), reverse=True, key=lambda x: d[x]):
            if d[k] % 2 == 1 and not found:
                ans += d[k]
                found = True
            elif d[k] % 2 == 1 and found:
                ans += d[k] - 1
            elif d[k] % 2 == 0:
                ans += d[k]
        
        return ans