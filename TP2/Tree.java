import java.util.ArrayList;
import java.util.List;

public class Tree {
    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public Integer getRoot() {
        if (root == null) {
            return null;
        }
        return root.getValue();
    }

    public boolean hasElem(Integer elem) {
        return hasElem(this.root, elem);
    }

    private boolean hasElem(TreeNode node, Integer elem) {
        if (node == null) {
            return false;
        }
        if (node.getValue().equals(elem)) {
            return true;
        }
        return hasElem(node.getLeft(), elem) || hasElem(node.getRight(), elem);
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void insert(Integer elem) {
        root = insertABB(root, elem);
    }

    private TreeNode insertABB(TreeNode node, Integer elem) {
        if (node == null) {
            return new TreeNode(elem);
        }
        if (elem < node.getValue()) {
            node.setLeft(insertABB(node.getLeft(), elem));
        } else if (elem > node.getValue()) {
            node.setRight(insertABB(node.getRight(), elem));
        }
        return node;
    }

    /*
    private TreeNode insertAB(TreeNode node, Integer elem){
        if (node == null){
            return new TreeNode(elem);
        }else {
            if(node.getLeft() == null){
                node.setLeft(new TreeNode(elem));
            }
            if (node.getRight() == null){
                node.setRight(new TreeNode(elem));
            }
        }
        return node;
    }*/

    public boolean delete(Integer elem) {
        if (!hasElem(elem)) {
            return false;
        }
        root = delete(root, elem);
        return true;
    }

    private TreeNode delete(TreeNode node, Integer elem) {
        if (node == null) {
            return null;
        }
        if (elem.equals(node.getValue())) {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                node.setValue(getMinValue(node.getRight()));
                node.setRight(delete(node.getRight(), node.getValue()));
            }
        } else if (elem < node.getValue()) {
            node.setLeft(delete(node.getLeft(), elem));
        } else {
            node.setRight(delete(node.getRight(), elem));
        }
        return node;
    }

    private Integer getMinValue(TreeNode node) {
        if (node.getLeft() == null) {
            return node.getValue();
        } else {
            return getMinValue(node.getLeft());
        }
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    }

    public void printPosOrder() {
        printPosOrder(root);
    }

    private void printPosOrder(TreeNode node) {
        if (node != null) {
            printPosOrder(node.getLeft());
            printPosOrder(node.getRight());
            System.out.print(node.getValue() + " ");
        }
    }

    public void printPreOrder() {
        printPreOrder(root);
    }

    private void printPreOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            printPreOrder(node.getLeft());
            printPreOrder(node.getRight());
        }
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(TreeNode node) {
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.print(node.getValue() + " ");
            printInOrder(node.getRight());
        }
    }

    public List<Integer> getLongestBranch() {
        List<Integer> longestBranch = new ArrayList<>();
        if (root == null) {
            return longestBranch;
        }
        getLongestBranch(root, new ArrayList<>(), longestBranch);
        return longestBranch;
    }

    private void getLongestBranch(TreeNode node, List<Integer> currentBranch, List<Integer> longestBranch) {
        currentBranch.add(node.getValue());
        if (node.getLeft() == null && node.getRight() == null) {
            if (currentBranch.size() > longestBranch.size()) {
                longestBranch.clear();
                longestBranch.addAll(currentBranch);
            }
        }
        if (node.getLeft() != null) {
            getLongestBranch(node.getLeft(), new ArrayList<>(currentBranch), longestBranch);
        }
        if (node.getRight() != null) {
            getLongestBranch(node.getRight(), new ArrayList<>(currentBranch), longestBranch);
        }
    }

    public List<Integer> getFrontera() {
        List<Integer> leafNodes = new ArrayList<>();
        if (root == null) {
            return leafNodes;
        }
        getFrontera(root, leafNodes);
        return leafNodes;
    }

    private void getFrontera(TreeNode node, List<Integer> leafNodes) {
        if (node.getLeft() == null && node.getRight() == null) {
            leafNodes.add(node.getValue());
        } else {
            if (node.getLeft() != null) {
                getFrontera(node.getLeft(), leafNodes);
            }
            if (node.getRight() != null) {
                getFrontera(node.getRight(), leafNodes);
            }
        }
    }

    public Integer getMaxElem() {
        if (root == null) {
            return null;
        }
        TreeNode node = root;
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node.getValue();
    }

    private Integer sumInternalNodes(){
        if (root == null) {
            return 0;
        }
        return sumInternalNodes(this.root);
    }

    //Ejecicio 2 -- suma de todos los nodos internos del arbol
    private Integer sumInternalNodes(TreeNode node){
        if (node == null){
            return 0;
        }
        int sum = 0;
        if (node.getLeft() != null || node.getRight() != null){
            sum += node.getValue();
        }
        sum += sumInternalNodes(node.getLeft());
        sum += sumInternalNodes(node.getRight());
        return sum;
    }

    public ArrayList<Integer> getLeavesGreaterThanK(int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (this.root == null) {
            return result;
        }
        getNodesGreater(root, k, result);
        return result;
    }

    //Ejercicio 3 -- dado un arbol binario devuelve un listado con valores de las hojas mayores a k
    private void getNodesGreater(TreeNode node, Integer k, ArrayList<Integer> result){

        if ((node.getLeft() == null && node.getRight() == null) && (node.getValue() > k)) {
            result.add(node.getValue());
        } else {
            if (node.getLeft() != null) {
                getNodesGreater(node.getLeft(), k, result);
            }
            if (node.getRight() != null) {
                getNodesGreater(node.getRight(), k, result);
            }
        }
    }
}
