class Solution(object):
    def findWords(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        m = {
            'q': 0,
            'w': 0,
            'e': 0,
            'r': 0,
            't': 0,
            'y': 0,
            'u': 0,
            'i': 0,
            'o': 0,
            'p': 0,
            'a': 1,
            's': 1,
            'd': 1,
            'f': 1,
            'g': 1,
            'h': 1,
            'j': 1,
            'k': 1,
            'l': 1,
            'z': 2,
            'x': 2,
            'c': 2,
            'v': 2,
            'b': 2,
            'n': 2,
            'm': 2
        }
        current = -1
        ans = []
        
        for v in words:
            orig = v
            v = v.lower()
            current = m[v[0]]
            failed = False
            for x in v:
                if m[x] != current:
                    failed = True
                    break
            
            if not failed:
                ans.append(orig)
        
        return ans
