use std::io;

fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    let n: usize = input.trim().parse().unwrap();

    if n > 1023 {
        println!("-1");
        return;
    }

    let mut arr: Vec<i64> = (0..10).collect(); 
    let mut index = 0;

    while arr.len() < n { 
        if index >= arr.len() {
            break;
        }
    
        let temp = arr[index];
        let last_digit = temp % 10;
    
        for j in 0..last_digit {
            arr.push(temp * 10 + j);
        }
    
        index += 1;
    }
    
    println!("{}", arr[n - 1]);
    
}
