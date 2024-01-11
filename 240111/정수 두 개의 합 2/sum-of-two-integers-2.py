N, K = map(int, input().split())
number = []
for _ in range(N):
    number.append(int(input()))
# end input

number.sort()
answer = 0
for head in range(N-1):
    for tail in range(head + 1, N):
        acc = number[head] + number[tail]
        if acc <= K:
            answer += 1
        else:
            break
    
print(answer)