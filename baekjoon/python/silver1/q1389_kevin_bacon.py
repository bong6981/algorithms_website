# https://www.acmicpc.net/problem/1389
import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
graph = [[] for _ in range(N+1)]

for _ in range(M):
    A, B = map(int, input().rstrip().split())
    graph[A].append(B)
    graph[B].append(A)



def find(start):
    q = deque()
    q.append(start)
    distance = [5001] * (N+1) 
    distance[start] = 0

    while q:
        now = q.popleft()
        for des in graph[now]:
            if distance[des] == 5001:
                distance[des] = distance[now] + 1
                q.append(des)
    
    ret = 0
    for i in range(1, N+1):
        ret += distance[i]
    return ret

        
kevin = [0] * (N+1)
for i in range(1, N+1):
    kevin[i] = find(i)

ans = int(1e9)
p = 0
for i in range(1, N+1):
    if kevin[i] < ans:
        p = i
        ans = kevin[i]

print(p)
