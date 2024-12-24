#include <iostream>

using namespace std;

int main(){
    float b;
    cin>>b;
    float p=(5*b-400);
    cout<<p<<"\n";
    if(p==100){
        cout<<0;
    }else cout<<(p>100?-1:1);
    
}