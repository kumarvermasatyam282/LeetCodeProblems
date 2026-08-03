class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        c = int(a,2)
        d = int(b,2)
        e = c+d
        f = bin(e)
        return f[2:]








        