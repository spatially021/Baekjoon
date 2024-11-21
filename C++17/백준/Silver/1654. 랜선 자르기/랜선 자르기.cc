#include <stdio.h>

int main()
{
    int K, N, max_length = 0;
    scanf("%d %d", &K, &N);

    int arr[K];

    for (int i = 0; i < K; i++)
    {
        scanf("%d", &arr[i]);
        if (max_length < arr[i])
        {
            max_length = arr[i];
        }
    }

    unsigned int left = 0, right = max_length+1;
    unsigned int mid=0;
    while (left < right)
    {
        mid= (left + right) / 2;
        unsigned int total = 0;
        for (int i = 0; i < K; i++)
        {
            total += arr[i] / mid;
        }

        if(total<N) right=mid;
        else left=mid+1;
    }

    printf("%d\n", left-1);

    return 0;
}