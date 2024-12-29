#include <iostream>
#include <iomanip> 

using namespace std;

int main() {
    int n;

    cin >> n;

    float result = 25 + n * 0.01f;

    if(result<100) cout<<100;
    else if(result>2000) cout<<2000; 
    else cout << fixed << setprecision(2) << result;

    return 0;
}
