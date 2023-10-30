fn main() {
        for _j in 0..10 {
            for _i in 0..1000000000 {
                let arr = [1, 2, 3, 4, 5];
                let _result: Vec<i32> = arr.iter().map(|&x| x * 2).collect();
            }
        }
}

