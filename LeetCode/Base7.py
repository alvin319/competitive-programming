import string

class Solution:
    def int2base(self, x, base, digs):
        if x < 0:
            sign = -1
        elif x == 0:
            return digs[0]
        else:
            sign = 1

        x *= sign
        digits = []

        while x:
            digits.append(digs[x % base])
            x /= base

        if sign < 0:
            digits.append('-')
            
        digits.reverse()
        return ''.join(digits)

    def convertToBase7(self, num):
        """
        :type num: int
        :rtype: str
        """
        digs = string.digits + string.letters
        
        return str(self.int2base(num, 7, digs))
