# Define a function to multiply an element by a factor
def multiply_element(element, factor):
    return element * factor

# Create an array of integers
my_array = list(range(100000000))


# Use the map function to multiply each element by the factor
result_array = list(map(lambda x: multiply_element(x, 2), my_array))
