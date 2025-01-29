use std::io::{stdin, Read};
use std::cmp;

fn main() {
	
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace().flat_map(str::parse::<usize>);

    let w1=input.next().unwrap();
    let h1=input.next().unwrap();
    let w2=input.next().unwrap();
    let h2=input.next().unwrap();

    print!("{}", 4+2*cmp::max(w1,w2)+2*(h1+h2));

}