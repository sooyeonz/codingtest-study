package week5.yeeunSim;

import java.util.Arrays;

public class n25_TreeTraversal {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5, 6, 7})));
    }

    private static String[] solution(int[] nodes) {
        String[] result = new String[3];
        result[0] = preorder(nodes, 0).trim(); // 마지막 공백 제거
        result[1] = inorder(nodes, 0).trim(); // 마지막 공백 제거
        result[2] = postorder(nodes, 0).trim(); // 마지막 공백 제거
        return result;
    }

    // 전위 (부 -> 왼 -> 오)
    private static String preorder(int[] nodes, int idx) {
        if (idx >= nodes.length) { // idx가 범위를 벗어나면 빈 문자열 반환
            return "";
        }

        // nodes[idx]는 항상 현재 서브 트리의 루트(부모)를 의미
        // " "의 위치는 nodes[idx]가 더해지는 위치와 함께 움직이고, 문자열이 정확하게 구성되도록 한다
        return nodes[idx] + " " + preorder(nodes, idx * 2 + 1) + preorder(nodes, idx * 2 + 2);
    }

    // 중위 (왼 -> 부 -> 오)
    private static String inorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }

        // nodes[idx]는 항상 현재 서브 트리의 루트(부모)를 의미
        // " "의 위치는 nodes[idx]가 더해지는 위치와 함께 움직이고, 문자열이 정확하게 구성되도록 한다
        return inorder(nodes, idx * 2 + 1) + nodes[idx] + " " + inorder(nodes, idx * 2 + 2);
    }

    // 후위 (왼 -> 오 -> 부)
    private static String postorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }

        // nodes[idx]는 항상 현재 서브 트리의 루트(부모)를 의미
        // " "의 위치는 nodes[idx]가 더해지는 위치와 함께 움직이고, 문자열이 정확하게 구성되도록 한다
        return postorder(nodes, idx * 2 + 1) + postorder(nodes, idx * 2 + 2) + nodes[idx] + " ";
    }
}
