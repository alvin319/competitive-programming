from collections import deque

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.q = deque()
        

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        if len(self.q) == 0:
            self.q.append((x, x))
        else:
            before, before_min = self.q[-1]
            self.q.append((x, min(before_min, x)))

    def pop(self):
        """
        :rtype: void
        """
        self.q.pop()
        

    def top(self):
        """
        :rtype: int
        """
        return self.q[-1][0]
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.q[-1][1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
