#include <iostream>

using namespace std;

int main(void){
    
    int sum=0;
    
    while(1){
        int num;
        cin>>num;
        
        if(num==-1) break;
        sum+=num;
        
    }
    
    cout<<sum;
    
}