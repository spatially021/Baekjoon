#include <iostream>
using namespace std;
typedef long long ll;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	ll Vk, Jk, Vl, Jl, Vh, Dh, Jh; cin >> Vk >> Jk >> Vl >> Jl >> Vh >> Dh >> Jh;
	cout << (Vk * Jk + Vl * Jl) * Vh * Dh * Jh;
}