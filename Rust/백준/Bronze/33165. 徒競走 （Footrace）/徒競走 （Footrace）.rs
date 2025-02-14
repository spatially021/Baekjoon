use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace().flat_map(str::parse::<usize>);

    let t = input.next().unwrap();
    let v = input.next().unwrap();

    print!("{}", t * v);
}
