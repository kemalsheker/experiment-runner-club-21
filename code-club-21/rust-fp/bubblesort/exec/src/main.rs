fn bubble_sort(arr: &mut [i32]) {
    let n = arr.len();
    for _ in 0..n {
        for j in 0..(n - 1) {
            if arr[j] > arr[j + 1] {
                arr.swap(j, j + 1);
            }
        }
    }
}

fn main() {
    for _j in 0..10 {
        for _i in 0..u32::MAX {
            let mut arr = [5, 2, 9, 1, 5, 6];
            bubble_sort(&mut arr);
        }
    }
}

