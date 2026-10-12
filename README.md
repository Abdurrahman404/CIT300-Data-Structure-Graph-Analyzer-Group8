# Data Structure and Graph Performance Analyzer

## CIT300 – Data Structures and Algorithms
### Graded Practical Assignment 2 – Group 8

The **Data Structure and Graph Performance Analyzer** is a Java console application developed for the CIT300 Data Structures and Algorithms module.

The application demonstrates the implementation and practical use of several important data structures and algorithms without relying on Java's built-in data structure implementations for the main array, stack, queue, and linked-list components.

The project also includes searching algorithms, graph traversal algorithms, and performance measurement features.

---

## Project Status

✅ Project implementation completed  
✅ Individual member features completed  
✅ Feature branches created  
✅ Pull requests merged  
✅ Main branch contains the integrated project  
✅ Project ready for demonstration and submission  

---

## Project Objectives

The main objectives of this project are to:

- Implement fundamental data structures manually.
- Perform different operations on each data structure.
- Implement Linear Search and Binary Search algorithms.
- Implement an undirected graph.
- Perform Breadth-First Search (BFS).
- Perform Depth-First Search (DFS).
- Record algorithm steps and execution time.
- Compare algorithm performance.
- Integrate all components into one Java console application.
- Demonstrate GitHub collaboration using branches, commits, and pull requests.

---

## Features

### 1. Integer Array

The application contains a fixed-capacity integer array implementation.

Supported operations include:

- Insert an element
- Delete an element
- Search for an element
- Display array elements
- Validate array indexes
- Handle array capacity

Implemented in:

`src/IntArray.java`

---

### 2. Stack

The stack follows the **LIFO – Last In, First Out** principle.

Supported operations include:

- Push
- Pop
- Peek
- Display stack
- Check empty condition
- Check full condition
- Handle stack overflow
- Handle stack underflow

Implemented in:

`src/IntStack.java`

---

### 3. Circular Queue

The circular queue follows the **FIFO – First In, First Out** principle.

Supported operations include:

- Enqueue
- Dequeue
- View front element
- Display queue
- Detect full queue
- Detect empty queue
- Reuse available array positions using circular indexing

Implemented in:

`src/CircularQueue.java`

---

### 4. Singly Linked List

A custom singly linked list is implemented to store integer values.

Supported operations include:

- Insert at beginning
- Insert at end
- Delete an element
- Search for an element
- Display linked-list elements
- Maintain head and tail references

Implemented in:

`src/IntLinkedList.java`

---

### 5. Searching Algorithms

The project implements two searching algorithms.

#### Linear Search

Linear Search checks elements one by one until the target value is found.

**Time Complexity:**

- Best Case: `O(1)`
- Worst Case: `O(n)`

#### Binary Search

Binary Search repeatedly divides the search range into two halves.

Binary Search requires the data to be sorted before searching.

**Time Complexity:**

- Best Case: `O(1)`
- Worst Case: `O(log n)`

Implemented in:

- `src/SearchAlgorithms.java`
- `src/SearchResult.java`

The search result stores information such as:

- Search result/index
- Number of steps
- Execution time

---

### 6. Graph

The project contains an undirected graph implementation.

Supported operations include:

- Add vertex
- Add edge
- Search for vertices
- Display graph
- Breadth-First Search
- Depth-First Search

Implemented in:

`src/Graph.java`

---

### 7. Breadth-First Search – BFS

Breadth-First Search explores the graph level by level.

A queue is used during BFS traversal.

**Time Complexity:**

`O(V + E)`

Where:

- `V` = number of vertices
- `E` = number of edges

---

### 8. Depth-First Search – DFS

Depth-First Search explores one path as deeply as possible before backtracking.

The project uses recursive DFS traversal.

**Time Complexity:**

`O(V + E)`

Graph traversal results are represented using:

`src/TraversalResult.java`

---

### 9. Performance Analysis

The application records performance information for searching and graph traversal operations.

Performance information includes:

- Algorithm name
- Number of steps
- Execution time
- Search/traversal results

Implemented in:

`src/PerformanceLog.java`

`System.nanoTime()` is used to obtain execution-time measurements.

The measured time is intended for educational comparison and may vary between computers and program executions.

---

## Final Project Structure

```text
GITHUB_PROJECT/
│
├── src/
│   ├── CircularQueue.java
│   ├── Graph.java
│   ├── IntArray.java
│   ├── IntLinkedList.java
│   ├── IntStack.java
│   ├── Main.java
│   ├── PerformanceLog.java
│   ├── SearchAlgorithms.java
│   ├── SearchResult.java
│   ├── test.txt
│   └── TraversalResult.java
│
└── README.md