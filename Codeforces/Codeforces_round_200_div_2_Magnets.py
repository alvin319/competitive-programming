num = int(input())

answer = 0
last = 7

for i in range(num):
    mag = int(input())
    if mag != last:
        answer += 1
        last = mag
        
print(answer)