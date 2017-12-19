from collections import deque

class Solution(object):
    def dailyTemperatures(self, temp):
        """
        :type temp: List[int]
        :rtype: List[int]
        """
        stack = deque()
        ans = deque()
        
        for i in range(len(temp) - 1, -1, -1):
            if i == len(temp) - 1:
                ans.appendleft(0)
            else:
                peek, index = stack[-1]
                if peek > temp[i]:
                    ans.appendleft(index - i)
                else:
                    added = False
                    
                    while stack:
                        peek, index = stack[-1]
                        
                        if peek > temp[i]:
                            ans.appendleft(index - i)
                            added = True
                            break
                        else:
                            stack.pop()
                    
                    if not added:
                        ans.appendleft(0)
            
            stack.append((temp[i], i))
        
        return list(ans)
