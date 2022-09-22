package dfsbfs;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
  int data = 0;
  boolean mark = false;
  LinkedList<Node> adjacent = new LinkedList<>();
}

class Baekjoon1260 {
  Node[] nodes;

  public static void main(String[] args) {
    new Baekjoon1260().solution();
  }

  void solution() {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt(); // 정점 개수
    int M = scanner.nextInt(); // 간선 개수
    int V = scanner.nextInt(); // 시작 정점

    // 노드 설정
    nodes = new Node[N];
    for (int i = 1; i <= N; i++) {
      nodes[i - 1] = new Node();
      nodes[i - 1].data = i;
    }

    // 간선 설정
    for (int i = 0; i < M; i++) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      setEdge(a, b);
    }

    dfs(V);

    scanner.close();
  }

  void setEdge(int a, int b) {
    Node node1 = nodes[a - 1];
    Node node2 = nodes[b - 1];
    if (!node1.adjacent.contains(node2)) {
      node1.adjacent.add(node2);
    }
    if (!node2.adjacent.contains(node1)) {
      node2.adjacent.add(node1);
    }
  }

  void printNode(Node node) {
    System.out.print(node.data);
  }

  void dfs(int v) {
    Node startNode = nodes[v - 1];
    printNode(startNode);

    Stack<Node> stack = new Stack<>();
    stack.push(startNode);

    while (!stack.isEmpty()) {
      Node node = stack.pop();
      for (Node n : node.adjacent) {
        stack.push(n);
      }
      System.out.print(node.data);
    }
  }

  void bfs() {

  }
}
