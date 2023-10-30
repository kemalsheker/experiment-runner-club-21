import concurrent.futures
from matrices import a, b

from functional import seq

# Function to compute matrix element
def compute_element(A_row, B_col):
    return sum(a * b for a, b in zip(A_row, B_col))

# Function to extract a column from a matrix
def get_col(matrix, j):
    return [row[j] for row in matrix]

# Function to multiply two matrices using PyFunctional
def pyfunctional_matrix_multiply(A, B):
    num_rows_A, num_cols_A = len(A), len(A[0])
    num_rows_B, num_cols_B = len(B), len(B[0])

    # Ensure the matrices can be multiplied
    if num_cols_A != num_rows_B:
        raise ValueError("Incompatible matrix dimensions for multiplication")
    
    # Using seq to perform the operations
    def calculate_element(i, j):
        return (i, j, compute_element(A[i], get_col(B, j)))

    result = seq(range(num_rows_A))\
        .flat_map(lambda i: seq(range(num_cols_B)).map(lambda j: calculate_element(i, j)))\
        .to_list()
    
    # Initialize the resultant matrix with 0s
    resultant_matrix = [[0] * num_cols_B for _ in range(num_rows_A)]
    
    # Assigning computed values to the resultant matrix
    for i, j, val in result:
        resultant_matrix[i][j] = val
    
    return resultant_matrix


# Example usage:
if __name__ == "__main__":
    for i in range(10000):
        result = pyfunctional_matrix_multiply(a, b)
