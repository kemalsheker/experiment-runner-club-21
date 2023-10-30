class BubbleSort:
    def __init__(self, arr):
        self.arr = arr

    def sort(self):
        n = len(self.arr)

        for i in range(n):
            swapped = False

            for j in range(0, n-i-1):
                if self.arr[j] > self.arr[j+1]:
                    # Swap elements if they are in the wrong order
                    self.arr[j], self.arr[j+1] = self.arr[j+1], self.arr[j]
                    swapped = True

            # If no two elements were swapped in inner loop, the array is already sorted
            if not swapped:
                break

if __name__ == "__main__":
    for i in range(10):
        input_list = list(range(1000, -1, -1))  # Creating a list in descending order from 1000 to 0.
        bubble_sorter = BubbleSort(input_list)
        bubble_sorter.sort()
