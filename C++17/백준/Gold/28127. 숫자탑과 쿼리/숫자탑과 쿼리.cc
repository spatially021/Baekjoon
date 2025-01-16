#include <iostream>
#include <cmath>

using namespace std;

long long getLeft(long long a, long long d, long long n) {
	return (n - 1) * (2 * a + (n - 2) * d) / 2 + 1;
}

int main(void) {
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int numberOfQueries;
	int a, d, value;

	cin >> numberOfQueries;

	while (numberOfQueries--) {
		cin >> a >> d >> value;

		long long start = 1;
		long long end = 1000000;
		long long x, y;

		while (start <= end) {
			long long middle = (start + end) / 2;
			long long left = getLeft(a, d, middle);

			if (left <= value) {
				start = middle + 1;
				x = left;
				y = middle;
			}
			else {
				end = middle - 1;
			}
		}
		cout << y << ' ' << value - x + 1 << '\n';
	}
}