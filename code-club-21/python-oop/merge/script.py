class MergeSortAscending:
    def __init__(self, arr):
        self.arr = arr

    def merge(self, left, right):
        merged = []
        left_idx, right_idx = 0, 0

        while left_idx < len(left) and right_idx < len(right):
            if left[left_idx] < right[right_idx]:  # Compare in ascending order.
                merged.append(left[left_idx])
                left_idx += 1
            else:
                merged.append(right[right_idx])
                right_idx += 1

        merged.extend(left[left_idx:])
        merged.extend(right[right_idx:])
        return merged

    def sort(self):
        if len(self.arr) <= 1:
            return self.arr

        mid = len(self.arr) // 2
        left = self.arr[:mid]
        right = self.arr[mid:]

        left_sorter = MergeSortAscending(left)
        right_sorter = MergeSortAscending(right)

        left_sorted = left_sorter.sort()
        right_sorted = right_sorter.sort()

        return self.merge(left_sorted, right_sorted)


if __name__ == "__main__":
    for i in range(1000):
        input_list = list(range(1000, -1, -1))  # Creating a list in descending order from 1000 to 0.
        merge_sorter = MergeSortAscending(input_list)
        sorted_list = merge_sorter.sort()
