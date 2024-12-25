#include <iostream>

using namespace std;

int main(){
    long long int a,b;
    
    cin>>a>>b;
    
    if(a>=b) cout<<b;
    else if(b!=0) cout<<(a+1);
    else cout<<0;
    
    return 0;
}