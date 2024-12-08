#include <iostream>

using namespace std;

int main() {
    
    int n;

    cin>>n;

    int arr[20000];

    for(int i=0;i<n;i++){
        cin>>arr[i];
    }

    int diff[20000];
    
    for(int i=0;i<n;i++){
        int sum=0;
        int num=arr[i];
        for(int j=0;j<n;j++){
            sum+=abs(num-arr[j]);
        }
        diff[i]=sum;
    }

    int min=10000*n+1;
    int minIndex=-1;

    for(int i=0;i<n;i++){
        if(diff[i]<min){
            min=diff[i];
            minIndex=i;
        }else if(diff[i]==min){
            if(arr[i]<arr[minIndex]){
                min=diff[i];
                minIndex=i;
            }
        }
    }

    cout<<arr[minIndex];

    return 0;
}