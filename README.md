# Data Structure and Graph Performance Analyzer

**CIT300 – Data Structures and Algorithms | Graded Practical Assignment 2 | Group 8**

A Java console application demonstrating fundamental data structures, searching algorithms, graph traversals, and algorithm performance analysis through a single menu-driven system.

## Project Information

| Detail | Information |
|---|---|
| Institution | Sri Lanka Technological Campus (SLTC) |
| Module | CIT300 – Data Structures and Algorithms |
| Assignment | Graded Practical Assignment 2 |
| Group | 8 |
| Application | Java console application |
| Technology | Java, Object-Oriented Programming, Git and GitHub |

## Group Members, Responsibilities and Individual Contributions

| Student Name | Student ID | Assigned Responsibility | Individual Contribution |
|---|---|---|---|
| **B.M. Abdurrahman (Group Leader)** | **23DA2-0574** | Graph, performance comparison, main menu and system integration | Developed the adjacency-list graph with vertex/edge operations, BFS and DFS; added traversal results, performance comparison and result history; connected all modules through the main menu and handled system integration. |
| **M.A.R. Raheeqa Fajr** | **23DA2-1095** | Array and searching | Developed array insertion, deletion, search and display operations; implemented linear and binary search, search-result reporting, step counts and input validation for array operations. |
| **M.I. Safa** | **23DA2-511** | Linked list | Developed the singly linked list with head/tail references, insertion at the beginning and end, deletion by value, searching, display and missing-value handling. |
| **AH Hima** | **23DA2-1096** | Stack and queue | Developed the array-based stack and circular queue with push, pop, peek, enqueue, dequeue, display, circular indexing and empty/full handling. |

### Assigned Source Files

| Team Member | Java Files |
|---|---|
| B.M. Abdurrahman | `Main.java`, `Graph.java`, `TraversalResult.java`, `PerformanceLog.java` |
| M.A.R. Raheeqa Fajr | `IntArray.java`, `SearchAlgorithms.java`, `SearchResult.java` |
| M.I. Safa | `IntLinkedList.java` |
| AH Hima | `IntStack.java`, `CircularQueue.java` |

*The contribution descriptions should match each member's actual work and GitHub history. Confirm all names and student IDs against official records before submission.*

## Project Objectives

- Implement arrays, stacks, queues and linked lists using Java classes.
- Demonstrate insertion, deletion, searching and display operations.
- Compare linear search and binary search.
- Implement an undirected graph and demonstrate BFS and DFS traversal.
- Explain algorithm efficiency using step counts, elapsed time and Big-O complexity.
- Provide clear menus, input validation and handling of invalid operations.
- Integrate every component into one console application.

## Features

| Component | Supported Functionality |
|---|---|
| **Array** | Insert at index, delete at index, search and display |
| **Stack** | Push, pop, peek and display (LIFO) |
| **Circular Queue** | Enqueue, dequeue, peek/front and display (FIFO) |
| **Linked List** | Insert at beginning/end, delete by value, search and display |
| **Searching** | Linear search, binary search on a sorted copy and search comparison |
| **Graph** | Add vertices and undirected edges, display adjacency lists, check vertex membership, BFS and DFS |
| **Performance** | Search/traversal comparisons, operation counts, elapsed-time measurements and complexity explanations |
| **Integration** | Main menu, component submenus, result history and input validation |

### Input Handling

The application checks menu selections, array indexes, fixed-capacity limits, empty stacks and queues, missing values, and invalid graph operations such as duplicate vertices/edges, self-loops or missing endpoints.

## Project Folder Structure

```text
CIT300-Data-Structure-Graph-Analyzer/
├── src/
│   ├── Main.java
│   ├── IntArray.java
│   ├── SearchAlgorithms.java
│   ├── SearchResult.java
│   ├── IntStack.java
│   ├── CircularQueue.java
│   ├── IntLinkedList.java
│   ├── Graph.java
│   ├── TraversalResult.java
│   └── PerformanceLog.java
└── README.md
```

The repository contains the `src/` folder with the Java source code and this `README.md` documentation file. No additional project folders or launcher scripts are needed.

## Requirements and Running the Application

A **Java Development Kit (JDK) 8 or later** is required. Run these commands from the project root.

**Windows (Command Prompt):**

```bat
mkdir out
javac -encoding UTF-8 -d out src\*.java
java -cp out Main
```

**Linux / macOS:**

```bash
mkdir -p out
javac -encoding UTF-8 -d out src/*.java
java -cp out Main
```

The `out/` directory is generated locally when the code is compiled; it is not part of the submitted source folder structure. If `out/` already exists, there is no need to recreate it.

## Main Menu

| Option | Function |
|---|---|
| 1 | Array Operations |
| 2 | Stack Operations |
| 3 | Queue Operations |
| 4 | Linked List Operations |
| 5 | Searching Operations |
| 6 | Graph Operations |
| 7 | Performance Comparison |
| 8 | Display All Results |
| 9 | Exit |
| 10 | Reset and Load Demo Data |

The array, stack and circular queue use a fixed demonstration capacity of **10**. Data is maintained in memory during a running session.

## Example Operations

**Array:** Insert `50`, `10`, `40`, `20` and `30`. Linear search checks values sequentially, while binary search operates on an ascending sorted copy.

**Stack:** Push `10`, `20`, `30`; peek returns `30`, and pop removes `30` (Last In, First Out).

**Queue:** Enqueue `100`, `200`, `300`; dequeue removes `100` (First In, First Out).

**Linked list:** Insert `5`, `15`, `25`, then insert `1` at the head. The list becomes `1 -> 5 -> 15 -> 25`.

**Graph:** Example vertices are Main Gate, Library, Computer Lab, Cafeteria and Student Center, connected by undirected edges:

```text
Main Gate -- Library
Main Gate -- Cafeteria
Library -- Computer Lab
Library -- Student Center
```

With edges added in the order shown, traversals from Main Gate are:

```text
BFS: Main Gate -> Library -> Cafeteria -> Computer Lab -> Student Center
DFS: Main Gate -> Library -> Computer Lab -> Student Center -> Cafeteria
```

## Performance and Time Complexity

| Operation / Algorithm | Time Complexity |
|---|---|
| Array insertion or deletion at an arbitrary index | O(n) worst case |
| Stack push, pop and peek | O(1) |
| Circular queue enqueue, dequeue and peek | O(1) |
| Linked-list insertion at head or tail | O(1) |
| Linked-list search or deletion by value | O(n) worst case |
| Linear search | O(n) worst case |
| Binary search on sorted data | O(log n) worst case |
| BFS and DFS with an adjacency list | O(V + E) |

`n` is the number of elements, `V` is the number of vertices, and `E` is the number of edges. Binary search requires sorted input, so the cost of preparing a sorted copy is separate from the binary-search operation. Nanosecond timing measurements are illustrative and may vary between runs.

## GitHub Collaboration

Team members work on their assigned components in separate branches, make meaningful commits and use pull requests where applicable. The integrated Java application is maintained in the `main` branch. Each member is responsible for explaining their own implementation during the group demonstration.

## Conclusion

The **Data Structure and Graph Performance Analyzer** brings arrays, stacks, circular queues, linked lists, searching algorithms, graph traversal and performance comparisons together in one Java console program. It demonstrates key Data Structures and Algorithms concepts while supporting modular development and team collaboration.
