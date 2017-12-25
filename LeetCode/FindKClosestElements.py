class Solution:
    def findClosestElements(self, array, k, val):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        answer = []
        for i, v in enumerate(array):
            answer.append((abs(v - val), i))
        answer = sorted(answer, key=lambda x: (x[0] - val, x[0]))
        return sorted([array[x[1]] for x in answer][:k])
