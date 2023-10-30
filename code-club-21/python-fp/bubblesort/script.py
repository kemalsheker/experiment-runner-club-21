import sys

sys.setrecursionlimit(10000)  # set the recursion limit to 10000

def swap(arr, i, j):
    return arr[:i] + [arr[j]] + [arr[i]] + arr[j+1:]

def inner_bubble_sort(arr, i, swapped):
    if i == len(arr) - 1:
        return arr, swapped
    elif arr[i] > arr[i+1]:
        swapped_arr = swap(arr, i, i+1)
        return inner_bubble_sort(swapped_arr, i + 1, True)
    else:
        return inner_bubble_sort(arr, i + 1, swapped)

def bubble_sort_recursive(arr, pass_num):
    if pass_num == 0:
        return arr
    else:
        arr_after_pass, swapped = inner_bubble_sort(arr, 0, False)
        if not swapped:
            return arr_after_pass
        else:
            return bubble_sort_recursive(arr_after_pass, pass_num - 1)

def bubble_sort(arr):
    return bubble_sort_recursive(arr, len(arr))

if __name__ == "__main__":
    for i in range(10):
        input_list = list(range(1000, -1, -1))  # Creating a list in descending order from 1000 to 0.
        sorted_array = bubble_sort(input_list)
