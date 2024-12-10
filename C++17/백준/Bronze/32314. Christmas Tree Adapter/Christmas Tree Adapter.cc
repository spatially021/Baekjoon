#include <iostream>

using namespace std;

int main(){
    int tree,w,v;
    
    cin>>tree;
    cin>>w>>v;
    
    cout<<(tree>w/v ? 0:1);
    
    return 0;
}