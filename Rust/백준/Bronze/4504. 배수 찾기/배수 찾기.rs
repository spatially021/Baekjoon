use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace().flat_map(str::parse::<usize>);

    let n = input.next().unwrap();

    loop {
        let num = input.next().unwrap();
        if num == 0 {
            break;
        }

        if num % n != 0 {
            print!("{num} is NOT a multiple of {n}.\n");
        } else {
            print!("{num} is a multiple of {n}.\n");
        }
    }
}
