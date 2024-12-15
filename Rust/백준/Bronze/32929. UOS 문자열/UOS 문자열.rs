use std::io;

fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();

    // 입력값 트림 후 파싱
    let trimmed_input = input.trim();
    let n: i32 = match trimmed_input.parse() {
        Ok(value) => value,
        Err(_) => {
            eprintln!("Invalid input. Please enter a valid integer.");
            return;
        }
    };

    // n 값에 따라 출력
    if n % 3 == 0 {
        println!("S");
    } else if n % 3 == 1 {
        println!("U");
    } else {
        println!("O");
    }
}
