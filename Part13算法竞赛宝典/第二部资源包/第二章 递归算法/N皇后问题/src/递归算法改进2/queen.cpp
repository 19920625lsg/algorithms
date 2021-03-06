/*
改进1 
*/
#include <iostream>
#include <math.h>
using namespace std;

int a[20+1];
char x1[40+1];//斜线数为2*N+1用来判断正斜线"/"的 
char x2[40+1];//反斜线"\"上有棋，则作标记 
char lie[20+1];//解决列冲突，如果第i列有棋，则lie[i]=1,放下一棋时直接查看lie[i]即可 
long total,n;

void place(int x,int y)
{
  int i;
  if(x==n+1)
    total++;
  else
  {
    for(i=1;i<=y;i++)
    {
      if((!lie[i])&&(!x1[x+i])&&(!(x2[x-i+n])))//如果没有冲突 
      {
        a[x]=i;
        lie[i]=1;//则该列标记为1 
        x1[x+i]=1;//该正斜线标记为1 
        x2[x-i+n]=1;//该反斜线标记为1
        if(n%2!=0 && x==1 && a[1]==(n+1)/2)
          place(2,(n+1)/2-1);
        else   
          place(x+1,n);
        lie[i]=0;//还原 
        x1[x+i]=0;//还原 
        x2[x-i+n]=0;//还原 
      }
    }
  }
}
int main()
{
  freopen("queen.in","r",stdin);
  freopen("queen.out","w",stdout);
  total=0;
  cin>>n;
  place(1,(n+1)/2);
  cout<<total*2<<endl;
  return 0;
}
