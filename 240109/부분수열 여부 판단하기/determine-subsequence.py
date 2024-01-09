N, M = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

def is_subarr():
    a = 0
    for b in range(M):
        while a < N and A[a] != B[b]:
            a += 1
        if a == N:
            return False
        else:
            a+=1
    return True

print("Yes" if is_subarr() else "No")