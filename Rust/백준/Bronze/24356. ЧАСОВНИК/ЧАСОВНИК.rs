use std::io::{stdin, Read};

fn main() {
	
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace().flat_map(str::parse::<i32>);

    let t1=input.next().unwrap();
    let m1=input.next().unwrap();
    let t2=input.next().unwrap();
    let m2=input.next().unwrap();

    let mut time=(t2-t1)*60 + (m2-m1);

    if time<0{
        time+=1440;
    }

    print!("{} {}",time,time/30);

}