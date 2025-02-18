use std::io::{stdin, Read};

fn main() -> Result<(), Box<dyn std::error::Error>> {
    let mut input = String::new();
    stdin().read_to_string(&mut input)?;
    let mut input = input
        .split_ascii_whitespace()
        .flat_map(|s| s.parse::<usize>());

    let n = input.next().unwrap();
    let mut nodes: Vec<Vec<usize>> = vec![Vec::new(); n + 1];

    for _ in 0..n - 1 {
        let a = input.next().unwrap();
        let b = input.next().unwrap();
        nodes[a].push(b);
        nodes[b].push(a);
    }

    let mut result = vec![0; n + 1]; // Initialize result with zeros
    let mut order = vec![0; n + 1];

    for i in 1..=n {
        let num = input.next();
        if let Some(value) = num {
            result[i-1] = value;
            order[value] = i;
        } else {
            print!("0");
            return Ok(());
        }
    }

    for i in 1..=n {
        nodes[i].sort_by(|a, b| order[*a].cmp(&order[*b]));
    }

    let mut returns: Vec<usize> = Vec::new();
    let mut visited = vec![false; n + 1];
    visited[1] = true;
    dfs(&nodes, 1, &mut returns, &mut visited);

    for i in 0..n{
        if result[i]!=returns[i]{
            print!("0");
            return Ok(());
        }
    }

    print!("1");
    Ok(())
}

fn dfs(nodes: &Vec<Vec<usize>>, index: usize, returns: &mut Vec<usize>, visited: &mut Vec<bool>) {
    returns.push(index);
    visited[index] = true;
    for &i in &nodes[index] {
        if !visited[i] {
            visited[i] = true;
            dfs(nodes, i, returns, visited);
        }
    }
}
