N, K = map(int, input().split())
candy = [0 for _ in range(1000001)]
for _ in range(N):
    cnt, idx = map(int, input().split())
    candy[idx] += cnt
# end input

answer = 0
for i in range(2*K + 1):
    answer += candy[i]

head = 0
tail = 2 * K
acc = answer
while True:
    acc -= candy[head] 
    head += 1
    tail += 1
    if tail >= 1000001:
        break
    acc += candy[tail]
    answer = max(answer, acc)
print(answer)