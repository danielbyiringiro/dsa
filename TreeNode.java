import java.util.ArrayList;
import java.util.List;

/**
 * Represents a node in a tree data structure.
 */

public class TreeNode
{
    private String name;
    private TreeNode parent;
    private boolean isDirectory;
    private String path;
    private List<TreeNode> children;

    /**
     * Constructs a new TreeNode.
     * @param name the name of the node
     * @param path the path of the node
     * @param isDirectory true if the node is a directory, false otherwise
     */

    public TreeNode(String name, String path, boolean isDirectory, TreeNode parent)
    {
        this.name = name;
        this.path = path;
        this.isDirectory = isDirectory;
        this.parent = parent;
        this.children = new ArrayList<TreeNode>();
    }

    /**
     * Gets the name of the node.
     * @return the name of the node
     */

    public String getName()
    {
        return this.name;
    }

    /**
     * Gets the parent of the node.
     * @return the parent of the node
     */

    public TreeNode getParent()
    {
        return this.parent;
    }

    /**
     * Gets the path of the node.
     * @return the path of the node
     */

    public String getPath()
    {
        return this.path;
    }

    /**
     * Gets the children of the node.
     * @return the children of the node
     */

    public List<TreeNode> getChildren()
    {
        return this.children;
    }

    /**
     * Gets the child of the node with the specified name.
     * @param name the name of the child to get
     * @return the child of the node with the specified name
     */

    public TreeNode getChild(String name)
    {
        for (TreeNode child : this.children)
        {
            if (child.getName().equals(name))
            {
                return child;
            }
        }
        return null;
    }

    /**
     * Gets the child of the node with the specified path.
     * @param path the path of the child to get
     * @return the child of the node with the specified path
     */

    public TreeNode getChildByPath(String path)
    {
        for (TreeNode child : this.children)
        {
            if (child.getPath().equals(path))
            {
                return child;
            }
        }
        return null;
    }
   
    /**
     * Adds a child to the node.
     * @param child the child to add
     * @return true if the child was added successfully, false otherwise
     */

    public boolean addChild(TreeNode child)
    {
        if (this.getChild(child.getName()) != null)
        {
            return false;
        }
        else
        {
            child.parent = this;
            this.children.add(child);
            return true;
        }
    }

    /**
     * Removes a child from the node.
     * @param child the child to remove
     * @return true if the child was removed successfully, false otherwise
     */

    public boolean removeChild(TreeNode child)
    {
        if (this.getChild(child.getName()) == null)
        {
            return false;
        }
        else
        {
            child.parent = null;
            this.children.remove(child);
            return true;
        }
    }

    /**
     * Gets a string representation of the node.
     * @return a string representation of the node
     */

    public String toString()
    {
        return this.name;
    }

    /**
     * Set path of the node.
     * @param path the path of the node
     */

    public void setPath(String path)
    {
        this.path = path;
    }

    /**
     * checks if the node is a file
     */ 

    public boolean isFile()
    {
        return !this.isDirectory;
    }


}