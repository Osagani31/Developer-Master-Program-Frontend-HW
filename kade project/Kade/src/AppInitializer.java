import org.w3c.dom.ls.LSOutput;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AppInitializer {
    //===Database Area=====
    static String[][] users = new String[3][2];
    static String [][] items = new String[100][4];
    static String[][]customers = new String[100][4];
    static String[][] orders = new String[100][5];
// create a new array and its length =users.length
    // for loop copy users array to new array
    //


    //===Database Area=====

    public static void main(String[] args) {

        //testing
        items[0][0] = "001";
        items[0][1] = "Desc 1";
        items[0][2] = "15";
        items[0][3] = "250";

        Scanner input = new Scanner(System.in);
        boolean exitstate = false;

        // program initialization
        String[] initializePageQuestions = {
                "1) Do you want to login?",
                "2)Are you new to here?",
                "3)Do you want to exit the page?"
        };
        while (!exitstate) {
            for (String question : initializePageQuestions) {
                System.out.println(question);
            }
            int userInput = input.nextInt();
            switch (userInput) {
                case 1:
                    //just for our testing purposes
                    users[0][0] = "osaganiperera123@gmail.com";
                    users[0][1] = "1234";
                    if (login()) {
                        printUi("Dashboard");
                        openDashboard();
                    }
                    printUi("Application");
                    break;
                case 2:
                    if (register()) {
                        printUi("Dashboard");
                        openDashboard();
                    }
                    printUi("Application");
                    break;
                case 3:
                    System.out.println("Good Bye");
                    return;
                default:

                    System.out.println("Invalid input");
                    return;
            }
        }
    }


    //login process
    public static boolean login() {
        printUi("Login");
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your Email: ");
        String email = input.nextLine();
        System.out.println("Please enter your Password: ");
        String password = input.nextLine();

        for (int i = 0; i < users.length; i++) {
            if (users[i][0] != null && users[i][0].equals(email)) {
                if (users[i][1].equals(password)) {
                    System.out.println("Login Successful");
                    return true;
                } else {
                    System.out.println("wrong password");
                    return false;
                }

            }
        }
        System.out.println("404 not found");
        return false;
    }

    //register process
    public static boolean register() {
        //[free??] ,[1,2,3?]==>empty==>insert
        Scanner input = new Scanner(System.in);

        if (users[users.length - 1][0] != null) {
            System.out.println("User Database is Full!");
            return false;
        }


        System.out.println("Insert your Email:");
        String email = input.nextLine();
        System.out.println("Insert your Password:");
        String password = input.nextLine();

        for (int x = 0; x < users.length; x++) {
            if (users[x][0] == null) {
                users[x][0] = email;
                users[x][1] = password;
                return true;
            } else {
                if (users[x][0].equalsIgnoreCase(email)) {
                    System.out.println("Email already exists!");
                    return false;

                }
            }
        }
        return false;
    }

    public static void openDashboard() {
        System.out.println("Welcome to the dashboard!");
        Scanner input = new Scanner(System.in);
        String dashboardQuestions[] = {
                "1)Customer Management",
                "2)Item Management",
                "3)Order Management",
                "4)Logout"
        };
        while (true) {
            for (String question : dashboardQuestions) {
                System.out.println(question);
            }
            int userInput = input.nextInt();

            switch (userInput) {
                case 1:
                    customerManagement();
                    break;
                case 2:
                    itemManagement();
                    break;
                case 3:
                    placeNewOrder();
                    break;
                case 4:
                    break;
                default:
                    return;
            }
        }




    }


    public static void printUi(String position) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        String simpleDate = dateFormat.format(date);
        String simpleTime = timeFormat.format(date);


        System.out.println("=======" + simpleDate + "===" + simpleTime + "==>" + position);
        // System.out.println("==================@system==========");
    }

    public static void customerManagement() {
        Scanner input=new Scanner(System.in);
        String customerQuestion[]={
                "1)Save Customer ",
                "2)Find Customer",
                "3)Update Customer",
                "4)Delete Customer",
                "5)Find All Customers",
                "6)Back to Home"
        };
        while (true) {
            for(String question : customerQuestion) {
                System.out.println(question);
            }
            int userInput = input.nextInt();
            switch (userInput) {
                case 1:
                    saveCustomer();
                    break;
                case 2:
                    findCustomer();
                    break;
                case 3:
                    updateCustomer();
                    break;
                case 4:
                    deleteCustomer();
                    break;
                case 5:
                    printAllCustomer();
                    break;
                case 6:
                    return;
                default:
                    return;

            }
        }
    }
    public static void saveCustomer() {
        //Customer save
        Scanner input = new Scanner(System.in);
        while(true) {
            String nic, name, address;
            double salary;
            System.out.println("Insert Customer NIC: ");
            nic = input.nextLine();
            System.out.println("Insert Customer Name: ");
            name = input.nextLine();
            System.out.println("Insert Customer Address: ");
            address = input.nextLine();
            System.out.println("Insert Customer Salary: ");
            salary = input.nextDouble();
            input.nextLine();

            mainFor:
            for (int i = 0; i < customers.length; i++) {
                if (customers[i][0] != null) {
                    if (customers[i][1].equals(nic)) {
                        System.out.println("Customer already exists!");
                        break;
                    }
                } else {

                    customers[i][0] = nic;
                    customers[i][1] = name;
                    customers[i][2] = address;
                    customers[i][3] = String.valueOf(salary);

                    System.out.println("Customer Saved!\n");
                    System.out.println("1)Do you want to add another customer?");
                    System.out.println("2)Back to main menu");
                    int option = input.nextInt();
                    input.nextLine();
                    switch (option) {
                        case 1:

                            break mainFor;
                        case 2:
                            return;
                        default:
                            return;

                    }
                    }


                }
            }
        }

    public static void findCustomer() {
        Scanner input = new Scanner(System.in);
        System.out.println("Insert Customer NIC: ");
        String nic = input.nextLine();
        for(int i = 0; i < customers.length; i++) {
            if (customers[i][0] != null) {
                if (customers[i][0].equals(nic)) {
                    System.out.println("Customer found!");
                    System.out.println("NIC: " + customers[i][0]);
                    System.out.println("Name: " + customers[i][1]);
                    System.out.println("Address: " + customers[i][2]);
                    System.out.println("Salary: " + customers[i][3]);
                    System.out.println("---------------------------");
                    return;
                }
            }
        }
        System.out.println("Customer not found!");
    }
    public static void updateCustomer() {
        Scanner input = new Scanner(System.in);
        System.out.println("Insert Customer NIC to find the customer: ");
        String nic = input.nextLine();

        for(int i = 0; i < customers.length; i++) {
            if (customers[i][0] != null) {
                if (customers[i][0].equals(nic)) {
                    String  newName, newAddress;
                    double newSalary;

                    System.out.println("Insert Customer Name to update: ");
                    newName = input.nextLine();
                    System.out.println("Insert Customer Address to update: ");
                    newAddress = input.nextLine();
                    System.out.println("Insert Customer Salary to update: ");
                    newSalary = input.nextDouble();


                    customers[i][1] = newName;
                    customers[i][2] = newAddress;
                    customers[i][3] = String.valueOf(newSalary);
                    System.out.println("Customer Updated!\n");
                    return;
                }
            }
        }
        System.out.println("Customer not found!");

    }

    public static void deleteCustomer() {
        Scanner input = new Scanner(System.in);
        System.out.println("Insert Customer NIC: ");
        String nic = input.nextLine();
        for(int i = 0; i < customers.length; i++) {
            if (customers[i][0] != null) {
                if (customers[i][0].equals(nic)) {
                   customers[i][0] = null;
                   customers[i][1] = null;
                   customers[i][2] = null;
                   customers[i][3] = null;
                    System.out.println("Customer deleted!");
                    return;
                }
            }
        }
        System.out.println("Customer not found!");
    }
public static void printAllCustomer() {
        for (int i = 0; i < customers.length; i++) {
            if(customers[i][0] != null) {
                System.out.println("NIC: " + customers[i][0]+ "\tName:" +customers[i][1] + "\tAddress:" +customers[i][2] + "\tSalary:" +customers[i][3]    );
            }else{
                return;
            }


        }
}

    public static void itemManagement() {

        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("\n1) Add Item");
            System.out.println("2) Find Item");
            System.out.println("3) View All Items");
            System.out.println("4) Back");

            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    addItem();
                    break;

                case 2:
                    findItem();
                    break;

                case 3:
                    viewItems();
                    break;

                case 4:
                    return;
            }
        }
    }

    public static void addItem() {

        Scanner input = new Scanner(System.in);

        System.out.println("Item Code:");
        String code = input.nextLine();

        System.out.println("Description:");
        String desc = input.nextLine();

        System.out.println("Qty:");
        String qty = input.nextLine();

        System.out.println("Price:");
        String price = input.nextLine();

        for (int i = 0; i < items.length; i++) {

            if (items[i][0] == null) {

                items[i][0] = code;
                items[i][1] = desc;
                items[i][2] = qty;
                items[i][3] = price;

                System.out.println("Item Added");
                return;
            }
        }
    }

    public static void findItem() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter Item Code:");
        String code = input.nextLine();

        for (int i = 0; i < items.length; i++) {

            if (items[i][0] != null && items[i][0].equals(code)) {

                System.out.println(
                        items[i][0] + " | " +
                                items[i][1] + " | " +
                                items[i][2] + " | " +
                                items[i][3]);

                return;
            }
        }

        System.out.println("Item not found");
    }

    public static void viewItems() {

        for (int i = 0; i < items.length; i++) {

            if (items[i][0] != null) {

                System.out.println(
                        items[i][0] + " | " +
                                items[i][1] + " | " +
                                items[i][2] + " | " +
                                items[i][3]);
            }
        }
    }
    public static void orderManagement() {

        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("\n1) Place Order");
            System.out.println("2) View Orders");
            System.out.println("3) Back");

            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    placeNewOrder();
                    break;

                case 2:
                    viewOrders();
                    break;

                case 3:
                    return;
            }
        }
    }

    public static void placeNewOrder() {

        Scanner input = new Scanner(System.in);

        System.out.println("Order ID:");
        String orderId = input.nextLine();

        System.out.println("Customer NIC:");
        String nic = input.nextLine();

        System.out.println("Item Code:");
        String code = input.nextLine();

        double unitPrice = 0;

        for (int i = 0; i < items.length; i++) {

            if (items[i][0] != null && items[i][0].equals(code)) {

                unitPrice = Double.parseDouble(items[i][3]);
            }
        }

        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String orderDate = f.format(date);

        for (int i = 0; i < orders.length; i++) {

            if (orders[i][0] == null) {

                orders[i][0] = orderId;
                orders[i][1] = nic;
                orders[i][2] = code;
                orders[i][3] = orderDate;
                orders[i][4] = String.valueOf(unitPrice);

                System.out.println("Order placed successfully");
                return;
            }
        }
    }

    public static void viewOrders() {

        for (int i = 0; i < orders.length; i++) {

            if (orders[i][0] != null) {

                System.out.println(
                        orders[i][0] + " | " +
                                orders[i][1] + " | " +
                                orders[i][2] + " | " +
                                orders[i][3] + " | " +
                                orders[i][4]);
            }
        }
    }
}


