use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace().flat_map(str::parse::<usize>);

    let mut s = input.next().unwrap();
    let a = input.next().unwrap();
    let b = input.next().unwrap();

    if a >= s {
        print!("250");
    }else{
        let mut sum=250;
        s-=a;

        sum+=(s/b)*100;
        if s%b!=0{
            sum+=100;
        }

        print!("{}",sum);

    }

}
