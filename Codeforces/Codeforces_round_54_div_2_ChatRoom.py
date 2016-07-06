current_s = input()

array = ['h', 'e', 'l', 'l', 'o']

index = 0

for i in range(len(current_s)):
	if current_s[i] == array[index]:
		index += 1
	if index == len(array):
		print("YES")
		quit()

print("NO")