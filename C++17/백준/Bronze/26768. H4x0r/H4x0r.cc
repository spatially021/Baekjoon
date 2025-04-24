#include <iostream>
#include <string>

using namespace std;

int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string str;
    cin>>str;

    for (char c : str) {
        if (c == 'a') {
            cout << '4';
        } else if (c == 'e') {
            cout << '3';
        } else if (c == 'i') {
            cout<<'1';
        } else if (c == 'o') {
            cout<<'0';
        } else if (c == 's') {
            cout<<'5';
        } else {
            cout << c;
        }
    }

    return 0;
}
