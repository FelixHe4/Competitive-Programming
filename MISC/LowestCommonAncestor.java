package Unit2;

public class LowestCommonAncestor {

	// Lowest Common Ancestor.
	// Given a tree, each node has at most 1 parent.
	// Given 2 nodes, who is their common ancestor.
	// 2 Ways. Euler Tour and Sparse Table or Binary Lifting.
	// Euler Tour. DFS a tree, save the path.
	// Between the first and last time seeing the node. The ones between that are the children of that node.
	// First time a appears and first time b appears. The minimum depth (smallest number) in that interval is the LCA.
	// The better way: Binary Lifting
	// 2D array of LCA
	// Log N Rows, N columns.
	// lca[i][u]
	// at node u, go up 2^i, what is the value.
	// run 1 time dfs. You get the direct parent.
	// Check phone pictures
	// no parent = -1;
	// to get 2^i, go to the 2^i-1 parent first.
	// get that parent, move it to 2^i of the first number.
	// 2 steps would be: go to the parent of your current node. get the parent of the parent node
	// that is your 2 steps.
	// lca[i][u] = lca[i-1][lca[i-1][u]]
	// O(1)
	// 5 steps up? 5 binary is 1 0 1. Therefore, go to parent that is 1 step up, then 3 steps up
	// check if the nodes are on the same depth.
	// From the highest row, see if they are the same. Keep searching lower. Until they are different.
	// Different depths?
	// First make them into the same depth.
	// depth - lower depth
	// lower node at the highest level.
	// Just go the the top value.
	// Loop through the higher value.
	// so LCA of 9 and 6 is basically the LCA of 3 and 6
	// Change u to the new number
	// :blobsweats:
}
