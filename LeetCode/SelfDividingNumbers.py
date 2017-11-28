class Solution(object):
    def selfDividingNumbers(self, left, right):
        """
        :type left: int
        :type right: int
        :rtype: List[int]
        """
        ans = []
        
        for i in range(left, right + 1):
            converted = str(i)
            valid = True
            for v in converted:
                v = int(v)
                if v == 0:
                    valid = False
                    break
                if i % v != 0:
                    valid = False
                    break
            if valid:
                ans.append(i)
        
        return ans
        