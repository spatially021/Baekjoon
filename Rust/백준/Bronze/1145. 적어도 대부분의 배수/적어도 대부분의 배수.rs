use std::{
    cmp,
    io::{stdin, Read},
};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace().flat_map(str::parse::<u32>);

    let mut arr = Vec::new();
    let mut min = u32::MAX;

    for _ in 0..5 {
        let num = input.next().unwrap();
        min = cmp::min(num, min);
        arr.push(num);
    }

    while true {
        let mut cnt = 0;

        for &i in arr.iter() {
            if min % i == 0 {
                cnt += 1;
            }
        }

        if cnt > 2 {
            break;
        }
        min += 1;
    }

    print!("{min}");
}
