# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def eraseOverlapIntervals(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: int
        """
        intervals = sorted(intervals, key=lambda x: (x.end, x.start))
        current_end = None
        answer = 0
        for x in intervals:
            start, end = x.start, x.end
            if current_end is None:
                current_end = end
            else:
                if current_end <= start and current_end <= end:
                    current_end = end
                else:
                    answer += 1
        
        return answer
