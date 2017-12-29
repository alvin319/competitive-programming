class Solution:
    
    def uniquePathsWithObstacles(self, starting):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        
        total = [[0 for i in range(len(starting[0]))] for j in range(len(starting))]
        total[0][0] = 1 if starting[0][0] == 0 else 0
        
        for i in range(1, len(starting)):
            if starting[i][0] == 0:
                total[i][0] = total[i - 1][0]
        
        for i in range(1, len(starting[0])):
            if starting[0][i] == 0:
                total[0][i] = total[0][i - 1]
                        
        for i in range(1, len(starting)):
            for j in range(1, len(starting[i])):
                if starting[i][j] == 0:
                    first = 0 if starting[i - 1][j] == 1 else total[i - 1][j]
                    second = 0 if starting[i][j - 1] == 1 else total[i][j - 1]
                    total[i][j] = first + second
                else:
                    total[i][j] = 0
        
            
        return 0 if starting[-1][-1] == 1 else total[-1][-1]
