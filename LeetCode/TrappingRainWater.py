class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        forward = []
        backward = []
        current = None
        for v in height:
            if current is None:
                current = v
                forward.append(current)
            else:
                current = max(current, v)
                forward.append(current)
        
        current = None
        
        for i in range(len(height) - 1, -1, -1):
            if current is None:
                current = height[i]
                backward.insert(0, current)
            else:
                current = max(current, height[i])
                backward.insert(0, current)
        
        total = 0
        
        for i in range(len(forward)):
            total += min(forward[i], backward[i]) - height[i]
        
        return total
