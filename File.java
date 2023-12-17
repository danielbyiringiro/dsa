public class File 
{
    private String name;
    private String content;

    public File(String name, String content) 
    {
        this.name = name;
        this.content = content;
    }

    public String getName() 
    {
        return name;
    }

    public String getContent()
    {
        return content;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public static void main(String[] args)
    {
        File file = new File("hello.py", "print('Hello World')\nfor i in range(5):\n    print(i)");
        System.out.println(file.getName());
        System.out.println(file.getContent());
    }
}
