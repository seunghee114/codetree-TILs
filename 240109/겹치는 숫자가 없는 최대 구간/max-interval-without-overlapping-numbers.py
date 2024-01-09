N = int(input())
number = list(map(int, input().split()))

chk = set()
start = 0
end = 0
answer = 0
while start <= end and end < N:
    if number[end] in chk:
        while True:
            chk.remove(number[start])
            if number[start] == number[end]:
                start+=1
                break
            start+=1
    chk.add(number[end])
    answer = max(answer, end - start + 1)
    end+=1

print(answer)