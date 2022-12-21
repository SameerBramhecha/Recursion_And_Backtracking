#include <iostream>
#include <vector>
#define rep(i, a, b) for (int i = a; i < b; i++)
#define nl cout << endl
using namespace std;
bool isSafe(vector<string> board, int row, int col, int n)
{
    // horizontally
    rep(j, 0, n)
    {
        if (board[row][j] == 'Q')
        {
            return false;
        }
    }
    // vertically
    rep(i, 0, n)
    {
        if (board[i][col] == 'Q')
        {
            return false;
        }
    }
    // upper right
    int r = row;
    for (int c = col; c < board.size() && r >= 0; c++, r--)
    {
        if (board[r][c] == 'Q')
        {
            return false;
        }
    }
    // lower right
    r = row;
    for (int c = col; c < board.size() && r < board.size(); c++, r++)
    {
        if (board[r][c] == 'Q')
        {
            return false;
        }
    }
    // upper left
    r = row;
    for (int c = col; c >= 0 && r >= 0; c--, r--)
    {
        if (board[r][c] == 'Q')
        {
            return false;
        }
    }
    // lower left
    r = row;
    for (int c = col; c >= 0 && r < board.size(); c--, r++)
    {
        if (board[r][c] == 'Q')
        {
            return false;
        }
    }

    return true;
}
void nqueens(vector<string> &board, vector<vector<string>> &ans, int col, int n)
{
    if (col == n)
    {
        ans.push_back(board);
        return;
    }
    rep(row, 0, n)
    {
        if (isSafe(board, row, col, n))
        {
            board[row][col] = 'Q';
            nqueens(board, ans, col + 1, n);
            board[row][col] = '.';
        }
    }
}
vector<vector<string>> solveNQueens(int n)
{
    vector<string> board(n);
    vector<vector<string>> ans;
    string s(n, '.');
    rep(i, 0, n)
    {
        board[i] = s;
    }
    nqueens(board, ans, 0, n);
    return ans;
}

int main()
{
    int n = 5;
    vector<vector<string>> ans = solveNQueens(n);
    for (int i = 0; i < ans.size(); i++)
    {
        for (int j = 0; j < ans[0].size(); j++)
        {
            cout << ans[i][j];
            nl;
        }
        nl;
    }
}
