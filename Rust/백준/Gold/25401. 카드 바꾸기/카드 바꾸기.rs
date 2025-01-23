use std::io::{stdin, Read};
use std::cmp;


fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace().flat_map(str::parse::<i32>);

    let n = input.next().unwrap();

    let mut arr: Vec<i32> = Vec::new();

    for _ in 0..n {
        arr.push(input.next().unwrap());
    }

    let mut min = i32::MAX;

    for i in 0..n {
        for j in 0..n {
            let mut cnt = 0;

            if i == j || (arr[j as usize] - arr[i as usize]) % (j - i) == 0 {
                let gap;
                if i == j {
                    gap = 0;
                } else {
                    gap = (arr[j as usize] - arr[i as usize]) / (j - i);
                }

                let mut ideal=vec![0;n as usize];

                for k in i..n{
                    ideal[k as usize]=arr[i as usize] + gap*(k-i);
                }

                for k in 0..i{
                    ideal[k as usize]=arr[i as usize] + gap*(k-i);
                }

                for k in 0..n{
                    if arr[k as usize] != ideal[k as usize] {
                         cnt+=1;
                    }
                }

                min=cmp::min(cnt,min);

            }
        }
    }

    print!("{}", min)
}
