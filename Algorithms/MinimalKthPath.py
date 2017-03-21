def factorial(num):
    if num == 0:
        return 1
    total = 1
    for _ in range(1, num + 1):
        total *= _
    return total

def H_bound(H,V):
    if H == 0:
        return 0
    return factorial(V+H-1)//factorial(H-1)//factorial(V)

def grid(inp):
    for line in inp:
        ans = ""
        X, Y, k = map(int, line.split(" "))
        while not (X == 0 and Y == 0):
            H_threshold = H_bound(X,Y)
            if k >= H_threshold:
                k -= H_threshold
                Y -= 1
                ans += 'V'
            else:
                X -= 1
                ans += 'H'
        print(ans)
        
grid(["3 2 2", "2 2 3"])
