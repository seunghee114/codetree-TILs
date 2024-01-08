N, K = map(int, input().split())
bomb = []
for i in range(N):
    bomb.append(int(input()))
# end input

maxValue = max(bomb)
answer = -1
# idx[i] : 현재 위치의 왼쪽에서 가장 가까운 i번 폭탄의 위치
idx = [-1 for _ in range(maxValue+1)]
for i in range(N):
    if idx[bomb[i]] != -1:
        dist = i - idx[bomb[i]]
        if dist <= K:
            answer = max(answer, bomb[i])
    idx[bomb[i]] = i
    
print(answer)