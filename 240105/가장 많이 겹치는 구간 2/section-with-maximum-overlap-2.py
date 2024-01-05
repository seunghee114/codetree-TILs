import heapq
N = int(input())
PQ = []
for i in range(N):
    a, b = map(int, input().split())
    heapq.heappush(PQ, (a, 1))
    heapq.heappush(PQ, (b, -1))
answer = 0
acc = 0
while PQ:
    tp = heapq.heappop(PQ)
    acc += tp[1]
    answer = max(answer, acc)
print(answer)