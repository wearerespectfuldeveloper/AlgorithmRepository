### [HackerRank - Modified Karprekar Numbers](https://www.hackerrank.com/challenges/kaprekar-numbers/problem)
- - -
### 문제 요약
임의의 숫자 n 이 주어졌을 때, 숫자의 길이가 d 라고 하자. (ex. n = 15 --> d = 2)
임의의 숫자 n 을 제곱하고, 그 숫자의 길이를 왼쪽과 오른쪽 두 부분으로 나눈다. 제곱 숫자의 오른쪽부터 d 만큼 자른 숫자를 r, 그리고 남은 나머지 왼쪽 부분을 l 이라고 할 때,
n == (l + r) 이면 변형된 카프카 수라고 한다.

> ex ) n = 45, d = 2 일 때, n^2 = 2025 이고, d의 길이만큼 오른쪽부터 나누면 r = 25, l = 20 이다.
> n^2 == l + r 이므로 45는 변형된 카프카 수이다.

input 값으로 p 와 q 가 주어졌을 때, p 부터 q 까지의 숫자들 중에서 변형된 카프카 수를 찾아야한다.
0 < p < q < 100,000

탐색 숫자는 p 값과 q 값도 포함하여 찾는다. 만약 해당 범위의 숫자에서 변형된 카프카 수가 존재하지 않으면 "INVALID RANGE." 를 출력한다.
- - -

반복문을 돌리게 되면 최대 99,999번 반복하게 되므로 연산도중 시간초과가 될 염려가 없다.

다만 마지막 숫자인 99,999를 제곱하게 되면 int 타입에서는 오버플로우가 발생한다. 따라서 제곱을 구할 때는 아래와 같이 long 타입으로 캐스팅을 해주어야 한다.

<pre>
<code>
long square = (long) p * p;
</code>
</pre>



아래는 변형된 카프카 수인지 검사하는 코드이다.
<pre>
<code>
            int d = Integer.toString(p).length();
            long square = (long) p * p;
            String strSquare = Long.toString(square);

            int r = Integer.parseInt(strSquare.substring(strSquare.length() - d));
            int l = (strSquare.length() - d > 0) ?
                    Integer.parseInt(strSquare.substring(0, strSquare.length() - d)) : 0;

            if (p == (l + r)) {
                bw.write(p + " ");
                foundFlag = true;
            }
</code>
</pre>

여기서 l을 구할 때는 substring 의 end 값이 0보다 큰지 삼항연산자를 통해 검사하여 작다면 0을 넣도록 구현하였다.
n이 1인 경우에는 l의 값을 구할 때, substring 의 end 값이 0이 되기 때문에 substring(0, 0) 이므로 아무 값 없이 Integer.parseInt 를 시도하기 때문에 익셉션이 발생하기 때문이다.
