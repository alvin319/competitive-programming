from collections import defaultdict

class Solution(object):
    def findRestaurant(self, list1, list2):
        """
        :type list1: List[str]
        :type list2: List[str]
        :rtype: List[str]
        """
        m1 = {word: i for i, word in enumerate(list1)}
        m2 = {word: i for i, word in enumerate(list2)}
        total = defaultdict(list)
        
        for word in list1:
            if word in m2:
                total[m1[word] + m2[word]].append(word)
        
        try:
            min_answer = sorted(total.keys())[0]
            return total[min_answer]
        except:
            return []
