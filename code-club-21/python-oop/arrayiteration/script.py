def multiply_array_elements(arr, factor):
    multiplied_array = [element * factor for element in arr]
    return multiplied_array

my_array = list(range(100000000))
result = multiply_array_elements(my_array, 2)
