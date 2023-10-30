def merge(left, right):
    if not left:
        return right
    elif not right:
        return left
    elif left[0] < right[0]:
        return [left[0]] + merge(left[1:], right)
    else:
        return [right[0]] + merge(left, right[1:])

def merge_sort(arr):
    if len(arr) <= 1:
        return arr
    
    mid = len(arr) // 2
    left, right = arr[:mid], arr[mid:]
    
    return merge(merge_sort(left), merge_sort(right))

if __name__ == "__main__":
    for i in range(1000):
        input_list = list(range(1000, -1, -1))  # Creating a list in descending order from 1000 to 0.
        sorted_list = merge_sort(input_list)
