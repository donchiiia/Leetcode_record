---
### 解题思路

- 题目要求给出，由给定数组中数字和为target的各数字组成的数组。题目不限制出现数字是否重复，意思是哪怕给定数组中只出现一次的数字，在满足多次使用后
和为target，依然可以收录至结果数组中。
- 乍一看，仿佛是与求全排列有一定的关系。事实上我们也可以借助求全排列的想法代替我们解题：在求全排列的过程中，记录加入路径值之和并与target比较，再决定
是否继续在该分支继续搜索。
- 因为强调了可以有重复的数字，这意味着在使用递归搜索时，搜索的下一层有的是完整的结点(而非全排列中下一层为除去上层出现结点的剩余结点)。
- 通过递归回溯不难实现对结果数组的收集。但一个值得思考的问题是：如何去重，去掉那些相同数字，不同顺序的数组？(例如：[2,2,3]和[2,3,2]是相同的数组，只保留
其中之一)。一个简单的想法就是借助java中Collections工具类的sort()方法对结果数组进行排序，再加入Set中去重。
```
    //path为记录遍历路径、辅助回溯的ArraysDeque实例
    ArrayList<Integer> temp = new ArrayList<>(path);
    Collections.sort(temp);
    set.add(temp);
```
- 以上方式会带来很大的时间开销。可以对回溯进行剪枝操作以实现去重。思考产生重复的原因，无非是在第一个有效数组生成后，其后遍历过程中对该有效数组中数字
重复的遍历。解决方法就是在递归时限制对先前遍历过的数字的再次访问。具体看实现的代码。

### 具体实现

```java
class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		ArrayDeque<Integer> path = new ArrayDeque<>();
		int sum = 0, aim = target;

		Arrays.sort(candidates);
		dfs(set, 0, path, candidates, target, sum, aim);
		return new ArrayList<>(set);
	}

	public boolean dfs(HashSet set, int start, ArrayDeque path, int[] candidates, int target, int sum, int aim) {
		//递归退出的条件
		if (sum == aim) {
			ArrayList<Integer> temp = new ArrayList<>(path);
			set.add(temp);
			return true;
		}
		for (int i = start; i < candidates.length && target - candidates[i] >= 0; i++) {
			sum += candidates[i];
			target -= candidates[i];
			path.addLast(candidates[i]);
			//将深层递归中for循环的开始设置为上一层中for遍历到的值，这样就不会访问到上层访问过的值了。
			dfs(set, i, path, candidates, target, sum, aim);
			//回溯，改回原值
			sum -= candidates[i];
			target += candidates[i];
			path.removeLast();
		}
		return false;
	}
}
```
