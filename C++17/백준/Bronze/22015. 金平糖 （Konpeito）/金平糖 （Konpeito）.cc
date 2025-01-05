#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int a, b, c;
    
    cin >> a >> b >> c;
 
    int maxVal = max({a, b, c});     

    int sum = maxVal * 3 - (a + b + c);
    
    cout << sum;
    
    return 0;
}
