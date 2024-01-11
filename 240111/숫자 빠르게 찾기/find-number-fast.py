def bs(num):
    start = 0
    end = N-1
    while start <= end:
        mid = (start + end) // 2
        if number[mid] == num:
            return mid + 1
        if number[mid] > num:
            end = mid - 1
        else:
            start = mid + 1
    return -1

N, M = map(int, input().split())
number = list(map(int, input().split()))
for _ in range(M):
    num = int(input())
    print(bs(num))