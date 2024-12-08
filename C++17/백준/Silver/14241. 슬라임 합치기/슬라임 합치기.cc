
#include <iostream>
#include <algorithm>

using namespace std;

int compare(const void* a, const void* b) { return *(int*)b-*(int*)a; }




int main() {
    
    int n;

    cin>>n;

    int arr[100];

    for(int i=0;i<n;i++){
        cin>>arr[i];
    }

    qsort(arr,n,sizeof(*arr),compare);

    int point=0;
    
    for(int i=1;i<n;i++){
        point+=arr[i]*arr[i-1];
        arr[i]=arr[i]+arr[i-1];
    }

    cout<<point;

    return 0;
}