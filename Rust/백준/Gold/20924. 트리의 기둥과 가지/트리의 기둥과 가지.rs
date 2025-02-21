use std::{
    io::{stdin, Read},
    ops::Add,
};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace().flat_map(str::parse::<u32>);

    let n = input.next().unwrap();
    let root = input.next().unwrap() as usize;

    let mut nodes = vec![vec![]; n as usize + 1];

    for _ in 0..n - 1 {
        let a = input.next().unwrap() as usize;
        let b = input.next().unwrap() as usize;
        let d = input.next().unwrap() as usize;
        nodes[a as usize].push((b, d));
        nodes[b].push((a, d));
    }

    let mut len = 0;
    let mut visited = vec![false; n as usize + 1];
    let mut last_index = root;
    visited[root] = true;
    dfs_giga(&nodes, root, &mut len, &mut visited, &mut last_index);

    let mut max_length = 0;
    dfs_leaf(&nodes, last_index, 0, &mut max_length, &mut visited);

    print!("{} {}", len, max_length);
}

fn dfs_leaf(
    nodes: &Vec<Vec<(usize, usize)>>,
    index: usize,
    len: usize,
    max: &mut usize,
    visited: &mut Vec<bool>,
) {
    *max = (*max).max(len);

    for &(next, weight) in &nodes[index] {
        if !visited[next] {
            visited[next] = true;
            dfs_leaf(nodes, next, len + weight, max, visited);
        }
    }
}

fn dfs_giga(
    nodes: &Vec<Vec<(usize, usize)>>,
    index: usize,
    len: &mut usize,
    visited: &mut Vec<bool>,
    last: &mut usize,
) {
    let mut cnt = 0;
    for &(next, _weight) in &nodes[index] {
        if !visited[next] {
            cnt += 1;
        }
    }

    // print!("{index} : {:?} {cnt}\n", visited);

    if cnt > 1 {
        return;
    }

    for &(next, weight) in &nodes[index] {
        if !visited[next] {
            visited[next] = true;
            *len = (*len).add(weight);
            *last = next;
            dfs_giga(nodes, next, len, visited, last);
        }
    }
}
