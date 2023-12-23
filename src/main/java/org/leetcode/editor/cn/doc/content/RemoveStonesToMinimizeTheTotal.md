<p>给你一个整数数组 <code>piles</code> ，数组 <strong>下标从 0 开始</strong> ，其中 <code>piles[i]</code> 表示第 <code>i</code> 堆石子中的石子数量。另给你一个整数 <code>k</code> ，请你执行下述操作 <strong>恰好</strong> <code>k</code> 次：</p>

<ul> 
 <li>选出任一石子堆 <code>piles[i]</code> ，并从中 <strong>移除</strong> <code>floor(piles[i] / 2)</code> 颗石子。</li> 
</ul>

<p><strong>注意：</strong>你可以对 <strong>同一堆</strong> 石子多次执行此操作。</p>

<p>返回执行 <code>k</code> 次操作后，剩下石子的 <strong>最小</strong> 总数。</p>

<p><code>floor(x)</code> 为 <strong>小于</strong> 或 <strong>等于</strong> <code>x</code> 的 <strong>最大</strong> 整数。（即，对 <code>x</code> 向下取整）。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>piles = [5,4,9], k = 2
<strong>输出：</strong>12
<strong>解释：</strong>可能的执行情景如下：
- 对第 2 堆石子执行移除操作，石子分布情况变成 [5,4,<strong><em>5</em></strong>] 。
- 对第 0 堆石子执行移除操作，石子分布情况变成 [<strong><em>3</em></strong>,4,5] 。
剩下石子的总数为 12 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>piles = [4,3,6,7], k = 3
<strong>输出：</strong>12
<strong>解释：</strong>可能的执行情景如下：
- 对第 2 堆石子执行移除操作，石子分布情况变成 [4,3,<strong><em>3</em></strong>,7] 。
- 对第 3 堆石子执行移除操作，石子分布情况变成 [4,3,3,<strong><em>4</em></strong>] 。
- 对第 0 堆石子执行移除操作，石子分布情况变成 [<strong><em>2</em></strong>,3,3,4] 。
剩下石子的总数为 12 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= piles.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>1 &lt;= piles[i] &lt;= 10<sup>4</sup></code></li> 
 <li><code>1 &lt;= k &lt;= 10<sup>5</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>贪心 | 数组 | 堆（优先队列）</details><br>

<div>👍 38, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，全新纸质书[《labuladong 的算法笔记》](https://labuladong.gitee.io/algo/images/book/book_intro_qrcode.jpg) 出版，签名版限时半价！**

</div>

