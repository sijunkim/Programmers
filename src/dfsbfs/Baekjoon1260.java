package dfsbfs;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.management.Query;

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
      if (a > b) {
        setEdge(a, b);
      } else {
        setEdge(b, a);
      }
    }

    adjacentSort();

    // dfsR(V);
    bfs(V);
    System.out.println();

    scanner.close();
  }

  void adjacentSort() {
    for (Node node : nodes) {
      node.adjacent.sort((o1, o2) -> o1.data - o2.data);
    }
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
    System.out.print(node.data + " ");
  }

  void dfs(int v) {
    Stack<Node> stack = new Stack<>();
    stack.push(nodes[v - 1]);

    while (!stack.isEmpty()) {
      Node node = stack.pop();
      for (Node n : node.adjacent) {
        if (n.mark == false) {
          stack.push(n);
        }
        break;
      }
      node.mark = true;
      printNode(node);
    }
  }

  void dfsR(int v) {
    if (nodes[v - 1] == null) {
      return;
    } else {
      Node node = nodes[v - 1];
      node.mark = true;
      printNode(node);
      for (Node n : node.adjacent) {
        if (n.mark == false) {
          dfsR(n.data);
        }
      }
    }
  }

  void bfs(int v) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(nodes[v - 1]);
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      node.mark = true;
      printNode(node);
      for (Node n : node.adjacent) {
        if (n.mark == false) {
          n.mark = true;
          queue.add(n);
        }
      }
    }
  }
}
