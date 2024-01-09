N, S = map(int, input().split())
number = list(map(int, input().split()))

start = 0
end = 0
acc = 0
answer = 0

while start <= end and end < N:
    acc += number[end]
    if acc == S:
        answer+=1
    elif acc > S:
        while start <= end and acc > S:
            acc -= number[start]
            if acc == S:
                answer+=1
            start += 1
    end+=1
print(answer)