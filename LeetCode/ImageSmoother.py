import math

class Solution(object):
    def imageSmoother(self, M):
        """
        :type M: List[List[int]]
        :rtype: List[List[int]]
        """
        new_M = []
        for i in range(len(M)):
            new_row = []
            for j in range(len(M[i])):
                new_row.append(self.get_surround(i, j, M))
            new_M.append(new_row)
        
        return new_M
    
    def is_valid(self, x, y, M):
        return x >= 0 and x < len(M) and y >= 0 and y < len(M[x])
    
    def get_surround(self, x, y, M):
        dx = [0, 0, 0, 1, -1, 1, 1, -1, -1]
        dy = [0, 1, -1, 0, 0, -1, 1, 1, -1]
        
        count = 0
        total = 0
        
        for i, _ in enumerate(dx):
            new_x = x + dx[i]
            new_y = y + dy[i]
            
            if self.is_valid(new_x, new_y, M):
                total += M[new_x][new_y]
                count += 1
        
        return int(math.floor(total / count))