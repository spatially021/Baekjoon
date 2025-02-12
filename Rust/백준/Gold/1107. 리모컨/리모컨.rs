use std::cmp;
use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let n = input.next().unwrap().parse::<usize>().unwrap();
    let m = input.next().unwrap().parse::<usize>().unwrap();

    let mut arr = vec!['0'; m];

    for i in 0..m {
        arr[i] = input.next().unwrap().parse().unwrap();
    }

    let mut min = (100 as usize).abs_diff(n);

    for i in 0..1000001 {
        let num = i.to_string();
        let mut index = 0;
        for c in num.chars() {
            if arr.contains(&c) {
                break;
            }
            if index == num.len() - 1 {
                min = cmp::min(min, (i as usize).abs_diff(n) + num.len());
            }
            index += 1;
        }
    }
    print!("{min}");
}
