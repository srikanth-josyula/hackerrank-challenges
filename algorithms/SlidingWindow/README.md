# Sliding Window Technique Explained

The **sliding window technique** is a common approach used to solve problems that involve arrays or strings, where you need to find subarrays or substrings that satisfy certain conditions. It works by maintaining a "window" of elements that slides over the data structure, often with two pointers, to reduce the time complexity of brute-force solutions.

---

## Key Idea
- The sliding window maintains a range or "window" of elements that satisfy a given condition.
- Instead of recalculating things from scratch each time (as in brute force), the window slides by adjusting pointers, and you update the result incrementally.

---

## When to Use Sliding Window?
The sliding window technique is especially useful in problems where:
1. You need to find subarrays or substrings of fixed or variable length.
2. You need to check conditions that depend on multiple elements (e.g., sum, product, or uniqueness).
3. The problem can be reduced to solving it with a contiguous range of elements (subarray).

---

## Types of Sliding Window Problems

### 1. **Fixed Size Window**:
   - The window size remains constant.
   - Example: Finding the maximum sum of a subarray of size `k`.

### 2. **Variable Size Window**:
   - The window size changes dynamically based on the condition.
   - Example: Finding the longest substring with at most `k` distinct characters.

---

## Steps to Solve Using Sliding Window

1. **Understand the Problem**:
   - What is the condition you need to check? 
   - What should the "window" represent (subarray, substring)?
   
2. **Initialize Pointers**:
   - Typically, two pointers (`start` and `end`) are used. `start` represents the beginning of the window, and `end` represents the current end.
   - For fixed-size windows, both pointers will advance together.
   
3. **Expand the Window**:
   - Move the `end` pointer to expand the window and include new elements.
   - When the window size or condition is violated, adjust the `start` pointer.

4. **Shrink the Window (if needed)**:
   - If the current window doesn't satisfy the condition, move the `start` pointer to shrink the window.

5. **Update the Result**:
   - Track the result (maximum sum, minimum length, etc.) as the window slides.

-
