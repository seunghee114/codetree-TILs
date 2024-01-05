import heapq
N, K = map(int, input().split())
PQ = []
start = 1
for i in range(N):
    op = input()
    a = int(op[0])
    d = op[2]
    if d == 'R':
        end = start + a
        heapq.heappush(PQ, (start, 1))
        heapq.heappush(PQ, (end, -1))
        start = end
    elif d == 'L':
        end = start
        start = end - a
        heapq.heappush(PQ, (start, 1))
        heapq.heappush(PQ, (end, -1))
        
answer = 0
acc = 1
prev = heapq.heappop(PQ)[0]
chk = K == 1 if True else False
while PQ:
    pop = heapq.heappop(PQ)
    acc += pop[1]
    if acc >= K:
        if not chk:
            chk = True
            prev = pop[0]
    else:
        if chk:
            answer += abs(prev - pop[0])
            chk = False
print(answer)