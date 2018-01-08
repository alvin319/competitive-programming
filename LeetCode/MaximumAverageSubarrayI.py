class Solution:
    def isPerfectSquare(self, num):
        """
        :type num: int
        :rtype: bool
        """
        base = 0
        while True:
            if base ** 2 == num:
                return True
            if base ** 2 > num:
                break
            base += 1
        return False
