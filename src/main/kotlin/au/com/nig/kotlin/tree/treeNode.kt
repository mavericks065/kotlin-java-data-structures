package au.com.nig.kotlin.tree

data class TreeNode(var value: Int = 0, var left: TreeNode? = null, var right: TreeNode? = null) {
    companion object {
        fun isValidBST(root: TreeNode?): Boolean {
            return isValid(root, null, null)
        }

        private fun isValid(node: TreeNode?, lowLimit: Int?, highLimit: Int?): Boolean {
            if (node == null) {
                return true
            }
            if ((lowLimit != null && node.value <= lowLimit) || (highLimit != null && node.value >= highLimit))
                return false
            return isValid(node.left, lowLimit, node.value) && isValid(node.right, node.value, highLimit)
        }
    }
}
