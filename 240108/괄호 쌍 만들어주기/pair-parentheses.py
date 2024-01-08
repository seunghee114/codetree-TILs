a = input()
cnt = [0, 0]
num = [0, 0]    # (의 개수, )의 개수
prev = a[0]
for ch in a:
    if prev == ch:
        num[ord(ch)-ord('(')]+=1
    else:
        cnt[ord(prev) - ord('(')] += num[ord(prev) - ord('(')]-1
        num[ord(prev) - ord('(')] = 0
        prev = ch
        num[ord(prev) - ord('(')] = 1
cnt[ord(prev) - ord('(')] += num[ord(prev) - ord('(')]-1

print(cnt[0] * cnt[1])