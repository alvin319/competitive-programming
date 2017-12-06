class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        if digits == ''
            return []
        answer = []
        self.helper(digits, 0, '', answer)
        return answer
    
    def helper(self, digits, index, current, answer):
        m = {
                '1': ['*'],
                '2': ['a', 'b', 'c'],
                '3': ['d', 'e', 'f'],
                '4': ['g', 'h', 'i'],
                '5': ['j', 'k', 'l'],
                '6': ['m', 'n', 'o'],
                '7': ['p', 'q', 'r', 's'],
                '8': ['t', 'u', 'v'],
                '9': ['w', 'x', 'y', 'z'],
                '0': [' ']
        }
        if index == len(digits):
            answer.append(current)
        else:
            for c in m[digits[index]]:
                self.helper(digits, index + 1, current + c, answer)