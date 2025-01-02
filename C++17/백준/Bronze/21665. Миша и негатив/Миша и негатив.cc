#include <iostream>

using namespace std;

int main(){
    
    int n,m;
    
    cin>>n>>m;
    
    char origin[100][100],reverse[100][100];
    
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            cin>>origin[i][j];
        }
    }
    
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            cin>>reverse[i][j];
        }
    }

    
    int cnt=0;
    
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(origin[i][j]==reverse[i][j]) cnt++;
        }
    }
    
    cout<<cnt;
    
}