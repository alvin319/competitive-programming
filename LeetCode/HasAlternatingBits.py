class Solution(object):
    def hasAlternatingBits(self, n):
        """
        :type n: int
        :rtype: bool
        """
        s = ''.join(bin(n))[2:]
        good = True
        current = None
        
        for v in s:
            if current is None:
                current = v
            elif current == v:
                good = False
                break
            else:
                current = v
        
        return good
