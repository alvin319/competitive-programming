class Solution(object):
    def numJewelsInStones(self, J, S):
        """
        :type J: str
        :type S: str
        :rtype: int
        """
        s = set([x for x in J])
        v = 0
        for c in S:
            if c in s:
                v += 1
        
        return v
