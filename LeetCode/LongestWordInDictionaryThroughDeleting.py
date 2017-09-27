class Solution(object):
    def is_valid(self, s, word):
        s_index = 0
        w_index = 0
        while s_index < len(s) and w_index < len(word):
            if s[s_index] == word[w_index]:
                w_index += 1
            s_index += 1
        return w_index == len(word)
    
    def findLongestWord(self, s, d):
        """
        :type s: str
        :type d: List[str]
        :rtype: str
        """
        count = 0
        words = []
        for w in d:
            valid = self.is_valid(s, w)
            if valid:
                if len(w) > count:
                    count = len(w)
                    words = [w]
                elif len(w) == count:
                    words.append(w)
        if len(words) == 0:
            return ''
        else:
            return sorted(words)[0]