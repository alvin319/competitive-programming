from collections import deque

class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        q = deque()
        q.append((n, n, 0, 0, ''))
        answer = set()
        
        while q:
            left_remain, right_remain, left_used, right_used, current = q.popleft()
            if len(current) == n * 2:
                answer.add(current)
            else:
                if left_used > 0 and right_remain > 0 and left_used > right_used:
                    q.append((left_remain, right_remain - 1, left_used, right_used + 1, current + ')'))
                if left_remain > 0 and right_used == 0:
                    q.append((left_remain - 1, right_remain, left_used + 1, right_used, current + '('))
                if left_remain > 0 and right_remain > 0:
                    q.append((left_remain - 1, right_remain, left_used + 1, right_used, current + '('))
        
        return sorted(list(answer))
