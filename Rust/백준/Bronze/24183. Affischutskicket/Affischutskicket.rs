use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace().flat_map(str::parse::<usize>);

    let c4 = input.next().unwrap();
    let a3 = input.next().unwrap();
    let a4 = input.next().unwrap();

    let envelop: f32 = 229.0 * 324.0 * (c4 as f32) * 2.0;
    let poster: f32 = 297.0 * 420.0 * (a3 as f32) * 2.0;
    let sheet: f32 = 210.0 * 297.0 * a4 as f32;

    print!("{:.6}",(envelop+poster+sheet)*0.000001);
}
