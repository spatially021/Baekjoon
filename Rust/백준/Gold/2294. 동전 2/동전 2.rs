use std::io::{stdin, Read};
use std::cmp;

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace().flat_map(str::parse::<usize>);

    let n=input.next().unwrap();
    let k=input.next().unwrap();

    let mut dp:Vec<i32>=vec![i16::MAX as i32;k+1];

    for _ in 0..n{
        let num=input.next().unwrap();
        if num<=k{
            dp[num]=1;
        }
    }

    for i in 0..=k{
        for j in 0..i{
            dp[i]=cmp::min(dp[i-j]+dp[j], dp[i]);
        }
    }

    if dp[k]==i16::MAX as i32{
        print!("-1");
    }else{
        print!("{}",dp[k])
    }
}
