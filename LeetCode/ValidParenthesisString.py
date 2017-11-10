from collections import deque

class Solution(object):
    def checkValidString(self, s):
        """
        :type s: str
        :rtype: bool
        """
        queue = deque()
        for c in s:
            if c == '(':
                queue.append(c)
            elif c == ')':
                try:
                    x = queue.pop()
                    if x == '(': # No need to add ( back because we found a matching pair
                        pass
                    elif x == '*': # Check to see if we need to consume this
                        l = []
                        persist = False
                        while len(queue) > 0:
                            y = queue.pop()
                            if y == '(': # Found a pair, no need to be consumed
                                for k in reversed(l): # Re-adding everything back
                                    queue.append(k)
                                persist = True
                                break
                            elif y == ')' or y == '*':
                                l.append(y)
                        
                        if not persist: # Needs to be consumed
                            for k in reversed(l): # Re-adding everything back
                                queue.append(k)
                        else:
                            queue.append(x)
                    else:
                        queue.append(x)
                except:
                    queue.append(c)
            else:
                queue.append(c)
        
        has_star = 0
        second_queue = deque()
        
        while len(queue) > 0:
            x = queue.pop()
            if x == '*':
                has_star += 1
                second_queue.append(x)
            elif x == '(':
                if has_star > 0:
                    second_queue.pop()
                    has_star -= 1
                else:
                    second_queue.append(x)
            else:
                second_queue.append(x)
        
        only_stars = True
        for c in second_queue:
            if c != '*':
                only_stars = False
                break
        
        return only_stars
