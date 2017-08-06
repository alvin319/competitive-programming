class Solution(object):
    def findTheDifference(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        s = sorted(s)
        t = sorted(t)
        for i, _ in enumerate(t):
            if i >= len(s):
                return str(_)
            elif _ != s[i]:
                return str(_)