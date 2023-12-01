public class File extends TreeNode
{
    private String content;

    // Constructor

    public File(String name, String path, String content, TreeNode parent)
    {
        super(name, path, false, parent);
        this.content = content;
    }

    // Methods

    /**
     * Gets the content of the file.
     * @return the content of the file
     */

    public String getContent()
    {
        return this.content;
    }

    /**
     * Sets the content of the file.
     * @param content the content of the file
     */

    public void setContent(String content)
    {
        this.content = content;
    }
    
}
