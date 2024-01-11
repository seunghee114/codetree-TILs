N, K = map(int, input().split())
number = []
for _ in range(N):
    number.append(int(input()))
# end input

number.sort()
head = 0
tail = 1
answer = 0
while head < tail:
    acc = number[head] + number[tail]
    if acc <= K:
        answer += 1
    if tail == N-1:
        head += 1
    else:
        tail += 1
print(answer)