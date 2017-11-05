class Solution:
    def findDiagonalOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        n = len(matrix)
        if n == 0:
            return []
        m = len(matrix[0])
        answer = []
        
        for i in range(m):
            digits = self.getDiagonal(matrix, 0, i)
            if i % 2 == 0:
                answer += digits[::-1]
            else:
                answer += digits
        
        for i in range(1, n):
            digits = self.getDiagonal(matrix, i, len(matrix[i]) - 1)
            if m % 2 == 1:
                if i % 2 == 0:
                    answer += digits[::-1]
                else:
                    answer += digits
            else:
                if i % 2 == 0:
                    answer += digits
                else:
                    answer += digits[::-1]
        
        return answer
    
    def valid(self, matrix, r, c):
        return r >= 0 and r < len(matrix) and c >= 0 and c < len(matrix[r])
        
    def getDiagonal(self, matrix, r, c):
        current_r = r
        current_c = c
        result = []
        
        while self.valid(matrix, current_r, current_c):
            result.append(matrix[current_r][current_c])
            current_r += 1
            current_c -= 1
        
        return result
