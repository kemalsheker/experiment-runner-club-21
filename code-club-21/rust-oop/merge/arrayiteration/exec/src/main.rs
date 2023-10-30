struct ArrayWrapper {
    arr: Vec<i32>,
}

impl ArrayWrapper {
    fn new(arr: Vec<i32>) -> Self {
        Self { arr }
    }

    // Method to iterate and transform each element
    fn transform(&self) -> Vec<i32> {
        let mut result = Vec::new();
        
        for &elem in &self.arr {
            result.push(elem * 2);
        }
        
        result
    }
}

fn main() {
    for _i in 0..100000000 {
        let array_wrapper = ArrayWrapper::new(vec![1, 2, 3, 4, 5]);
        let _result = array_wrapper.transform();
    }
}

