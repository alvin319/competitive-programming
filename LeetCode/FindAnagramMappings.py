class Solution(object):
    def anagramMappings(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        d = {}
        for i, v in enumerate(B):
            d[v] = i
        ans = []
        for v in A:
            ans.append(d[v])
        
        return ans