N, K = map(int, input().split())
number = []
for _ in range(N):
    number.append(int(input()))
# end input

number.sort()
answer = 0
tail = N-1
for head in range(N-1):
    while tail != 0 and number[head] + number[tail] > K:
        tail -= 1
    if head >= tail:
        break
    answer += tail - head
print(answer)