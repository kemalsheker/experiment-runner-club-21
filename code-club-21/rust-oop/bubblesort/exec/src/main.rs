struct ArrayWrapper {
    arr: Vec<i32>,
}

impl ArrayWrapper {
    fn new(arr: Vec<i32>) -> Self {
        Self { arr }
    }

    fn bubble_sort(&mut self) {
        let n = self.arr.len();
        for _ in 0..n {
            for j in 0..(n - 1) {
                if self.arr[j] > self.arr[j + 1] {
                    self.arr.swap(j, j + 1);
                }
            }
        }
    }
}

fn main() {
    for _j in 0..10 {
        for _i in 0..u32::MAX {
            let mut array_wrapper = ArrayWrapper::new(vec![5, 2, 9, 1, 5, 6]);
            array_wrapper.bubble_sort();
        }
    }
}

