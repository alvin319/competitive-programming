class Solution(object):
    def findComplement(self, num):
        """
        :type num: int
        :rtype: int
        """
        ans = []
        for v in str(bin(num))[2:]:
            if v == '1':
                ans.append(0)
            else:
                ans.append(1)
        index = None
        for i, v in enumerate(ans):
            if v == 0:
                index = i
            else:
                break
        if index is None:
            index = 0
        return int(''.join([str(s) for s in ans[index:]]), 2)
