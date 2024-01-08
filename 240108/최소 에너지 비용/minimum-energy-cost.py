N = int(input())
move = list(map(int, input().split()))
charge = list(map(int, input().split()))

# charge[i] : 0~i까지 가장 작은 수
num = charge[0]
for i in range(1, N):
    if charge[i] > num:
        charge[i] = num
    else:
        num = charge[i]

answer = 0
for i in range(N-1):
    answer += move[i] * charge[i]
print(answer)