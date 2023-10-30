fn matrix_multiply(a: &Vec<Vec<i32>>, b: &Vec<Vec<i32>>) -> Option<Vec<Vec<i32>>> {
    let rows_a = a.len();
    let cols_a = a[0].len();
    let rows_b = b.len();
    let cols_b = b[0].len();

    if cols_a != rows_b {
        return None;
    }

    let mut result = vec![vec![0; cols_b]; rows_a];

    for i in 0..rows_a {
        for j in 0..cols_b {
            for k in 0..cols_a {
                result[i][j] += a[i][k] * b[k][j];
            }
        }
    }

    Some(result)
}

fn main() {

    for _i in 0..100000000  {
        let a = vec![
            vec![1, 2],
            vec![3, 4],
        ];
        let b = vec![
            vec![2, 0],
            vec![1, 2],
        ];

        matrix_multiply(&a, &b);
    }
}

