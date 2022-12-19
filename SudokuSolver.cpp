#include <iostream>
#include <vector>
#define rep(i, a, b) for (int i = a; i < b; i++)
#define nl cout << endl
using namespace std;

bool isSafe(int grid[9][9], int row, int col, int num)
{
    rep(i, 0, 9)
    {
        if (grid[i][col] == num)
        {
            return false;
        }
        if (grid[row][i] == num)
        {
            return false;
        }
    }
    int sr = (row / 3) * 3;
    int sc = (col / 3) * 3;
    rep(i, sr, sr + 3)
    {
        rep(j, sc, sc + 3)
        {
            if (grid[i][j] == num)
            {
                return false;
            }
        }
    }
    return true;
}

bool helper(int grid[9][9], int row, int col)
{
    if (row == 9)
    {
        return true;
    }

    int nrow = 0, ncol = 0;
    if (col != 8)
    {
        ncol = col + 1;
        nrow = row;
    }
    else
    {
        nrow = row + 1;
        ncol = 0;
    }

    if (grid[row][col] != 0)
    {
        if (helper(grid, nrow, ncol))
        {
            return true;
        }
    }
    else
    {
        rep(i, 1, 10)
        {
            if (isSafe(grid, row, col, i))
            {
                grid[row][col] = i;
                if (helper(grid, nrow, ncol))
                {
                    return true;
                }
                else
                {
                    grid[row][col] = 0;
                }
            }
        }
    }
    return false;
}

void solveSudoku(int grid[9][9])
{
    helper(grid, 0, 0);
}
void printSudoku(int grid[9][9])
{
    cout << "------------------------------------" << endl;
    for (int i = 0; i < 9; i++)
    {
        cout << "|";
        for (int j = 0; j < 9; j++)
        {
            cout << grid[i][j] << " | ";
        }
        nl;
        cout << "------------------------------------" << endl;
    }
}
int main()
{
    int grid[9][9];
    cout << "Enter Input" << endl;
    for (int i = 0; i < 9; i++)
    {
        for (int j = 0; j < 9; j++)
        {
            cin >> grid[i][j];
        }
    }

    cout << "Entered Sudoku: " << endl;
    printSudoku(grid);
    solveSudoku(grid);
    cout << "Output: " << endl;
    printSudoku(grid);
    return 0;
}

/*
Input
3 0 6 5 0 8 4 0 0
5 2 0 0 0 0 0 0 0
0 8 7 0 0 0 0 3 1
0 0 3 0 1 0 0 8 0
9 0 0 8 6 3 0 0 5
0 5 0 0 9 0 6 0 0
1 3 0 0 0 0 2 5 0
0 0 0 0 0 0 0 7 4
0 0 5 2 0 6 3 0 0
*/
