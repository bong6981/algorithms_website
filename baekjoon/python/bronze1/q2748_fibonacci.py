import sys
input = sys.stdin.readline

N = int(input())
fibo = [0] * (N+1)
fibo[1] = 1
for i in range(2, N+1):
    fibo[i] = fibo[i-1] + fibo[i-2]
print(fibo[N])
