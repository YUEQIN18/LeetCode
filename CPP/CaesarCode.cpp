#include <stddef.h>
#include <iostream>
using namespace std;

void Entrypt(char *PlaintText, int PlaintTextSize, char *CipText)
{
  //加密PlaintText

  for (auto i = 0; i < PlaintTextSize; i++)
  {
    /*
    1.首先字符 - 字符'a'得出下标.
    2.下标 + 则是代表假面
    3.如果是加密,怎么下标不能超过26. 所以 % 26
    4.计算完的结果 加上'a' 就等于实际加密的密文了
    */
    char ch = (PlaintText[i] - 'a' + 3); //得出下标
    char ch1 = ch % 26 + 'a';            //得出实际密文

    //接受的密文数组
    CipText[i] = ch1;
  }
  return;
}

//解密数据,与加密相反
void Detrypt(char *CipText, int CipTextSize, char *PlaintText)
{
  //加密PlaintText

  for (auto i = 0; i < CipTextSize; i++)
  {
    /*
    1.首先字符 - 字符'a'得出下标.
    2.下标 - 则是代表解密
    3.如果是- 则会出现复数情况, 如 a的下标为0  a - 3  = 负数. 那么需要加26进行调整. 调整之后是绝对不会超过26的
    4.虽然不会超过.但是也要 % 26.因为如果是正数的情况,如果你加26那么还是会超过26
    */
    char ch = (CipText[i] - 'a' - 3); //得出下标
    char ch1 = (ch + 26);             //负数调整,
    char ch3 = ch1 % 26 + 'a';        //正数 % 26得出下标,下标 + 'a'
    //接受的密文数组
    PlaintText[i] = ch3;
  }
  return;
}
int main()
{
  // c = entrypt(p + k) % 26
  // char szBuffer[] = "ibinary";
  char PlaintText[] = "ibinary";
  char CipText[8] = {0};
  char PlanitText1[8] = {0};

  Entrypt(PlaintText, strlen(PlaintText), CipText);
  printf("加密明文后的密文 = %s \r\n", CipText);

  Detrypt(CipText, strlen(CipText), PlanitText1);
  printf("解密密文后的明文 = %s \r\n", PlanitText1);

  system("pause");
  return 0;
}