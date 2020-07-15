a = [False, False] + [True] * 100
pri_arr = []

n = 100
print(a)

for i in range(2, n) :
    if a[i] : 
        pri_arr.append(i) 
        for j in range(2*i, n, i) :
            print(j)
            a[j] = False

print(pri_arr)


