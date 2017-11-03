class Solution:
    def valid(self, r, c, max_r, max_c):
        return r >= 0 and r < max_r and c >= 0 and c < max_c
    
    def countBattleships(self, board):
        """
        :type board: List[List[str]]
        :rtype: int
        """
        total = 0
        max_r = len(board)
        max_c = len(board[0])
        
        for i, row in enumerate(board):
            for j, piece in enumerate(row):
                if piece == 'X':
                    top_r, top_c = i - 1, j
                    left_r, left_c = i, j - 1
                    added = True
                    if (self.valid(top_r, top_c, max_r, max_c) and board[top_r][top_c] == 'X') or (self.valid(left_r, left_c, max_r, max_c) and board[left_r][left_c] == 'X'):
                        added = False
                    
                    if added:
                        total += 1
        
        return total
