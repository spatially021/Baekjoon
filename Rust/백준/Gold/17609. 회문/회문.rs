use std::io::stdin;

fn main() {
    let mut buffer = String::new();
    stdin().read_line(&mut buffer).unwrap();

    let t = buffer.trim().parse::<usize>().unwrap();

    for _ in 0..t {
        let mut buffer = String::new();
        stdin().read_line(&mut buffer).unwrap();
        let chars: Vec<char> = buffer.trim().chars().collect();

        let mut left = 0;
        let mut right = chars.len() - 1;

        let mut flag_pal = true; 
        let mut flag_one_skip = false;

        while left < right {
            if chars[left] != chars[right] {

                flag_pal = false;

                let skip_left = is_palindrome(&chars, left + 1, right);
                let skip_right = is_palindrome(&chars, left, right - 1);

                if skip_left || skip_right {
                    flag_one_skip = true;
                }

                break;
            }
            left += 1;
            right -= 1;
        }

        if flag_pal {
            println!("0");
        } else if flag_one_skip {
            println!("1");
        } else {
            println!("2");
        }
    }
}

fn is_palindrome(chars: &[char], mut left: usize, mut right: usize) -> bool {
    while left < right {
        if chars[left] != chars[right] {
            return false;
        }
        left += 1;
        right -= 1;
    }
    true
}
