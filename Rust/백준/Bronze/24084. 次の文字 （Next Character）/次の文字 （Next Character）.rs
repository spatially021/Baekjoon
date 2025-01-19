use std::io;

fn main() {
    let mut buffer = String::new();

    io::stdin().read_line(&mut buffer).unwrap();

    let n:usize=buffer.trim().parse().unwrap();
    buffer.clear();

    io::stdin().read_line(&mut buffer).unwrap();   
    let s=buffer.trim().to_string().chars().collect::<Vec<char>>();

    for i in 0..n-1{
        if s[i+1]=='J'{
            print!("{}\n",s[i]);
        }
    }
}
