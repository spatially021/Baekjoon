use std::io::{stdin, Read};

fn find(parent: &mut Vec<usize>, x: usize) -> usize {
    if parent[x] != x {
        parent[x] = find(parent, parent[x]); 
    }
    parent[x]
}

fn union(x: usize, y: usize, parent: &mut Vec<usize>, rank: &mut Vec<usize>) {
    let nx = find(parent, x);
    let ny = find(parent, y);

    if nx != ny {
        if rank[nx] < rank[ny] {
            parent[nx] = ny;
        } else if rank[nx] > rank[ny] {
            parent[ny] = nx;
        } else {
            parent[ny] = nx;
            rank[nx] += 1;
        }
    }
}

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace().flat_map(str::parse::<usize>);

    let n: usize = input.next().unwrap();

    let mut parent: Vec<usize> = (0..=n).collect();
    let mut rank: Vec<usize> = vec![0; n + 1];

    for _ in 0..n - 2 {
        let a = input.next().unwrap();
        let b = input.next().unwrap();
        union(a, b, &mut parent, &mut rank);
    }

    let mut components: Vec<usize> = vec![];
    for i in 1..=n {
        let root = find(&mut parent, i);
        if !components.contains(&root) {
            components.push(root);
        }
    }

    let mut result = vec![];
    for i in 0..components.len() {
        for j in i + 1..components.len() {
            result.push((components[i], components[j]));
        }
    }

    for (a, b) in result {
        println!("{} {}", a, b);
    }
}