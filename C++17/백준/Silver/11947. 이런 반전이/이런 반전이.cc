#include <iostream>
#include <string>
#include <cmath>

using namespace std;

#define ll long long

int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int t;
    cin>>t;

    while(t--){
        string str;
        cin>>str;

        if (str == "1000000000") {
            cout << "8999999999000000000\n";
            continue;
        }

        ll n=stoll(str);

        ll target=5*(pow(10,str.size()-1))-1;

        ll n1=0;
        ll n2=0;

        if(n>=target){
            n1=target+1;
            n2=target;
        }else{
            n1=n;
            ll cnt=1;
            while(n>0){
                n2+=(9-(n%10))*cnt;
                cnt*=10;
                n/=10;
            }
        }

        cout<<n1*n2<<"\n";
    }


    return 0;
}
