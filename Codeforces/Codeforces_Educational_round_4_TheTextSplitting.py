def subset_sum(numbers, target, string, partial=[]):
    s = sum(partial)
    if s == target:
        index = 0
        print(len(partial))
        for x in partial:
            print(string[index:index+x])
            index = index + x
        exit(0)

    if s >= target:
        return

    for i in range(len(numbers)):
        n = numbers[i]
        remaining = numbers[i:]
        subset_sum(remaining, target, string, partial + [n]) 

n, p, q = map(int, input().split())
string = input()
subset_sum([p, q], n, string)
print("-1")