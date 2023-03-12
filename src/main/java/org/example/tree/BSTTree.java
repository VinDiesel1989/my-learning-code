package org.example.tree;

public class BSTTree {

    /**
     * 新增节点
     *
     * @param root
     * @param data
     * @return
     */
    Node insert(Node root, int data) {
        if (root == null) {
            root = getNewNode(data);
            return root;
        } else if (data <= root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    /**
     * 查找值
     *
     * @param root
     * @param data
     * @return
     */
    boolean search(Node root, int data) {
        if (root == null) {
            return false;
        } else if (root.data == data) {
            return true;
        } else if (data <= root.data) {
            return search(root.left, data);
        } else {
            return search(root.right, data);
        }
    }

    /**
     * 创建节点
     *
     * @param data
     * @return
     */
    public Node getNewNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = null;
        node.right = null;
        return node;
    }


    // 遍历二叉树： 深入优先方式
    //在深度优先的策略中，访问左子树，右子树和跟节点的相对次序可以是不同的。
    //比如：可以先访问右子树，然后是根，然后是左子树。 反之亦然
    //或者可以先访问根节点，然后是左子树，然后是右子树
    //按照惯例：左子树总是先于右子树进行访问

    //以下方法：是一个以深度优先，然后进行前序遍历的方法

    //递归的栈增长取决于：树的最大深度或者高度，可以说内存空间正比于树的高度，
    //或者这个算法的空间复杂度是O(h)， h是树的高度

    /**
     * 深度优先-前序遍历
     * <p>
     * root - left - right
     *
     * @param rootNode
     */
    public void preOrder(Node rootNode) {
        if (rootNode == null) {
            return;
        }
        System.out.println(rootNode.data);
        preOrder(rootNode.left);
        preOrder(rootNode.right);
    }

    /**
     * 深度优先 - 中序遍历
     * <p>
     * left - root - right
     *
     * @param rootNode
     */
    public void inOrder(Node rootNode) {
        preOrder(rootNode.left);
        System.out.println(rootNode.data);
        preOrder(rootNode.right);
    }

    /**
     * 深度优先 - 后序遍历
     * <p>
     * left - right - root
     *
     * @param rootNode
     */
    public void postOrder(Node rootNode) {
        preOrder(rootNode.left);
        preOrder(rootNode.right);
        System.out.println(rootNode.data);
    }


    //判断二叉树
    // 定义：每个节点的左子树上的节点都比它小，如果允许重复节点值，那左子树小于等于该节点值
    //每个节点的右子树上的节点都比它大。
    // 可以用递归的方式来定义一颗二叉树，左字数中的元素必须小于等于当前节点，右子树中的元素必须大于
    //这一点对于所有节点都成立，而不仅仅是根节点。
    //对于左边和右边的子树来说，它们本身也应该是一颗二叉搜索树

    /**
     * 判断是否是二叉树
     *
     * @param root
     * @return
     */
    public boolean isBinarySearchTree(Node root) {
        //满足条件检查必须是：左子树小于当前节点，右子树大于当前节点
        //而且每个节点都必须要做上面左右子树的检查
        //递归检查：退出 -> 但检查节点等于null 时退出
        if (root == null) {
            return true;
        }
        if (isSubtreeLesser(root.left, root.data)
                && isSubtreeGreater(root.right, root.data)
                // 左右孩子节点都要进行同样的检查 并且满足条件
                && isBinarySearchTree(root.left)
                && isBinarySearchTree(root.right)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断给定值是否小于节点
     *
     * @param root
     * @param value
     * @return
     */
    public boolean isSubtreeLesser(Node root, int value) {
        if (root == null) return true;
        if (root.data <= value
                //这两个条件是检查 当前当前节点的 左右孩子节点值 比根节点（祖父节点）小
                && isSubtreeLesser(root.left, value)
                && isSubtreeLesser(root.right, value)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断给定值是否大于节点
     *
     * @param root
     * @param value
     * @return
     */
    public boolean isSubtreeGreater(Node root, int value) {
        if (root == null) return true;
        if (root.data > value
                && isSubtreeGreater(root.left, value)
                && isSubtreeGreater(root.right, value)) {
            return true;
        } else {
            return false;
        }
    }

    //递归方式判断二叉树 是遍历每个节点 并且进行条件计算判断，成本非常高
    //另外一种方式可以降低执行判断成本：
    //我们可以为 每一个节点定义一个允许的范围值，这个节点的数据必须在那个范围
    //比如：从根节点开始（负无穷 - 正无穷），假如根节点是 7 ，在为其他节点设置范围
    //我们向左时，左孩节点数据范围是（负无穷 - 7   ），因为左孩节点不能比根节点大
    //我们向右时，右孩节点的数据范围时（7 - 正无穷，7不包含）
    //根据这个逻辑，我们不检查左子树的所有元素 是否小于根节点，右子树的所有元素是否大于根节点
    //

    /**
     * 判断是否是二叉树
     *
     * @param root
     * @param minValue
     * @param maxValue
     * @return
     */
    private boolean isBstUtil(Node root, int minValue, int maxValue) {
        if (root == null) return true;
        if (root.data >= minValue
                && root.data < maxValue
                //左孩节点：下限是minValue, 上限是当前节点数据
                && isBstUtil(root.left, minValue, root.data)
                //右孩节点：下限 minValue 是当前节点数据，上限是maxValue
                && isBstUtil(root.right, root.data, maxValue)) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 最小值
     */
    int INT_MIN = 8;
    /**
     * 最大值(不包含)
     */
    int INT_MAX = 26;

    /**
     * 判断是否是二叉树
     *
     * @param root
     * @return
     */
    public boolean isBinarySearchTree2(Node root) {
        return isBstUtil(root, INT_MIN, INT_MAX);
    }

    /**
     * 节点
     */
    class Node {
        int data;
        Node left;
        Node right;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }


    //删除节点：
    //1. 在删除任何节点的情况下，都必须要保证 所有节点左子树小于节点本身，右子树大于节点本身
    //2. 删除时需要处理两件事情：（1）要从它的父节点移除对该节点的引用，从而使该节点从树中分离；（2）回收被删除节点的内存；

    // 节点情况：
    //
    // 场景1. 如果是叶子节点，我们只需要断开节点链接，然后将节点从内存中擦除即可。

    // 场景2. 如果要删除一个仅有一个孩子的节点，或者删除一个仅有一颗子树的节点。 那么我们只要将父节点和它唯一的孩子节点链接起来，
    //然后将它从内存中擦除即可。
    //
    //场景3. 如果一个节点有两个孩子的情况该怎么处理？
    //（1）让场景3退化到场景1或场景2
    //（2）查看这个节点的右子树中的最小值，然后将最小值填入到当前节点
    //但为什么是右子树的最小值，为什么不是其他叶子节点的值，或者其他的只有一个孩子的节点？因为：我们还需要保持这样的属性，就是对于每个节点，左边的节点必须较小，右边的节点必须较大
    //备注：在一颗树或者子树中，如果一个节点有最小值，那说明这个节点不会有左孩。相反：如果它有左孩，那么它就有更小的节点。这是我们利用的另一个属性特征。
    //稍微想一下，在一颗树或者子树中，值最小的那个节点是没有左孩的，可能也没有右孩，如果我们有一个右孩，像是这里我们有一个右孩。因此这里我们把场景3降为了
    //场景2。 如果没有孩子的话我们把场景3降为了场景1

    //场景3的操作步骤：
    //第一种： find min data in right-subtree -> copy the value in target node -> delete duplicate from right-subtree
    //第二种： find max data in left-subtree -> copy the value in target node -> delete duplicate from left-subtree
    //如果我们挑的是一颗树或者子树的最大值，那么这个节点将没有右孩，因为如果右边有东西的话，那么就有东西比它更大了，那么这个值就不会是最大值，这个节点可能有左孩，因此
    //基本上就是把场景3将为了场景1

    /**
     * 删除节点
     *
     * @param root
     * @param data
     * @return
     */
    public Node delete(Node root, int data) {
        if (root == null) return null;
        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            //场景1. 如果是叶子节点，我们只需要断开节点链接，然后将节点从内存中擦除即可。
            if (root.left == null && root.right == null) {
                root = null;
                //场景2. 如果要删除一个仅有一个孩子的节点，或者删除一个仅有一颗子树的节点。 那么我们只要将父节点和它唯一的孩子节点链接起来，
            } else if (root.left == null) {
                //先保存当前节点的地址
                Node temp = root;
                //根节点往右边移动
                root = root.right;
                temp = null;
            } else if (root.right == null) {
                Node temp = root;
                root = root.left;
                temp = null;
            } else {
                //场景3. 如果一个节点有两个孩子的情况
                Node temp = findMin(root.right);
                root.data = temp.data;
                root.right = delete(root.right, temp.data);
            }
        }
        return root;
    }

    /**
     * 找到最小节点
     *
     * @param root
     * @return
     */
    public Node findMin(Node root) {
        if (root.left == null) return root;
        return findMin(root.left);
    }


    //二叉搜索树的中序后继节点
    //问题：给定一个二叉搜索树的节点，我们要找到它的中序后继者，也就是在二叉搜索树的
    //中序遍历中紧跟着那个节点的下一个节点。
    //回顾：我们知道在二叉树的中序遍历中，我们首先访问左子树，然后是根节点，然后是右子树。
    //左右子树是按照递归的方式来访问的。
    // in-order
    //1.visit left-subtree
    //2.visit  root
    //3.visit right-subtree

    //中序遍历的时间复杂度是 O(n)，这里 n 是树的节点数量，因为遍历花费的时间正比于树的节点数
    // 常规中序遍历需要经过每个节点，花费成本高。如果想要做的更好一些，因为找到某个数据的下一个或者上一个元素，
    //可能是相当频繁的操作。
    //对于二叉搜索树来说，好消息就是一些频繁的操作比如插入，删除，查找，它们的时间复杂度都是O(h)， h是树的高度。
    //因此我们可以用O(h)来找到后继和前驱，那花费成本就低了很多。
    //一颗平衡二叉树的高度是log2^n

    //O(logn) 是我们能够得到的最好时间复杂度


    //如何查找后继节点：
    //1.我们想要找到它的中序后继，对于一颗二叉搜索树。它将会是这颗树中的下一个比它大的值。
    //2.如果有右子树，那么中序后继将会是它的右子树最左边的节点，在一颗BST中，将会是右子树的最小值，
    //这种场景下，我们需要做的就是，我们需要在左右树上尽量往左。

    //3.如果没有右子树的话，它的后继是什么呢？
    //如果节点没有右子树，我们需要来到最近的祖先，给定的节点将会位于这个祖先的左子树中。（注意给定节点必须是在最近祖先节点的 左子树中）
    //满足这个条件的 就是该节点的中序后继节点

    //问题：我们如何从一个节点来到它的父节点？
    // 使用一个域来存放数据，然后两个节点指针，增加另外一个域来存放父节点地址， 然后通过父节点来走访 就没问题，这样可以轻松访问祖先节点。
    //但是如果没有父节点的链接呢？
    // 这种情况下我们能做的是，我们可以从根节点开始，然后从根节点开始走访到给定节点。
    //然后就是 同样的查找逻辑

    //如果节点没有右子树，我们需要来到最近的祖先，给定的节点将会位于这个祖先的左子树中。（注意给定节点必须是在最近祖先节点的 左子树中）
    //满足这个条件的 就是该节点的中序后继节点

    class Node2 {
        Integer data;
        Node left;
        Node right;
        Node parent;
    }

    /**
     * 中序后继节点查询
     *
     * @param root
     * @param data
     * @return
     */
    public Node getSuccessor(Node root, int data) {
        Node current = find(root, data);
        if (current == null) return null;
        //2.如果有右子树，那么中序后继将会是它的右子树最左边的节点，在一颗BST中，将会是右子树的最小值，
        //这种场景下，我们需要做的就是，我们需要在左右树上尽量往左。
        if (current.right != null) {
            Node rightSubTreeMinNode = findMin(root.right);
            return rightSubTreeMinNode;
        } else {
            Node successor = null;

            Node ancestor = root;
            while (ancestor != current) {
                if (current.data < ancestor.data) {
                    successor = ancestor;
                    ancestor = ancestor.left;
                } else {
                    ancestor = ancestor.right;
                }
            }
            return successor;
        }
    }


    /**
     * 根据值查询节点
     *
     * @param root
     * @param data
     * @return
     */
    public Node find(Node root, int data) {
        if (root == null) {
            return null;
        } else if (root.data == data) {
            return root;
        } else if (data < root.data) {
            return find(root.left, data);
        } else {
            return find(root.right, data);
        }
    }


    public static void main(String[] args) {
        BSTTree bstTree = new BSTTree();
        Node root = null;

//        root = bstTree.insert(root, 15);
//        root = bstTree.insert(root, 10);
//        root = bstTree.insert(root, 20);
//        root = bstTree.insert(root, 25);
//        root = bstTree.insert(root, 8);
//        root = bstTree.insert(root, 12);
//        root = bstTree.insert(root, 24);
//        root = bstTree.insert(root, 23);
//        root = bstTree.insert(root, 21);
//
//        int data = 20;
//        boolean find = bstTree.search(root, data);
//        System.out.println(MessageFormat.format("树中搜索值 {0} 结果：{1}", data, find));
//        System.out.println("\n");
//
//        System.out.println("深度优先-前序遍历：");
//        bstTree.preOrder(root);
//
//        System.out.println("\n");
//        System.out.println("是否是二叉树：" + bstTree.isBinarySearchTree(root));
//
//        System.out.println("\n");
//        System.out.println("是否是二叉树：" + bstTree.isBinarySearchTree2(root));
//
//        System.out.println("\n 删除 12");
//        bstTree.delete(root, 12);
//
//        System.out.println("\n");
//        System.out.println("深度优先-前序遍历：");
//        bstTree.preOrder(root);
//
//        System.out.println("\n");
//        System.out.println("是否是二叉树：" + bstTree.isBinarySearchTree2(root));


        root = bstTree.insert(root, 15);
        root = bstTree.insert(root, 10);
        root = bstTree.insert(root, 20);
        root = bstTree.insert(root, 12);
        root = bstTree.insert(root, 6);
        root = bstTree.insert(root, 11);
        root = bstTree.insert(root, 20);
        root = bstTree.insert(root, 17);
        root = bstTree.insert(root, 16);
        root = bstTree.insert(root, 25);
        root = bstTree.insert(root, 27);
        System.out.println("\n");
        System.out.println("深度优先-中序遍历：");
        bstTree.inOrder(root);

        System.out.println("\n找到最小值：");
        Node minNode = bstTree.findMin(root);
        System.out.println(minNode.data);

        System.out.println("\n中序后继节点查找");
        Node node1 = bstTree.getSuccessor(root, 6);
        System.out.println(node1.data);
    }
}
