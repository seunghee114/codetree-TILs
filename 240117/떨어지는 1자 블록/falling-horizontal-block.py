def isAvailable(Board, I, K, M):
    for j in range(M):
        if Board[I][j + K] == 1:
            return False
    return True

N, M, K = map(int, input().split())
K-= 1
Board = [list(map(int, input().split())) for _ in range(N)]
# end input
idx = -1
for i in range(N):
    if isAvailable(Board, i, K, M):
        idx = i
for j in range(M):
    Board[idx][j + K] = 1
for i in range(N):
    print(" ".join(map(str, Board[i])))