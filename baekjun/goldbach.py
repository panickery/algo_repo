# import time
# start = time.time()

def runGoldbach() :
    inp_cnt = int(input())
    inp_arr, result_arr = [], []
    arr_prime = getPrime()
    for i in range(0, inp_cnt) :
        inp = int(input())
        result_arr.append(getGoldbach(inp, arr_prime))
    printResult(result_arr)

def printResult(arr) : 
    for el in arr :
        print('{} {}'.format(el[0], el[1]))

def getPrime() :
    n = 10000
    a = [False, False] + [True] * (n-1)
    pri_arr = []

    for i in range(2, n+1) :
        if a[i] : 
           pri_arr.append(i) 
           for j in range(2*i, n+1, i) :
              a[j] = False
    return pri_arr

def getGoldbach(number, arr_prime) :
    min_diff = number

    for prime in arr_prime :

        if prime >= number/2 :
            break

        if number - prime in arr_prime and min_diff > abs(number-prime-prime) :
            min_diff = abs(number-prime-prime)
            min_prime = prime

    return [min_prime, number-min_prime] if min_prime < number-min_prime else [number-min_prime, min_prime]

if __name__ == '__main__' :
    runGoldbach()
    # stop = time.time()
    # print("Spent Time :: {}".format(stop-start))