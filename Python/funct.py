<<<<<<< HEAD
def add(a,b):
    if(a>b):
        return a+b;
    else:
        return a-b;

print(add(4,5))
=======
def min_operations_to_equal_elements(arr):
    from collections import defaultdict
    n = len(arr)
    freq = defaultdict(list)

    for num in arr:
        steps = 0
        temp = num
        while temp > 0:
            freq[temp].append(steps)
            temp //= 2
            steps += 1

    min_ops = float('inf')
    for key in freq:
        if len(freq[key]) >= n:
            freq[key].sort()
            min_ops = min(min_ops, sum(freq[key][:n]))

    return min_ops


# Taking input from user
n = int(input("Enter array size: "))
arr = list(map(int, input("Enter array elements: ").split()))

result = min_operations_to_equal_elements(arr)
print("Minimum operations to make all elements equal:", result)
>>>>>>> ea75e2f (Adding Advance DSA folder)
