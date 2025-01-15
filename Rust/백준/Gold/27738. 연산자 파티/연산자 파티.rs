use std::io;

fn main() {
    let mut buffer = String::new();

    io::stdin().read_line(&mut buffer).unwrap();
    let n: u128 = buffer.trim().parse::<u128>().unwrap();

    buffer.clear();

    io::stdin().read_line(&mut buffer).unwrap();
    let vec: Vec<u128> = buffer
        .split_whitespace()
        .map(|x| x.parse().unwrap())
        .collect();

    let mut x: u128 = 0;

    for i in n/vec[5]*vec[5]+1..=n {
        if i % vec[0] == 0 {
            x += i;
        }
        if i % vec[1] == 0 {
            x %= i;
        }
        if i % vec[2] == 0 {
            x &= i;
        }
        if i % vec[3] == 0 {
            x ^= i;
        }
        if i % vec[4] == 0 {
            x |= i;
        }
        if i % vec[5] == 0 {
            x >>= i;   
        }
    }

    println!("{}", x);
}
