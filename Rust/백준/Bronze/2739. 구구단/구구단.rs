use std::io;

fn main() {

    let mut input=String::new();
    io::stdin().read_line(&mut input).unwrap();
    let mut numbers=input.split_whitespace();
    
    let n:i32=numbers.next().unwrap().parse().unwrap();

    for i in 1..10{
        println!("{} * {} = {}",n,i,n*i);
    }
}
