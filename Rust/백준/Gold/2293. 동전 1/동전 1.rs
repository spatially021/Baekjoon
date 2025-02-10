use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace().flat_map(str::parse::<usize>);

    let n = input.next().unwrap();
    let k = input.next().unwrap();

    let mut arr = vec![0; n];
    let mut dp = vec![0; k + 1];
    for i in 0..n {
        let num = input.next().unwrap();
        arr[i] = num;
    }

    dp[0]=1;

    for i in 0..n {
        for j in arr[i]..=k {
            dp[j]+=dp[j-arr[i]];
        }
    }

    print!("{}",dp[k]);
}
