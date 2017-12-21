class Solution(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        total = 0
        multiplier = 0
        for i in range(len(s) - 1, -1, -1):
            total += 26 ** multiplier * (ord(s[i]) - 64)
            multiplier += 1
        return total
