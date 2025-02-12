use std::io::{stdin, Read};

fn check(mut word: &str) -> i32 {
    while !word.is_empty() {
        let mut found = false;

        for i in 1..=12 {
            let len_check = 4 * i;
            if word.len() < len_check {
                return 0;
            }

            let target = "w".repeat(i) + &"o".repeat(i) + &"l".repeat(i) + &"f".repeat(i);

            if word.starts_with(&target) {
                word = &word[len_check..];
                found = true;
                break;
            }
        }

        if !found {
            return 0;
        }
    }
    1
}

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();
    println!("{}", check(input.next().unwrap()));
}
