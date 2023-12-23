<p>假设你正在爬楼梯。需要 <code>n</code>&nbsp;阶你才能到达楼顶。</p>

<p>每次你可以爬 <code>1</code> 或 <code>2</code> 个台阶。你有多少种不同的方法可以爬到楼顶呢？</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 2
<strong>输出：</strong>2
<strong>解释：</strong>有两种方法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 3
<strong>输出：</strong>3
<strong>解释：</strong>有三种方法可以爬到楼顶。
1. 1 阶 + 1 阶 + 1 阶
2. 1 阶 + 2 阶
3. 2 阶 + 1 阶
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= n &lt;= 45</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>记忆化搜索 | 数学 | 动态规划</details><br>

<div>👍 3379, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，全新纸质书[《labuladong 的算法笔记》](https://labuladong.gitee.io/algo/images/book/book_intro_qrcode.jpg) 出版，签名版限时半价！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这题属于最基本的动态规划，建议先看下前文 [动态规划框架详解](https://labuladong.github.io/article/fname.html?fname=动态规划详解进阶)。

这题很像 [509. 斐波那契数](/problems/fibonacci-number)：爬到第 `n` 级台阶的方法个数等于爬到 `n - 1` 的方法个数和爬到 `n - 2` 的方法个数之和。

**标签：[一维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122007027366395905)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

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
    // 备忘录
    vector<int> memo;

    int climbStairs(int n) {
        memo.resize(n + 1, 0);
        return dp(n);
    }

    // 定义：爬到第 n 级台阶的方法个数为 dp(n)
    int dp(int n) {
        // base case
        if (n <= 2) {
            return n;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        // 状态转移方程：
        // 爬到第 n 级台阶的方法个数等于爬到 n - 1 的方法个数和爬到 n - 2 的方法个数之和。
        memo[n] = dp(n - 1) + dp(n - 2);
        return memo[n];
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    # 备忘录
    memo = []

    def climbStairs(self, n: int) -> int:
        self.memo = [0] * (n + 1)
        return self.dp(n)

    # 定义：爬到第 n 级台阶的方法个数为 dp(n)
    def dp(self, n: int) -> int:
        # base case
        if n <= 2:
            return n
        if self.memo[n] > 0:
            return self.memo[n]
        # 状态转移方程：
        # 爬到第 n 级台阶的方法个数等于爬到 n - 1 的方法个数和爬到 n - 2 的方法个数之和。
        self.memo[n] = self.dp(n - 1) + self.dp(n - 2)
        return self.memo[n]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 备忘录
    int[] memo;

    public int climbStairs(int n) {
        memo = new int[n + 1];
        return dp(n);
    }

    // 定义：爬到第 n 级台阶的方法个数为 dp(n)
    int dp(int n) {
        // base case
        if (n <= 2) {
            return n;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        // 状态转移方程：
        // 爬到第 n 级台阶的方法个数等于爬到 n - 1 的方法个数和爬到 n - 2 的方法个数之和。
        memo[n] = dp(n - 1) + dp(n - 2);
        return memo[n];
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func climbStairs(n int) int {
    memo := make([]int, n+1)
    var dp func(int) int
    dp = func(n int) int {
        // base case
        if n <= 2 {
            return n
        }
        if memo[n] > 0 {
            return memo[n]
        }
        // 状态转移方程：
        // 爬到第 n 级台阶的方法个数等于爬到 n - 1 的方法个数和爬到 n - 2 的方法个数之和。
        memo[n] = dp(n-1) + dp(n-2)
        return memo[n]
    }
    return dp(n)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var climbStairs = function(n) {
    // 备忘录
    const memo = new Array(n + 1).fill(0);
    return dp(n);

    // 定义：爬到第 n 级台阶的方法个数为 dp(n)
    function dp(n) {
        // base case
        if (n <= 2) {
            return n;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        // 状态转移方程：
        // 爬到第 n 级台阶的方法个数等于爬到 n - 1 的方法个数和爬到 n - 2 的方法个数之和。
        memo[n] = dp(n - 1) + dp(n - 2);
        return memo[n];
    }
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_climbing-stairs" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_climbing-stairs"></div></div>
</details><hr /><br />

**类似题目**：
  - [剑指 Offer 10- II. 青蛙跳台阶问题 🟢](/problems/qing-wa-tiao-tai-jie-wen-ti-lcof)

</details>
</div>

