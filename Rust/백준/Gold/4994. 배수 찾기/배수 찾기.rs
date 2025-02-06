use std::collections::VecDeque;
use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace().flat_map(str::parse::<usize>);

    loop {
        let n = input.next().unwrap();

        if n == 0 {
            break;
        }

        let mut q: VecDeque<usize> = VecDeque::new();

        q.push_back(1);

        while !q.is_empty() {
            let num = q.pop_front().unwrap();

            if num % n == 0 {
                print!("{num}\n");
                break;
            }

            if num % 10 == 0 {
                q.push_back(num+1);
                q.push_back(num*10);
            } else {
                q.push_back(num*10);
                q.push_back(num*10+1);
            }
        }
    }
}
