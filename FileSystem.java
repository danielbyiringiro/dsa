import java.util.HashMap;
import java.util.Stack;

/**
 * This class represents a file system.
 * It contains methods to add, delete, move, and search for files and directories.
 * It also contains methods to display the file system and show the current directory.
 */

public class FileSystem
{
    private TreeNode root;
    private HashMap<String, TreeNode> map;
    private TreeNode currentDirectory;

    /**
     * Constructs a new FileSystem.
     */
    public FileSystem()
    {
        this.root = new TreeNode("root", "/", true, null);
        this.map = new HashMap<String, TreeNode>();
        this.map.put(root.getPath(), this.root);
        this.currentDirectory = this.root;
    }

    /**
     * create a method to add a file to the file system
     * @param File the file to add
     * @return true if the file was added successfully, false otherwise
     */

    public boolean add(File file)
    {
        if (search(file.getName()) != null)
        {
            return false;
        }
        else
        {
            String resolvedPath = resolve(file.getPath());
            if (resolvedPath == null)
            {
                 return false;
            }
            else
            {
                TreeNode parent = this.map.get(resolvedPath);
                parent.addChild(file);
                this.map.put(file.getName(), file);
                return true;
            }
        }
    }


    /**
     * create a method to add a directory to the file system
     * @param Directory the directory to add
     * @return true if the directory was added successfully, false otherwise
     */

    public boolean add(Directory directory)
    {
        if (search(directory.getName()) != null)
        {
            return false;
        }
        else
        {
            String resolvedPath = resolve(directory.getPath());
            if (resolvedPath == null)
            {
                return false;
            }
            else
            {
                TreeNode parent = this.map.get(resolvedPath);
                parent.addChild(directory);
                this.map.put(directory.getName(), directory);
                return true;
            }
        }
    }

    /**
     * create a method to delete a file or directory from the file system
     * @param name the name of the file or directory to delete
     * @return true if the file or directory was deleted successfully, false otherwise
     */

    public boolean delete(String name)
    {
        if (search(name) == null)
        {
            return false;
        }
        else
        {
            TreeNode node = this.map.get(name);
            TreeNode parent = node.getParent();
            parent.removeChild(node);
            this.map.remove(name);
            return true;
        }
    }

    /**
     * create a method to move a file or directory to a new path
     * @param name the name of the file or directory to move
     * @param path the new path of the file or directory
     * @return true if the file or directory was moved successfully, false otherwise
     */

    public boolean move(String name, String path)
    {
        if (search(name) == null)
        {
            return false;
        }
        else
        {
            String resolvedPath = resolve(path);
            if (resolvedPath == null)
            {
                return false;
            }
            else
            {
                TreeNode node = this.map.get(name);
                TreeNode parent = node.getParent();
                parent.removeChild(node);
                node.setPath(resolvedPath);
                parent = this.map.get(resolvedPath);
                parent.addChild(node);
                return true;
            }
        }
    }

    /**
     * create a method to display the file system
     */

    public void displayFileSystem()
    {
        displayFileSystemHelper(this.root, "");
    }

    /**
     * create a helper method to display the file system
     * @param node the current node
     * @param indent the indentation level
     */

    private void displayFileSystemHelper(TreeNode node, String indent)
    {
        System.out.println(indent + node.getName() + (node.isFile() ? " (File)" : " (Directory)"));
        for (TreeNode child : node.getChildren())
        {
            displayFileSystemHelper(child, indent + "    ");
        }
    }

    /**
     * create a method to show the current directory
     * @param path the path of the current directory
     */

    public void showCurrentDirectory(String path)
    {
        String resolvedPath = resolve(path);
        if (resolvedPath == null)
        {
            System.out.println("Invalid path.");
        }
        else
        {
            TreeNode node = this.map.get(resolvedPath);
            System.out.println("Current directory: " + node.getName());
        }
    }

    /** 
    * create a path resolution method using a stack
    * @param path the path to resolve
    * @return the resolved path
    */

    public String resolve(String path)
    {
        String[] pathArray = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < pathArray.length; i++)
        {
            if (pathArray[i].equals(".."))
            {
                stack.pop(); // Go up one level in the directory hierarchy
            }
            else if (pathArray[i].equals("."))
            {
                continue; // Ignore the current directory
            }
            else
            {
                stack.push(pathArray[i]); // Push the directory name onto the stack
            }
        }
        String resolvedPath = "";
        while (!stack.isEmpty())
        {
            resolvedPath = "/" + stack.pop() + resolvedPath; // Build the resolved path by concatenating directory names
        }
        return resolvedPath;
    }

    /**
     * create a search method using a hash map
     * @param name the name of the file or directory to search for
     * @return the path of the file or directory if found, null otherwise
     */

    public String search(String name)
    {
        if (this.map.containsKey(name))
        {
            return this.map.get(name).getPath();
        }
        else
        {
            return null;
        }
    }

    /**
     * return the path of the current working directory
     * @return the path of the current working directory
     */

    public String getCurrentDirectoryPath()
    {
         return this.currentDirectory.getPath();
    }

    /**
     * return the current working directory
     * @return the current working directory
     */

    public TreeNode getCurrentDirectory()
    {
        return this.currentDirectory;
    }
}