use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace().flat_map(str::parse::<usize>);

    let a:f32 = input.next().unwrap() as f32;

    print!("{}\n{}", (100.0 - a) / a + 1.0, a / (100.0 - a) + 1.0);
}