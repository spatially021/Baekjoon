use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace().flat_map(str::parse::<usize>);

    let a=input.next().unwrap();
    let b=input.next().unwrap();
    let c=input.next().unwrap();

    let aver=(a+b+c)/3;
    
    print!("{}",(aver-a)+(aver-(b-(aver-a))));
 
}