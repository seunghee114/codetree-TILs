# [배낭 채우기 ](https://www.codetree.ai/missions/2/problems/knapsack)

|유형|문제 경험치|난이도|
|---|---|---|
|[Intermediate Low / DP I / 아이템을 적절히 고르는 문제](https://www.codetree.ai/missions?missionId=2)|90xp|![보통][medium]|


## 3차원 DP, 2차원 DP, 1차원 DP
### 3차원 DP : knapsack_v1
dp[ i ][ j ][ 0 ] : i번 아이템까지 고려했고 i번 아이템을 사용했고, 무게가 j일 때 최대 가치
dp[ i ][ j ][ 1 ] : i번 아이템까지 고려했고 i번 아이템을 사용 안했고, 무게가 j일 때 최대 가치

### 2차원 DP : knapsack_v2
dp[ i ][ j ] : i번 아이템까지 고려했고 무게가 j일 때 최대 가치

### 1차원 DP : knapsack
dp[ j ] : 무게가 j일 때 최대 가치
아이템을 고려하는 것이 사라졌기 때문에 각 아이템 별로 dp 배열을 채워나갈 때, 무게 M부터 0까지로 채워나가야 아이템을 중복 사용하는 것을 방지할 수 있다.

![image](https://github.com/seunghee114/codetree-TILs/assets/43427305/66a8153d-bbbd-41ef-bf6f-8c8a75052384)

위에서부터 순서대로 1차원 DP, 2차원 DP, 3차원 DP



[b5]: https://img.shields.io/badge/Bronze_5-%235D3E31.svg
[b4]: https://img.shields.io/badge/Bronze_4-%235D3E31.svg
[b3]: https://img.shields.io/badge/Bronze_3-%235D3E31.svg
[b2]: https://img.shields.io/badge/Bronze_2-%235D3E31.svg
[b1]: https://img.shields.io/badge/Bronze_1-%235D3E31.svg
[s5]: https://img.shields.io/badge/Silver_5-%23394960.svg
[s4]: https://img.shields.io/badge/Silver_4-%23394960.svg
[s3]: https://img.shields.io/badge/Silver_3-%23394960.svg
[s2]: https://img.shields.io/badge/Silver_2-%23394960.svg
[s1]: https://img.shields.io/badge/Silver_1-%23394960.svg
[g5]: https://img.shields.io/badge/Gold_5-%23FFC433.svg
[g4]: https://img.shields.io/badge/Gold_4-%23FFC433.svg
[g3]: https://img.shields.io/badge/Gold_3-%23FFC433.svg
[g2]: https://img.shields.io/badge/Gold_2-%23FFC433.svg
[g1]: https://img.shields.io/badge/Gold_1-%23FFC433.svg
[p5]: https://img.shields.io/badge/Platinum_5-%2376DDD8.svg
[p4]: https://img.shields.io/badge/Platinum_4-%2376DDD8.svg
[p3]: https://img.shields.io/badge/Platinum_3-%2376DDD8.svg
[p2]: https://img.shields.io/badge/Platinum_2-%2376DDD8.svg
[p1]: https://img.shields.io/badge/Platinum_1-%2376DDD8.svg
[passed]: https://img.shields.io/badge/Passed-%23009D27.svg
[failed]: https://img.shields.io/badge/Failed-%23D24D57.svg
[easy]: https://img.shields.io/badge/쉬움-%235cb85c.svg?for-the-badge
[medium]: https://img.shields.io/badge/보통-%23FFC433.svg?for-the-badge
[hard]: https://img.shields.io/badge/어려움-%23D24D57.svg?for-the-badge
