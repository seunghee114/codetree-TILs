def explode(bomb, N, M):
    temp = []
    prev = bomb[0]
    cnt = 1
    for i in range(1, N):
        if bomb[i] == prev:
            cnt+=1
        else:
            if cnt < M:
                temp += [prev for _ in range(cnt)]
            prev = bomb[i]
            cnt = 1
    if cnt < M:
        temp += [prev for _ in range(cnt)]
    return temp

N, M = map(int, input().split())

bomb = []
for _ in range(N):
    bomb.append(int(input()))
# end input

while True:
    prev = len(bomb)
    bomb = explode(bomb, prev, M)
    after = len(bomb)
    if prev == after or after == 0:
        break
print(len(bomb))
for b in bomb:
    print(b)