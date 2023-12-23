<p>给定一个数组 <code>prices</code> ，它的第&nbsp;<code>i</code> 个元素&nbsp;<code>prices[i]</code> 表示一支给定股票第 <code>i</code> 天的价格。</p>

<p>你只能选择 <strong>某一天</strong> 买入这只股票，并选择在 <strong>未来的某一个不同的日子</strong> 卖出该股票。设计一个算法来计算你所能获取的最大利润。</p>

<p>返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 <code>0</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>[7,1,5,3,6,4]
<strong>输出：</strong>5
<strong>解释：</strong>在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>prices = [7,6,4,3,1]
<strong>输出：</strong>0
<strong>解释：</strong>在这种情况下, 没有交易完成, 所以最大利润为 0。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= prices.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>0 &lt;= prices[i] &lt;= 10<sup>4</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划</details><br>

<div>👍 3325, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，全新纸质书[《labuladong 的算法笔记》](https://labuladong.gitee.io/algo/images/book/book_intro_qrcode.jpg) 出版，签名版限时半价！**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=best-time-to-buy-and-sell-stock" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

**提示：股票系列问题有共通性，但难度较大，初次接触此类问题的话很难看懂下述思路，建议直接看 [详细题解](https://labuladong.github.io/article/fname.html?fname=团灭股票问题)。**

股票系列问题状态定义：

```python
dp[i][k][0 or 1]
0 <= i <= n - 1, 1 <= k <= K
n 为天数，大 K 为交易数的上限，0 和 1 代表是否持有股票。
```

股票系列问题通用状态转移方程：

```python
dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
              max( 今天选择 rest,        今天选择 sell       )

dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
              max( 今天选择 rest,         今天选择 buy         )
```

通用 base case：

```python
dp[-1][...][0] = dp[...][0][0] = 0
dp[-1][...][1] = dp[...][0][1] = -infinity
```

特化到 `k = 1` 的情况，状态转移方程和 base case 如下：

```python
状态转移方程：
dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
dp[i][1] = max(dp[i-1][1], -prices[i])

base case：
dp[i][0] = 0;
dp[i][1] = -prices[i];
```

详细思路解析和空间复杂度优化的解法见详细题解。

**详细题解：[一个方法团灭 LeetCode 股票买卖问题](https://labuladong.github.io/article/fname.html?fname=团灭股票问题)**

**标签：[二维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122017695998050308)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

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
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        vector<vector<int>> dp(n, vector<int>(2));
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                // base case
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        dp = [[0] * 2 for _ in range(n)]
        for i in range(n):
            if i - 1 == -1:
                # base case
                dp[i][0] = 0
                dp[i][1] = -prices[i]
                continue
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            dp[i][1] = max(dp[i - 1][1], -prices[i])
        return dp[n - 1][0]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                // base case
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func maxProfit(prices []int) int {
    n := len(prices)
    dp := make([][]int, n)
    for i := 0; i < n; i++ {
        dp[i] = make([]int, 2)
        if i - 1 == -1 {
            // base case
            dp[i][0] = 0
            dp[i][1] = -prices[i]
            continue
        }
        dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
        dp[i][1] = max(dp[i-1][1], -prices[i])
    }
    return dp[n-1][0]
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    const n = prices.length;
    const dp = new Array(n).map(() => new Array(2));
    for (let i = 0; i < n; i++) {
        if (i - 1 === -1) {
            // base case
            dp[i][0] = 0;
            dp[i][1] = -prices[i];
            continue;
        }
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
    }
    return dp[n - 1][0];
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_best-time-to-buy-and-sell-stock" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_best-time-to-buy-and-sell-stock"></div></div>
</details><hr /><br />

**类似题目**：
  - [122. 买卖股票的最佳时机 II 🟠](/problems/best-time-to-buy-and-sell-stock-ii)
  - [123. 买卖股票的最佳时机 III 🔴](/problems/best-time-to-buy-and-sell-stock-iii)
  - [188. 买卖股票的最佳时机 IV 🔴](/problems/best-time-to-buy-and-sell-stock-iv)
  - [309. 最佳买卖股票时机含冷冻期 🟠](/problems/best-time-to-buy-and-sell-stock-with-cooldown)
  - [714. 买卖股票的最佳时机含手续费 🟠](/problems/best-time-to-buy-and-sell-stock-with-transaction-fee)
  - [剑指 Offer 63. 股票的最大利润 🟠](/problems/gu-piao-de-zui-da-li-run-lcof)

</details>
</div>

