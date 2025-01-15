use std::io;

fn main() {
    let mut buffer = String::new();

    io::stdin().read_line(&mut buffer).unwrap();
    let n: i128 = buffer.trim().parse::<i128>().unwrap();

    buffer.clear();

    io::stdin().read_line(&mut buffer).unwrap();
    let vec: Vec<i128> = buffer
        .split_whitespace()
        .map(|x| x.parse().unwrap())
        .collect();

    let mut x: u128 = 0; // x의 타입을 u128로 변경

    for i in 1..=n {
        if i % vec[0] == 0 {
            x += i as u128;
        }
        if i % vec[1] == 0 {
            x %= i as u128;
        }
        if i % vec[2] == 0 {
            x &= i as u128;
        }
        if i % vec[3] == 0 {
            x ^= i as u128;
        }
        if i % vec[4] == 0 {
            x |= i as u128;
        }
        if i % vec[5] == 0 {
            x =x >>(i as u128);
        }
    }

    println!("{}", x);
}
