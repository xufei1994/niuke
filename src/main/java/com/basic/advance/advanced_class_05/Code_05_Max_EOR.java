package com.basic.advance.advanced_class_05;

import edu.princeton.cs.algs4.In;

public class  Code_05_Max_EOR {

	public static class Node {
		public Node[] nexts = new Node[2]; //前缀树  0,1 两条路
	}

	public static class NumTrie {
		public Node head = new Node();

		public void add(int num) {
			Node cur = head;
			for (int move = 31; move >= 0; move--) {
				int path = ((num >> move) & 1);//提取每一个进制中的数字 00000010
				cur.nexts[path] = cur.nexts[path] == null ? new Node() : cur.nexts[path];
				cur = cur.nexts[path];
			}
		}

		public int maxXor(int num) {
			Node cur = head;
			int res = 0;
			for (int move = 31; move >= 0; move--) {
				int path = (num >> move) & 1;//依次提取出0  or  1   左移 变小
				int best = move == 31 ? path : (path ^ 1);//如果你是符号位  我希望我和你一样，如果不是，我希望值和你反过来
				best = cur.nexts[best] != null ? best : (best ^ 1);  //看看 best这条路是否能走
				res |= (path ^ best) << move; //右移变大，还原该位置，从高到低 设置每一位的值 一开始答案是32位的0 （不包括第一位符号位）
				cur = cur.nexts[best];
			}
			return res;
		}

	}
	//求解异或和  N3
	public static int getMaxE3(int[] arr){
		int max = Integer.MIN_VALUE;
		for (int i = 0; i <arr.length ; i++) {
			for (int start = 0; start <=i ; start++) {
				int res =0;
				for (int j = start; j <=i ; j++) {
					res^=arr[j];
				}
				max=Math.max(max,res);
			}
		}
		return max;

	}

	public static int getMaxE2(int[] arr){
		int max = Integer.MIN_VALUE;
		int n =arr.length;
		int dp[]= new int[n];
		int xor = 0;
		for (int i = 0; i <n ; i++) {
			xor^=arr[i];
			max =Math.max(max,xor);
			for (int start =1 ; start <=i ; start++) {
				int curXor = xor^dp[start-1];//start  to  i 的结果
				max =Math.max(max,xor);
			}
			dp[i]=xor;
		}
		return max;

	}
	public static int getMaxE1(int[] arr){
		if (arr==null||arr.length==0){
			return 0;
		}
		int max =Integer.MAX_VALUE;
		int eor =0;
		NumTrie numTrie =new NumTrie();
		numTrie.add(0);
		for (int i = 0; i <arr.length ; i++) {
			eor^=arr[i]; // 0...i
			max = Math.max(max,numTrie.maxXor(eor));
			numTrie.add(eor);
		}
		return max;
	}


	public static int maxXorSubarray(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int eor = 0;
		NumTrie numTrie = new NumTrie();
		numTrie.add(0);
		for (int i = 0; i < arr.length; i++) {
			eor ^= arr[i];
			max = Math.max(max, numTrie.maxXor(eor));
			numTrie.add(eor);
		}
		return max;
	}

	// for test
	public static int comparator(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int eor = 0;
			for (int j = i; j < arr.length; j++) {
				eor ^= arr[j];
				max = Math.max(max, eor);
			}
		}
		return max;
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 30;
		int maxValue = 50;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr = generateRandomArray(maxSize, maxValue);
			int res = maxXorSubarray(arr);
			int comp = comparator(arr);
			if (res != comp) {
				succeed = false;
				printArray(arr);
				System.out.println(res);
				System.out.println(comp);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
	}
}
