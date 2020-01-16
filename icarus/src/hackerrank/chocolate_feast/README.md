### [HackerRank - Chocolate Feast](https://www.hackerrank.com/challenges/chocolate-feast/problem)
- - -
### 문제 요약
초콜릿 가게에서 행사를 하고 있다. c 가격의 초콜릿을 구매하고 나온 포장지를 m 개 가져오면 새로운 초콜릿으로 교환해준다.릿
 Bobby 가 n 원을 가지고 있을 때, 얻을 수 있는 최대 초콜릿이 몇 개인지 구하여라.

입력 <br />
t -> 테스트 케이스 <br />
n -> Bobby 가 가지고 있는 금액 <br />
c -> 초콜릿의 개당 가격 <br />
m -> 초콜릿을 교환할 때 필요한 포장지 개수
- - -
접근 방법
1. 우선 현재 가지고 있는 모든 돈으로 초콜릿을 구매한 후에 생각해보자.
2. 초콜릿을 구매한만큼 포장지가 1개씩 생기므로 wrapper 변수에 더한다.
3. 이제부터는 wrapper 가 화폐, m 은 초콜릿의 가격 역할을 한다.
4. wrapper 로 m 가격만큼 초콜릿을 구매하여 wrapper 를 차감하되, 초콜릿을 구매한 만큼 다시 wrapper 가 생긴다는 점을 유의한다.