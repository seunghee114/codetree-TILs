def get_bead(N, Board):
    beads = []
    for i in range(N):
        for j in range(N):
            if len(Board[i][j]) == 0 or len(Board[i][j]) > 1:
                continue
            beads.append([i, j, Board[i][j][0]])
    return beads
def notRange(i, j, N):
    return i < 0 or j < 0 or i >= N or j >= N;
def main_process(N, Board):
    di = [-1, 0, 1, 0]
    dj = [0, -1, 0, 1]
    for _ in range(N):
        beads = get_bead(N, Board)
        Board = [[[] for _ in range(N)] for _ in range(N)]
        for bead in beads:
            ni = bead[0] + di[bead[2]]
            nj = bead[1] + dj[bead[2]]
            if notRange(ni, nj, N):
                d = (bead[2] + 2) % 4
                Board[bead[0]][bead[1]].append(d)
                continue
            Board[ni][nj].append(bead[2])
    return Board
def in_process():
    N, M = map(int, input().split())
    Board = [[[] for _ in range(N)] for _ in range(N)]
    for _ in range(M):
        i, j, d = map(str, input().split())
        Board[int(i)-1][int(j)-1].append("ULDR".index(d))
    return N, Board
def process():
    N, Board = in_process()
    while True:
        before = len(get_bead(N, Board))
        Board = main_process(N, Board)
        after = len(get_bead(N, Board))
        if before == after:
            return after
def main():
    T = int(input())
    for _ in range(T):
        print(process())

main()