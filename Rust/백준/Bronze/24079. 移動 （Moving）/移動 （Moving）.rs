use std::io;

fn main() {
    let mut buffer = String::new();

    io::stdin().read_line(&mut buffer).unwrap();
    let x:i32=buffer.trim().parse().unwrap();
    buffer.clear();
    
    io::stdin().read_line(&mut buffer).unwrap();
    let y:i32=buffer.trim().parse().unwrap();
    buffer.clear();
    
    io::stdin().read_line(&mut buffer).unwrap();
    let z:i32=buffer.trim().parse().unwrap();
    buffer.clear();

    if (x+y)*60<=z*60+30{
        print!("1");
    }else{
        print!("0");
    }

}
