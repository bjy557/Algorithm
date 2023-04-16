#include <iostream>
#include <queue>

using namespace std;

int map[301][301];
int visit[301][301];
int change[301][301];
int dir[4][2] = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

int cnt;
int n, m, ans = 0;



void BFS(int x, int y)
{
	queue<pair<int, int>> q;

	q.push(make_pair(x, y));
	visit[x][y] = 1;
	while (!q.empty())
	{
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++)
		{
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			
			if (nx >= 1 && nx <= n && ny >= 1 && ny <= m)
			{
				if (map[nx][ny] > 0 && visit[nx][ny] == 0)
				{
					q.push(make_pair(nx, ny));
					visit[nx][ny] = 1;
				}
			}
		}
	}
}

void melt(int x, int y)
{
	int sea = 0;
	for (int i = 0; i < 4; i++)
	{
		int nx = x + dir[i][0];
		int ny = y + dir[i][1];
		if (x >= 1 && x <= n && y >= 1 && y <= m && map[nx][ny] == 0 && change[nx][ny] == 0)
			sea++;
	}
	if (map[x][y] - sea < 0)
		map[x][y] = 0;
	else
		map[x][y] -= sea;

	change[x][y] = 1;
}

int main() {

	cin >> n >> m;

	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= m; j++)
			cin >> map[i][j];

	for(int z=0 ; z<1000 ; z++)
	{
		cnt = 0;

		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= m; j++)
			{
				visit[i][j] = 0;
				change[i][j] = 0;
			}
		}

		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= m; j++)
			{
				if (map[i][j] > 0 && visit[i][j] == 0)
				{
					cnt++;
					BFS(i, j);
				}
			}
		}

		if (cnt >= 2)
			break;

		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= m; j++)
			{
				if (visit[i][j] > 0 && change[i][j] == 0)
					melt(i, j);
			}
		}

		ans++;

	}

	if (cnt == 0)
		cout << '0';
	else
		cout << ans;

	return 0;
}