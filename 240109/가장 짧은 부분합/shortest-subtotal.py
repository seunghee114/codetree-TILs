N, S = map(int, input().split())
number = list(map(int, input().split()))

start = 0
end = 0
acc = 0
answer = 100001
while start <= end and end < N:
    acc += number[end]
    if acc >= S:
        while start <= end and acc >= S:
            answer = min(answer, end - start + 1)
            acc -= number[start]
            start+=1
    end+=1
print(answer if answer != 100001 else -1)