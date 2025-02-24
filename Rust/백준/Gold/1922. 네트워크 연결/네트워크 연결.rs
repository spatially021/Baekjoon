use std::cmp::Ordering;
use std::io::{stdin, Read};

#[derive(Eq, PartialEq, Clone, Copy)]
struct nodeInfo(u32, u32);

impl Ord for nodeInfo {
    fn cmp(&self, other: &Self) -> Ordering {
        self.1.cmp(&other.1).reverse() // 두 번째 요소를 기준으로 정렬
    }
}

impl PartialOrd for nodeInfo {
    fn partial_cmp(&self, other: &Self) -> Option<Ordering> {
        Some(self.cmp(other))
    }
}

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace().flat_map(str::parse::<u32>);

    let n = input.next().unwrap() as usize;
    let m = input.next().unwrap();

    let mut tree = vec![vec![nodeInfo(0, 0); 0]; n + 1];

    for _ in 0..m {
        let a = input.next().unwrap();
        let b = input.next().unwrap();
        let c = input.next().unwrap();

        tree[a as usize].push(nodeInfo(b, c));
        tree[b as usize].push(nodeInfo(a, c));
    }

    print!("{}", prim(n, tree));
}

fn prim(n: usize, tree: Vec<Vec<nodeInfo>>) -> u32 {
    let mut pq: std::collections::BinaryHeap<nodeInfo> = std::collections::BinaryHeap::new();
    let mut visited = vec![false; n + 1];
    let mut total = 0;

    pq.push(nodeInfo(1, 0));

    while !pq.is_empty() {
        let info = pq.pop().unwrap();

        if visited[info.0 as usize] {
            continue;
        }

        visited[info.0 as usize] = true;
        total += info.1;

        for ne in &tree[info.0 as usize] {
            if !visited[ne.0 as usize] {
                pq.push(nodeInfo(ne.0, ne.1));
            }
        }
    }

    return total;
}
