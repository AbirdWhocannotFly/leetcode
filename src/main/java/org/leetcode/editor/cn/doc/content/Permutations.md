<p>给定一个不含重复数字的数组 <code>nums</code> ，返回其 <em>所有可能的全排列</em> 。你可以 <strong>按任意顺序</strong> 返回答案。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3]
<strong>输出：</strong>[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1]
<strong>输出：</strong>[[0,1],[1,0]]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [1]
<strong>输出：</strong>[[1]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 6</code></li> 
 <li><code>-10 &lt;= nums[i] &lt;= 10</code></li> 
 <li><code>nums</code> 中的所有整数 <strong>互不相同</strong></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 回溯</details><br>

<div>👍 2772, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，全新纸质书[《labuladong 的算法笔记》](https://labuladong.gitee.io/algo/images/book/book_intro_qrcode.jpg) 出版，签名版限时半价！**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=permutations" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[回溯算法秒杀所有排列/组合/子集问题](https://www.bilibili.com/video/BV1Yt4y1t7dK)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 43 页。

[回溯算法详解](https://labuladong.github.io/article/fname.html?fname=回溯算法详解修订版) 中就是拿这个问题来解释回溯模板的，首先画出回溯树来看一看：

![](https://labuladong.github.io/pictures/子集/3.jpg)

写代码遍历这棵回溯树即可。

**详细题解：[回溯算法秒杀所有排列/组合/子集问题](https://labuladong.github.io/article/fname.html?fname=子集排列组合)**

**标签：[回溯算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
public:
    vector<vector<int>> res;

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    vector<vector<int>> permute(vector<int>& nums) {
        // 记录「路径」
        deque<int> track;
        // 「路径」中的元素会被标记为 true，避免重复使用
        vector<bool> used(nums.size(), false);
        
        backtrack(nums, track, used);
        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
    // 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(vector<int>& nums, deque<int>& track, vector<bool>& used) {
        // 触发结束条件
        if (track.size() == nums.size()) {
            res.push_back(vector<int>(track.begin(), track.end()));
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            // 排除不合法的选择
            if (used[i]) {/**<extend up -200>![](https://labuladong.github.io/pictures/backtracking/6.jpg) */
                // nums[i] 已经在 track 中，跳过
                continue;
            }
            // 做选择
            track.push_back(nums[i]);
            used[i] = true;
            // 进入下一层决策树
            backtrack(nums, track, used);
            // 取消选择
            track.pop_back();
            used[i] = false;
        }
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def __init__(self):
        self.res = []

    # 主函数，输入一组不重复的数字，返回它们的全排列 
    def permute(self, nums: List[int]) -> List[List[int]]:

        # 记录「路径」
        track = []
        # 「路径」中的元素会被标记为 true，避免重复使用
        used = [False] * len(nums)
        
        self.backtrack(nums, track, used)
        return self.res

    # 路径：记录在 track 中
    # 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
    # 结束条件：nums 中的元素全都在 track 中出现
    def backtrack(self, nums: List[int], track: List[int], used: List[bool]) -> None:

        # 触发结束条件
        if len(track) == len(nums):
            self.res.append(track[:])
            return

        for i in range(len(nums)):
            # 排除不合法的选择
            if used[i]:
                # nums[i] 已经在 track 中，跳过
                continue
            # 做选择
            track.append(nums[i])
            used[i] = True
            # 进入下一层决策树
            self.backtrack(nums, track, used)
            # 取消选择
            track.pop()
            used[i] = False
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {

    List<List<Integer>> res = new LinkedList<>();

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        // 「路径」中的元素会被标记为 true，避免重复使用
        boolean[] used = new boolean[nums.length];
        
        backtrack(nums, track, used);
        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
    // 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (used[i]) {/**<extend up -200>![](https://labuladong.github.io/pictures/backtracking/6.jpg) */
                // nums[i] 已经在 track 中，跳过
                continue;
            }
            // 做选择
            track.add(nums[i]);
            used[i] = true;
            // 进入下一层决策树
            backtrack(nums, track, used);
            // 取消选择
            track.removeLast();
            used[i] = false;
        }
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func permute(nums []int) [][]int {
    res := [][]int{}
    track := []int{}   // 记录「路径」
    used := make([]bool, len(nums))  // 「路径」中的元素会被标记为 true，避免重复使用

    var backtrack func(int)  // 定义回溯函数

    backtrack = func(level int) {
        if level == len(nums) {   // 触发结束条件
            tmp := make([]int, len(track))
            copy(tmp, track)
            res = append(res, tmp)
            return
        }
        // 枚举出所有可能的选择
        for i := 0; i < len(nums); i++ {
            if used[i] {  // 排除不合法的选择
                continue
            }
            track = append(track, nums[i])  // 做选择
            used[i] = true
            backtrack(level+1)  // 进入下一层决策树
            track = track[:len(track)-1]  // 取消选择
            used[i] = false
        }
    }

    backtrack(0)
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var permute = function(nums) {
    let res = [];
    let track = [];
    let used = new Array(nums.length).fill(false);
    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
    // 结束条件：nums 中的元素全都在 track 中出现
    const backtrack = (nums, track, used) => {
        // 触发结束条件
        if (track.length === nums.length) {
            res.push([...track]);
            return;
        }

        for (let i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (used[i]) {
                // nums[i] 已经在 track 中，跳过
                continue;
            }
            // 做选择
            track.push(nums[i]);
            used[i] = true;
            // 进入下一层决策树
            backtrack(nums, track, used);
            // 取消选择
            track.pop();
            used[i] = false;
        }
    }
    backtrack(nums, track, used);
    return res;
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_permutations" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_permutations"></div></div>
</details><hr /><br />

**类似题目**：
  - [216. 组合总和 III 🟠](/problems/combination-sum-iii)
  - [39. 组合总和 🟠](/problems/combination-sum)
  - [40. 组合总和 II 🟠](/problems/combination-sum-ii)
  - [47. 全排列 II 🟠](/problems/permutations-ii)
  - [51. N 皇后 🔴](/problems/n-queens)
  - [77. 组合 🟠](/problems/combinations)
  - [78. 子集 🟠](/problems/subsets)
  - [90. 子集 II 🟠](/problems/subsets-ii)
  - [剑指 Offer II 079. 所有子集 🟠](/problems/TVdhkn)
  - [剑指 Offer II 080. 含有 k 个元素的组合 🟠](/problems/uUsW3B)
  - [剑指 Offer II 081. 允许重复选择元素的组合 🟠](/problems/Ygoe9J)
  - [剑指 Offer II 082. 含有重复元素集合的组合 🟠](/problems/4sjJUc)
  - [剑指 Offer II 083. 没有重复元素集合的全排列 🟠](/problems/VvJkup)
  - [剑指 Offer II 084. 含有重复元素集合的全排列 🟠](/problems/7p8L0Z)

</details>
</div>

