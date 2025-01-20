use std::io;

fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    let mut parts = input.split_whitespace().map(|x| x.parse::<u64>().unwrap());
    let a = parts.next().unwrap();
    let b = parts.next().unwrap();

    let sqrt_b = (b as f64).sqrt() as u64;
    let mut is_prime = vec![true; (sqrt_b + 1) as usize];
    is_prime[0] = false;
    if sqrt_b >= 1 {
        is_prime[1] = false;
    }

    for i in 2..=(sqrt_b as usize) {
        if is_prime[i] {
            for j in (i * i..=sqrt_b as usize).step_by(i) {
                is_prime[j] = false;
            }
        }
    }

    let primes: Vec<u64> = (2..=sqrt_b)
        .filter(|&x| is_prime[x as usize])
        .collect();

    let mut count = 0;


    for &p in &primes {
        let mut power = p * p; 
        while power <= b {
            if power >= a {
                count += 1;
            }
            match power.checked_mul(p) {
                Some(next_power) => power = next_power,
                None => break,
            }
        }
    }

    println!("{}", count);
}
