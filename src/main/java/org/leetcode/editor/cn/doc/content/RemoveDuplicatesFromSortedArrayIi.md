<p>给你一个有序数组 <code>nums</code> ，请你<strong><a href="http://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank"> 原地</a></strong> 删除重复出现的元素，使得出现次数超过两次的元素<strong>只出现两次</strong> ，返回删除后数组的新长度。</p>

<p>不要使用额外的数组空间，你必须在 <strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地 </a>修改输入数组 </strong>并在使用 O(1) 额外空间的条件下完成。</p>

<p>&nbsp;</p>

<p><strong>说明：</strong></p>

<p>为什么返回数值是整数，但输出的答案是数组呢？</p>

<p>请注意，输入数组是以<strong>「引用」</strong>方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。</p>

<p>你可以想象内部操作如下:</p>

<pre>
// <strong>nums</strong> 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
int len = removeDuplicates(nums);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中<strong> 该长度范围内</strong> 的所有元素。
for (int i = 0; i &lt; len; i++) {
&nbsp; &nbsp; print(nums[i]);
}
</pre>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,1,1,2,2,3]
<strong>输出：</strong>5, nums = [1,1,2,2,3]
<strong>解释：</strong>函数应返回新长度 length = <strong><code>5</code></strong>, 并且原数组的前五个元素被修改为 <strong><code>1, 1, 2, 2, 3</code></strong>。 不需要考虑数组中超出新长度后面的元素。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,0,1,1,1,1,2,3,3]
<strong>输出：</strong>7, nums = [0,0,1,1,2,3,3]
<strong>解释：</strong>函数应返回新长度 length = <strong><code>7</code></strong>, 并且原数组的前五个元素被修改为&nbsp;<strong><code>0, 0, 1, 1, 2, 3, 3</code></strong>。不需要考虑数组中超出新长度后面的元素。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li> 
 <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
 <li><code>nums</code> 已按升序排列</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 双指针</details><br>

<div>👍 947, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，全新纸质书[《labuladong 的算法笔记》](https://labuladong.gitee.io/algo/images/book/book_intro_qrcode.jpg) 出版，签名版限时半价！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和前文 [数组双指针技巧汇总](https://labuladong.github.io/article/fname.html?fname=双指针技巧) 中讲的 [26. 删除有序数组中的重复项](/problems/remove-duplicates-from-sorted-array) 解法非常类似，只不过这道题说重复两次以上的元素才需要被去除。

本题解法依然使用快慢指针技巧，在之前的解法中添加一个 `count` 变量记录每个数字重复出现的次数，然后把 26 题的 if 判断额外复制粘贴一份就行了，直接看代码吧。

**标签：[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)，[数组双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() == 0) {
            return 0;
        }
        // 快慢指针，维护 nums[0..slow] 为结果子数组
        int slow = 0, fast = 0;
        // 记录一个元素重复的次数
        int count = 0;
        while (fast < nums.size()) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            } else if (slow < fast && count < 2) {
                // 当一个元素重复次数不到 2 次时，也
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
            count++;
            if (fast < nums.size() && nums[fast] != nums[fast - 1]) {
                // 遇到不同的元素
                count = 0;
            }
        }
        // 数组长度为索引 + 1
        return slow + 1;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        # 快慢指针，维护 nums[0..slow] 为结果子数组
        slow, fast = 0, 0
        # 记录一个元素重复的次数
        count = 0
        while fast < len(nums):
            if nums[fast] != nums[slow]:
                slow += 1
                nums[slow] = nums[fast]
            elif slow < fast and count < 2:
                # 当一个元素重复次数不到 2 次时，也
                slow += 1
                nums[slow] = nums[fast]
            fast += 1
            count += 1
            if fast < len(nums) and nums[fast] != nums[fast - 1]:
                # 遇到不同的元素
                count = 0
        # 数组长度为索引 + 1
        return slow + 1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 快慢指针，维护 nums[0..slow] 为结果子数组
        int slow = 0, fast = 0;
        // 记录一个元素重复的次数
        int count = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                // 此时，对于 nums[0..slow] 来说，nums[fast] 是一个新的元素，加进来
                slow++;
                nums[slow] = nums[fast];
            } else if (slow < fast && count < 2) {
                // 此时，对于 nums[0..slow] 来说，nums[fast] 重复次数小于 2，也加进来
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
            count++;
            if (fast < nums.length && nums[fast] != nums[fast - 1]) {
                // fast 遇到新的不同的元素时，重置 count
                count = 0;
            }
        }
        // 数组长度为索引 + 1
        return slow + 1;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func removeDuplicates(nums []int) int {
    if len(nums) == 0 {
        return 0
    }
    // 快慢指针，维护 nums[0..slow] 为结果子数组
    slow, fast := 0, 0
    // 记录一个元素重复的次数
    count := 0
    for fast < len(nums) {
        if nums[fast] != nums[slow] {
            slow++
            nums[slow] = nums[fast]
        } else if slow < fast && count < 2 {
            // 当一个元素重复次数不到 2 次时，也
            slow++
            nums[slow] = nums[fast]
        }
        fast++
        count++
        if fast < len(nums) && nums[fast] != nums[fast - 1] {
            // 遇到不同的元素
            count = 0
        }
    }
    // 数组长度为索引 + 1
    return slow + 1
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var removeDuplicates = function(nums) {
    if (nums.length == 0) {
        return 0;
    }
    // 快慢指针，维护 nums[0..slow] 为结果子数组
    let slow = 0, fast = 0;
    // 记录一个元素重复的次数
    let count = 0;
    while (fast < nums.length) {
        if (nums[fast] != nums[slow]) {
            slow++;
            nums[slow] = nums[fast];
        } else if (slow < fast && count < 2) {
            // 当一个元素重复次数不到 2 次时，也
            slow++;
            nums[slow] = nums[fast];
        }
        fast++;
        count++;
        if (fast < nums.length && nums[fast] != nums[fast - 1]) {
            // 遇到不同的元素
            count = 0;
        }
    }
    // 数组长度为索引 + 1
    return slow + 1;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_remove-duplicates-from-sorted-array-ii" data="G79CIxE2anGKGImw03KPGkW5WlwC1OqANwxf+QPWo6dkzCan5ChhpVnPFgbb+Y7gLF8xOPI1yBjl/uFU5bG6byOQf8DJFusZcFvQ1FzUleMCNVBu++cCgIEVySXS0YUyqK1WGZy+2MPzOZ2yr2uxXfKVanOeqUBxEc5t1cF5Ieedov//+32bZge/EZUzJWMeWX0WoVDnH3kb1Ye43fvemBJFPERCJRZCaLSIRWtqEy67N65GbEohVaZp2fOqlwVyIkiyZWEIhLdAe7nPYA4Z5jFmiY31v9UQEasbcpPqxx5lRMzybWpD3lWUHob/IPMOvoPDXYQTFdvY+zMMXLX76AE7JJDm+qZ5zopMA//FR7K19gv+A0V8p4gVTf7Dl3xVf6MAV0rrUo1Hk1TlQrXnASJ56Q2g47J3aemvK0cH2qI7Uiwt0H7ixOBMl72+B0GhPxp8i41RL7l6/uB8zAcaX7d8DzHNHmrr7Yu4DmMWbUS2ybLzATpUxqawvEfe4LjKSAWXRWri9nNM2PzAJ5A1++t8Flt9lq8tlAop6NPtR5KhiqGHJkbZEEy/2logrdudluuGrBbdbZKU6t2CLugeX0CsksDNzt/riQbUAKJbhqplB8H6u68vn/W2iS0pqLapNZ4AZTvRO0T3b9WhHtIKVpq0ZvEQdG0woIS0PMIV2SW4q3opPECw6nTlX75+cP/ywbOctT2OM614zJLGUS6UDWRd6omOi1nksuAZDSWfT09tDqouAakQsrZoNVaH1nHiPpLE29sP9djbj/UwwvA534Ntmf7JcIakYq7vTT2++lKKBKW3wcbe4DGSGBDzeInnKXIQfiSZXFw6EEfxn6KO5GfsXImfqaf0P+LqNZ9kt6WKjOoy4jD+kMUjIxCjYzJf/6G8KhjVMdQiMP5AAQzzLKVz8o+r/HrsJxGBq9notNl6MKc2qKsom+7kC41fW8QeiC/EHNiWpOx6L07CJFA6GJ/6csgdcZ8FdMrnHYnLTscfprZgAIHZolMsV0AGMpl6oPYnKmN0KoZWhE3JI6M/06eTaP3s2Fuy7yTIcHalHmj8aZVtqmLNF3d5MSNM/hWkHlsLOwl5Vb42X8iIj3G9s0iRKOxdg279QYhFIX+KCxwm6dpPm1dJjOw45vi+m+8mdofJ5wK8XlIz/ue6i8lk1+R/u4Vd2nEru7Z78zqUa2DbDXwT+vGYCGEn21X01nAzQRWTzQkpunOh7CbSILBN2sLWNihq75tahrccgEGjUapuKz3R1MIq0+RsDBgYm+AM3db2rnxVIHgEY+nkGCvkdU7gSd4badZtzO4sAsXM07EaIxVUzmGLqNCUCahJo+4oarrBXdkCjQC1ZQaPKkJwhjKrB4EqjomE2qswdTOoocFwim5NgZKSpEMVP3tCsQK9UIitdlTkSXMUM13nXZm6WV2GUUeJ5VGL695R1UimUAcWKNRPZVVQ6KLKd7ZqRyajYxWKx9sjFVppNu0RiFK2Zz9NQDwcP6Cihkw4eZIfHnya+4Qo2trz4Peg5WS3yTfdRgx7+rffHaMs5Do49pQcOlwEMX+rPQHLc1Sp97/Qf8YaDJZ79RAsbDYTwWp0wDJ15JipecXAf86rUc20GNknjGj1UWD5L6XftYrPc1eOfGSsmpYGtz9RzXtAStefRYLsceDihslWt6ia3bbI2m1dw7JGaZLopEXPo2OpfhvhmPhs1iq72XNYxlRjVHW2aNlZzQgakQsCsQlBC9GIXODPQ4tiVL1uQcdqBJKo6FVgz1o2SKf8JfjN//piOZdgUgWooOcVEPEhz5/cbhmjllrqPsGLl92rEj3MEY+HQy0N4DZ+g+dSNF5e/FEux8LBtE+1Pva84zcnUuNNrLHj2/7nR1wir/wAbrr6DDlASYDzZi3Ol8VIUe80E1gCHBJfTcS4+LOBypLmYox67z+3ZhP8c+fg95UTgeMFaMjPdJ0yRAg0aev73sntliuJkkWhslQSg/fZ7HktmRdJNHOLwRhSLDzBl9nnKflwzzVpUW2dIDtPCoj5JuudKxDGLGdtftHLyKig36MDNCzJ+HHsSqOvROf3iCBCcl63SDHa0U+ocLRZu/tTjpTy8ye3/ZfzCwUbNG7DcqNS2GIzshgMIqAEmIVvw2rkYWRVwywP+o7ejFVmJ1Um4cVnR+Hz/vVqXzA4nzU+W2mxUxFpHR/2Vb2WI3w5zlGG3ZJ/adHktKPromt9f49f4djUgCKwPmgMlxCo8ibLH+uhb782Nhz+LzH/Qazgeb9AGrS+1XJVA1Xt0NHcVKtSjUe1EeEUVItPDTu539RMU2sMji61rdSEUktJDiK1e9S8UStGjhW1SdT0UAtDDgm1F9QsUNe/PPLVLa9OdnWZqwN8dGerc1pdzeo4ljewHWz4/yss/QP/dvBK1ra7n+XT7/FAvYHHkMNjaMNjtvJ44UNsyMjRIEeHTBBEjoQcFTJBBnJUyFEjR4NMUIEcJXJE5OiQCTqQIyJHRo4GOVpkgknkqJEjI0eLTLCJHBE5EnJ0yAQn5KiQIyMTtkCOEjkictTI0aGMKBtAbrYCUjD3RBIlXtQCFJ6vnqrQlWrWv98x8N+2D8Cdcc2UJxwT4RRCBtd+ue2k3NfZv//geMT/dUCjwOBZIvaHUYomKPN1Do944IzBHZc6jj2+FZ4Xm203giN/UVOKlAun2zNdLTEhBlO/YVonrvAoHJfgDmEeYaOF3GvJNgMyVYicNPbGU1DUfTWpTBMIFqxeA+80FLO6KPkInU1K8kOmSfnEa60CBRAmQXF3ZyVGTfZaPW5rW+Ifork0zobGcQ6yjfZM45wiBi44/Tf0bX8Yd/o0x18SIEVkdMMZvCzhtySygMOwn2bhbNJ9RQa4JwZFKnuihaS+KGia5SC8REhN6C7J6u+vTBhvXyL/qEycg0G+hSHiIxhX2z8qvUiWKaLqWMrUof5q/lnLYZtB7TJdnYW26nhZ+YXv3V8amd9sCQ=="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-duplicates-from-sorted-array-ii"></div></div>
</details><hr /><br />

</details>
</div>







