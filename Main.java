import java.util.Scanner;

public class Main 
{

    private FileSystem fileSystem;
    
    /**
     * Constructs a new Main.
     */

    public Main()
    {
        fileSystem = new FileSystem();
    }

    /**
     * Program Menu.
     */

    public void menu()
    {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        do
        {
            System.out.println("Welcome to the File System!");
            System.out.println("Please select an option:");
            System.out.println("1. Create a file");
            System.out.println("2. Create a directory");
            System.out.println("3. Delete a file");
            System.out.println("4. Delete a directory");
            System.out.println("5. Search for a file or directory");
            System.out.println("6. Resolve a path");
            System.out.println("7. Display the file system");
            System.out.println("8. Show the current directory");
            System.out.println("9. Exit");
            option = scanner.nextInt();
    
            switch (option)
            {
                case 1:
                    createFile();
                    break;
                case 2:
                    createDirectory();
                    break;
                case 3:
                    deleteFile();
                    break;
                case 4:
                    deleteDirectory();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    resolve();
                    break;
                case 7:
                    displayFileSystem();
                    break;
                case 8:
                    showCurrentDirectory();
                    break;
                case 9:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
                    scanner.close();
                    break;
            }
        } 
        while (option != 9);

    }

    /**
     * Create a file.
     */

    public void createFile()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the file:");
        String name = scanner.nextLine();
        System.out.println("Enter the content of the file:");
        String content = scanner.nextLine();
        File newFile = new File(name, fileSystem.getCurrentDirectoryPath(), content, fileSystem.getCurrentDirectory());
        if (fileSystem.add(newFile))
        {
            System.out.println("File created successfully.");
        }
        else
        {
            System.out.println("File creation failed.");
        }
        
        scanner.close();
    }

    /**
     * Create a directory.
     */

    public void createDirectory()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the directory:");
        String name = scanner.nextLine();
        Directory newDirectory = new Directory(name, fileSystem.getCurrentDirectoryPath(), fileSystem.getCurrentDirectory());
        if (fileSystem.add(newDirectory))
        {
            System.out.println("Directory created successfully.");
        }
        else
        {
            System.out.println("Directory creation failed.");
        }
        
        scanner.close();
    }

    /**
     * Delete a file.
     */

    public void deleteFile()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the file:");
        String name = scanner.nextLine();
        if (fileSystem.delete(name))
        {
            System.out.println("File deleted successfully.");
        }
        else
        {
            System.out.println("File deletion failed.");
        }
        
        scanner.close();
    }

    /**
     * Delete a directory.
     */

    public void deleteDirectory()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the directory:");
        String name = scanner.nextLine();
        if (fileSystem.delete(name))
        {
            System.out.println("Directory deleted successfully.");
        }
        else
        {
            System.out.println("Directory deletion failed.");
        }
        
        scanner.close();
    }

    /**
     * Search for a file or directory.
     */

    public void search()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the file or directory:");
        String name = scanner.nextLine();
        if (fileSystem.search(name) != null)
        {
            System.out.println("File or directory found.");
        }
        else
        {
            System.out.println("File or directory not found.");
        }
        
        scanner.close();
    }

    /**
     * Resolve a path.
     */

    public void resolve()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path:");
        String path = scanner.nextLine();
        if (fileSystem.resolve(path) != null)
        {
            System.out.println("Path resolved.");
        }
        else
        {
            System.out.println("Path not resolved.");
        }
        
        scanner.close();
    }

    /**
     * Display the file system.
     */

    public void displayFileSystem()
    {
        fileSystem.displayFileSystem();
    }

    /**
     * Show the current directory.
     */

    public void showCurrentDirectory()
    {
        System.out.println(fileSystem.getCurrentDirectory());
    }

    /**
     * Main method.
     */

    public static void main(String[] args)
    {
        Main main = new Main();
        main.menu();
    }
}