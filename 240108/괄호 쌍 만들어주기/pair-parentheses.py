a = input()
value = ord('(')
num = [0, 0]    # (의 개수, )의 개수
prev = a[0]
acc = []
cnt = [(0, 0)]
for ch in a:
    ch_idx = ord(ch)-value
    if prev == ch:
        num[ch_idx]+=1
    else:
        prev_idx = ord(prev) - value
        if num[prev_idx] > 1:
            if prev == '(':
                acc.append(num[prev_idx]-1)
            else:
                acc.append(-(num[prev_idx]-1))
        num[prev_idx] = 0
        prev = ch
        num[ch_idx] = 1

prev_idx = ord(prev) - value
if num[prev_idx] > 1:
    if prev == '(':
        acc.append(num[prev_idx]-1)
    else:
        acc.append(-(num[prev_idx]-1))      

answer = 0
neg = 0
for i in range(len(acc)-1, -1, -1):
    if acc[i] > 0:
        answer += acc[i] * neg
    else:
        neg += -acc[i]

print(answer)