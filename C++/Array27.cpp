#include <vector>
using namespace std;
// 双指针法
class Solution
{
public:
  int removeElement(vector<int> &nums, int val)
  {
    int slowI = 0;
    for (int fastI = 0; fastI < nums.size(); fastI++)
    {
      if (val != nums[fastI])
      {
        nums[slowI] = nums[fastI];
        slowI++;
      }
    }
    return slowI;
  }
};