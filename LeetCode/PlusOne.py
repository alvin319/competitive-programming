class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        if len(digits) == 1 and digits[0] == 0:
            return [1]
        adder = 1
        for i in range(len(digits) - 1, -1, -1):
            digits[i] += adder
            adder = digits[i] / 10
            digits[i] %= 10
        if adder > 0:
            digits.insert(0, adder)
        return digits
        