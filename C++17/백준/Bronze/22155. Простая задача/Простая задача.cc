#include <iostream>

using namespace std;

int main(void){
    int tc;
    
    cin>>tc;
    
    for(int i=0;i<tc;i++){
        
        int a,b;
        
        cin>>a>>b;
        if((a<=1&&b<=2)||(a<=2&&b<=1)) cout<<"Yes\n";
        else cout<<"No\n";
        
    }
    
}