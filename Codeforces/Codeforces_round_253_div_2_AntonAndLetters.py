s = input()
s = list(s)

answer = set()

for i in s:
    if i.isalpha():
        answer.add(i)
        
print(len(answer))