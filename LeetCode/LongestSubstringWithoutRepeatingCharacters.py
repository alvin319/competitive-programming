class Solution(object):
    def lengthOfLongestSubstring(self, line):
        """
        :type s: str
        :rtype: int
        """
        start_index = 0
        end_index = 0
        best = 0
        m = {}
        if line == '':
            return 0
        for i, c in enumerate(line):
            if c not in m:
                end_index = i
                m[c] = i
            else:
                old_index = m[c]
                start_index = old_index + 1
                for k, v in m.items():
                    if v < old_index:
                        del m[k]
                m[c] = i
            best = max(best, end_index - start_index + 1)
        
        return max(best, end_index - start_index + 1)