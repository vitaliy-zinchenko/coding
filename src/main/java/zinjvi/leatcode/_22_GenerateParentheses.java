package zinjvi.leatcode;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _22_GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        if(n == 0) {
            return Collections.emptyList();
        }

        List<String> result = new LinkedList<>();
        generate(result, "", n, 0);
        return result;
    }

    private static void generate(List<String> result, String base, int toOpen, int toClose) {
        if(toOpen == 0 && toClose == 0) {
            result.add(base);
        }
        if(toOpen > 0) {
            generate(result, base + "(", toOpen - 1, toClose + 1);
        }
        if(toClose > 0) {
            generate(result, base + ")", toOpen, toClose - 1);
        }
    }

    public static void main(String[] args) {
        Assert.assertTrue(generateParenthesis(0).isEmpty());

        Assert.assertThat(
                generateParenthesis(1),
                CoreMatchers.hasItems("()"));

        Assert.assertThat(
                generateParenthesis(3),
                CoreMatchers.hasItems("((()))", "(()())", "(())()", "()(())", "()()()"));

        Assert.assertThat(
                generateParenthesis(4),
                CoreMatchers.hasItems(
                        "(((())))",
                        "((()()))",
                        "((())())",
                        "((()))()",
                        "(()(()))",
                        "(()()())",
                        "(()())()",
                        "(())(())",
                        "(())()()",
                        "()((()))",
                        "()(()())",
                        "()(())()",
                        "()()(())",
                        "()()()()"));
    }
}
