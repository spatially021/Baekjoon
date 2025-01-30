use std::io::{stdin, Read};

fn main() {
	
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace().flat_map(str::parse::<usize>);

    let n=input.next().unwrap();

    let mut matrix=vec![vec![0;n];n];

    for i in 0..n{
        for j in 0..n{
            matrix[i][j]=input.next().unwrap();
        }
    }

    let mut dp:Vec<Vec<i64>>=vec![vec![0;n];n];

    dp[0][0]=1;

    for i in 0..n{
        for j in 0..n{
            
            if dp[i][j]==0 || (i==n-1 && j==n-1){
                continue;
            }

            let value=matrix[i][j];
            let dx=value+i;
            let dy=value+j;

            if dx<n{
                dp[dx][j]+=dp[i][j];
            }

            if dy <n{
                dp[i][dy]+=dp[i][j];
            }

        }
    }

    print!("{}",dp[n-1][n-1]);


}
