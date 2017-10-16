class Solution(object):
    def hammingDistance(self, x, y):
        """
        :type x: int
        :type y: int
        :rtype: int
        """
        x_b = '{:b}'.format(x)
        y_b = '{:b}'.format(y)
        max_l = max(len(x_b), len(y_b))
        for _ in range(max_l - len(x_b)):
            x_b = '0' + x_b
        for _ in range(max_l - len(y_b)):
            y_b = '0' + y_b
        
        ans = 0
        for i in range(len(x_b)):
            if x_b[i] != y_b[i]:
                ans += 1
        
        return ans
        