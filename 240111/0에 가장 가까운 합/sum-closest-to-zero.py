N = int(input())
number = list(map(int, input().split()))
number.sort()
start = 0
end = N -1
answer = int(1e9)
while start < end:
    acc = number[end]+number[start]
    answer = min(answer, abs(acc))
    if number[start] < 0 and number[end] < 0:   # (-, -)
        start += 1
    elif number[start] >= 0 and number[end] >= 0:   # (0+, 0+)
        end -= 1
    else:
        if acc == 0:
            break
        if acc > 0:
            end -= 1
        else:
            start += 1

print(answer)