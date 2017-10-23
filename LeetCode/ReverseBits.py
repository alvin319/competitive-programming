class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        if n == 0:
            return 0
        reverse_string = str('{:b}'.format(n))
        for _ in range(32 - len(reverse_string)):
            reverse_string = '0' + reverse_string
        reverse_string = ''.join(reversed(reverse_string))
        return int(reverse_string, 2)