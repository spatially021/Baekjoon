#include <iostream>
#include <math.h>

using namespace std;

int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int t; cin>>t;

    while (t--)
    {
        int x,y; cin>>x>>y;

        int len=y-x;
        
        int d=sqrt(len);

        if(d*d==len){
            cout<<2*d-1<<"\n";
        }else if(len>d*d && len<=d*d+d){
            cout<<2*d<<"\n";
        }else{
            cout<<2*d+1<<"\n";
        }
    }
    

    return 0;
}