fn main() {
    for _i in 0..100000000 {
        let arr = [1, 2, 3, 4, 5, 6, 7, 8, 9];
        let result: Vec<i32> = arr.iter().filter(|&&x| x >= 5).cloned().collect();
    }
}

