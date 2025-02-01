use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let n = input.next().unwrap().parse::<usize>().unwrap();
    let k = input.next().unwrap().parse::<usize>().unwrap();

    let mut matrix = vec![vec!['.'; n]; n];

    let mut pos: Vec<usize> = vec![0; 2];

    for i in 0..n {
        let str = input.next().unwrap();
        let mut j = 0;
        for c in str.chars() {
            matrix[i][j] = c;
            if c == 'L' {
                pos[0] = i;
                pos[1] = j;
                matrix[i][j] = '.';
            }
            j += 1;
        }
    }

    let mut rotate = 0;

    for _ in 0..k {
        let order = input.next().unwrap();
        if order == "L" {
            rotate -= 1;
            if rotate == -4 {
                rotate = 0;
            }
        } else {
            rotate += 1;
            if rotate == 4 {
                rotate = 0;
            }
        }

        let mut flag = false;

        if rotate == 1 || rotate == -3 {
            for y in pos[1]..n {
                if matrix[pos[0]][y] == 'X' {
                    flag = true;
                    pos[1] = y - 1;
                    break;
                }
            }
            if !flag {
                pos[1] = n - 1;
            }
        } else if rotate == 0 {
            for x in pos[0]..n {
                if matrix[x][pos[1]] == 'X' {
                    flag = true;
                    pos[0] = x - 1;
                    break;
                }
            }
            if !flag {
                pos[0] = n - 1;
            }
        } else if rotate == 3 || rotate == -1 {
            for y in (0..=pos[1]).rev() {
                if matrix[pos[0]][y] == 'X' {
                    flag = true;
                    pos[1] = y + 1;
                    break;
                }
            }
            if !flag {
                pos[1] = 0;
            }
        } else if rotate == 2 || rotate == -2 {
            for x in (0..=pos[0]).rev() {
        
                if matrix[x][pos[1]] == 'X' {
                    flag = true;
                    pos[0] = x + 1;
                    break;
                }
            }
            if !flag {
                pos[0] = 0;
            }
        }

    }




    if rotate == 0 {
        for i in 0..n {
            for j in 0..n {
                if i == pos[0] && j == pos[1] {
                    print!("L");
                } else {
                    print!("{}", matrix[i][j]);
                }
            }
            print!("\n");
        }
    } else if rotate == 1 || rotate == -3 {
        for j in 0..n{
            for i in (0..n).rev(){
                if i == pos[0] && j == pos[1] {
                    print!("L");
                } else {
                    print!("{}", matrix[i][j]);
                }
            }
            print!("\n");
        }

    } else if rotate == 2 || rotate == -2 {

        for i in (0..n).rev(){
            for j in (0..n).rev(){
                if i == pos[0] && j == pos[1] {
                    print!("L");
                } else {
                    print!("{}", matrix[i][j]);
                }
            }
            print!("\n");
        }
    } else {
        for j in (0..n).rev() {
            for i in 0..n {
                if i == pos[0] && j == pos[1] {
                    print!("L");
                } else {
                    print!("{}", matrix[i][j]);
                }
            }
            print!("\n");
        }
    }
}
