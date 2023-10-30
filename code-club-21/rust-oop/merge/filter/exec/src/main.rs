struct ArrayWrapper {
    arr: Vec<i32>,
}

impl ArrayWrapper {
    fn new(arr: Vec<i32>) -> Self {
        Self { arr }
    }

    // Method to iterate and apply a condition to each element
    fn filter(&self) -> Vec<i32> {
        let mut result = Vec::new();
        
        for &elem in &self.arr {
            if elem >= 5 {
                result.push(elem);
            }
        }
        
        result
    }
}

fn main() {
    for _i in 0..100000000 {
        let array_wrapper = ArrayWrapper::new(vec![1, 2, 3, 4, 5, 6, 7, 8, 9]);
        let _result = array_wrapper.filter();
    }
}

