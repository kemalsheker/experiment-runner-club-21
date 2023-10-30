struct ArrayWrapper {
    arr: Vec<i32>,
}

impl ArrayWrapper {
    fn new(arr: Vec<i32>) -> Self {
        Self { arr }
    }

    fn merge_sort(&self) -> Vec<i32> {
        let len = self.arr.len();
        if len <= 1 {
            return self.arr.clone();
        }

        let mid = len / 2;
        let left = ArrayWrapper { arr: self.arr[0..mid].to_vec() }.merge_sort();
        let right = ArrayWrapper { arr: self.arr[mid..].to_vec() }.merge_sort();

        Self::merge(&left, &right)
    }

    fn merge(left: &[i32], right: &[i32]) -> Vec<i32> {
        let mut result = Vec::new();
        let (mut i, mut j) = (0, 0);

        while i < left.len() && j < right.len() {
            if left[i] < right[j] {
                result.push(left[i]);
                i += 1;
            } else {
                result.push(right[j]);
                j += 1;
            }
        }

        if i < left.len() {
            result.extend(&left[i..]);
        }
        if j < right.len() {
            result.extend(&right[j..]);
        }

        result
    }
}

fn main() {
    for _i in 0..100000000 {
        let array_wrapper = ArrayWrapper::new(vec![5, 2, 9, 1, 5, 6]);
        let _sorted_array = array_wrapper.merge_sort();
    }
}

