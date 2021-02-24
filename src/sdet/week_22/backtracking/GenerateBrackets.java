package sdet.week_22.backtracking;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
*/

public class GenerateBrackets {
	@Test
	public void test1() {
		System.out.println(generateParenthesis(2));
	}

	public List<String> generateParenthesis(int n) {
		List<String> lst = new ArrayList<>();
		recursive(n,lst,new StringBuilder(),0,0);
		return lst;
	}
	public void recursive(int n, List<String> lst,StringBuilder str,int open,int close){
		if(close>open){
			return;
		} else if(close==n && open==n){
			lst.add(str.toString());
			return;
		}
		if(open<n){
			str.append("(");
			open++;
			recursive(n,lst,str,open,close);
			str.deleteCharAt(str.length()-1);
			open--;
		}
		if(close<n){
			str.append(")");
			close++;
			recursive(n,lst,str,open,close);
			str.deleteCharAt(str.length()-1);
			close--;
		}
	}
}
