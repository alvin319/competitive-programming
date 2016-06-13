from functools import reduce

def prime_factors(n):
	current_set = set()
	while n % 2 == 0:
		current_set.add(2)
		n /= 2

	for i in range(3, int(n ** 0.5) + 1, 2):
		while n % i == 0:
			current_set.add(i)
			n /= i

	if n > 2:
		current_set.add(n)

	return current_set

n = int(input())
current_set = prime_factors(n)
total = 1

for i in current_set:
	total *= i
	
print(int(total))