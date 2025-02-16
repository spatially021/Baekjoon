use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace().flat_map(str::parse::<i128>);

    let n = input.next().unwrap();
    let m = input.next().unwrap();

    let a = find(n, 2) - find(m, 2) - find(n - m, 2);
    let b = find(n, 5) - find(m, 5) - find(n - m, 5);

    print!("{}", std::cmp::min(a, b));
}

fn find(n: i128, k: i128) -> i128 {
    let mut result = 0;
    let mut temp = k;

    while temp <= n {
        result += n / temp;
        temp *= k;
    }

    return result;
}
