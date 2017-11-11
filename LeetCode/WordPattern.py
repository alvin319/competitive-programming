class Solution(object):
    def wordPattern(self, pattern, str1):
        """
        :type pattern: str
        :type str: str1
        :rtype: bool
        """
        tokens = str1.split(' ')
        mapping = {}
        reverse_mapping = {}
        if len(tokens) != len(pattern):
            return False
        try:
            for i, c in enumerate(pattern):
                if c not in mapping and tokens[i] not in reverse_mapping:
                    mapping[c] = tokens[i]
                    reverse_mapping[tokens[i]] = c
                elif mapping[c] != tokens[i] or reverse_mapping[tokens[i]] != c:
                    return False
            return True
        except:
            return False
