#include <iostream>
#include <algorithm>

using namespace std;

int result[8][8];
int n, k;
int digits[8];
int solution;

int main()
{
    cin >> n;
    cin >> k;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < k; j++)
        {
            char number;
            cin >> number;
            result[i][j] = number - '0';
        }
        scanf("\n");
    }

    for (int i = 0; i < k; i++)
        digits[i] = i;

    solution = (int)1e+9;
    do
    {
        int permutationMin = (int)1e+9;
        int permutationMax = -(int)1e+9;
        for (int i = 0; i < n; i++)
        {
            int x = 0;
            for (int j = 0; j < k; j++)
                (x *= 10) += result[i][digits[j]];
            permutationMax = max(permutationMax, x);
            permutationMin = min(permutationMin, x);
        }
        solution = min(solution, permutationMax - permutationMin);
    } while (next_permutation(digits, digits + k));

    cout << solution << endl;
    return 0;
}