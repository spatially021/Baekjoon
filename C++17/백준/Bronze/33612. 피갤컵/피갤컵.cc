#include <iostream>

using namespace std;

int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin>>n;

    int year=2024;
    int month=8;

    if(n==5){
        cout<<"2026 12";
    }else{
        cout<<(year+(month+7*(n-1))/12)<<" "<<(month+7*(n-1))%12;
    }

    return 0;
}
