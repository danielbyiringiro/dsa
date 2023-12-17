import java.util.ArrayList;
import java.util.List;

public class TreeNode <T>
{
    private T data;
    private TreeNode<T> parent;
    private List<TreeNode<T>> children;

    public TreeNode(T data, TreeNode<T> parent, Boolean isDirectory)
    {
        this.data = data;
        this.parent = parent;
        
        if (!isDirectory)
        {
            children = null;
        }

        else
        {
            children = new ArrayList<>();
        }
    }

    // getters

    public T getData()
    {
        return data;
    }

    public TreeNode<T> getParent()
    {
        return parent;
    }

    public List<TreeNode<T>> getChildren()
    {
        return children;
    }

    // setters

    public void setData(T data)
    {
        this.data = data;
    }

    public void setParent(TreeNode<T> parent)
    {
        this.parent = parent;
    }

    public void addChild(TreeNode<T> child)
    {
        if(!(children == null))
        {
            this.children.add(child);
        }
        else
        {
            System.out.println("Files cant have children");
        }
    }

    public static void main(String[] args)
    {
        File file = new File("hello.py", "print('Hello World')\nfor i in range(5):\n    print(i)");
        TreeNode<File> root = new TreeNode<>(file, null, false);
    }
}
