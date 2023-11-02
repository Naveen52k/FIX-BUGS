import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to TheDesk \n");
        System.out.println("**************************************");
        optionsSelection();
    }

    private static void optionsSelection() {
        String[] arr = {
            "1. I wish to review my expenditure",
            "2. I wish to add my expenditure",
            "3. I wish to delete my expenditure",
            "4. I wish to sort the expenditures",
            "5. I wish to search for a particular expenditure",
            "6. Close the application"
        };
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int slen = arr1.length;
        for (int i = 0; i < slen; i++) {
            System.out.println(arr[i]);
        }

        ArrayList<Integer> expenses = new ArrayList<Integer>();
        expenses.add(1000);
        expenses.add(2300);
        expenses.add(45000);
        expenses.add(32000);
        expenses.add(110);

        System.out.print("\nEnter your choice: ");
        Scanner sc = new Scanner(System.in);
        int options = sc.nextInt();

        switch (options) {
            case 1:
                System.out.println("Your saved expenses are listed below: ");
                System.out.println(expenses);
                optionsSelection();
                break;
            case 2:
                System.out.println("Enter the value to add your Expense: ");
                int value = sc.nextInt();
                expenses.add(value);
                System.out.println("Your value is updated.");
                System.out.println(expenses);
                optionsSelection();
                break;
            case 3:
                System.out.println("You are about to delete all your expenses! Confirm by selecting the same option: ");
                int con_choice = sc.nextInt();
                if (con_choice == options) {
                    expenses.clear();
                    System.out.println("All your expenses are erased!");
                } else {
                    System.out.println("Oops... try again!");
                }
                optionsSelection();
                break;
            case 4:
                sortExpenses(expenses);
                optionsSelection();
                break;
            case 5:
                searchExpenses(expenses);
                optionsSelection();
                break;
            case 6:
                closeApp();
                break;
            default:
                System.out.println("You have made an invalid choice!");
        }
    }

    private static void closeApp() {
        System.out.println("Closing your application... Thank you!");
    }

    private static void searchExpenses(ArrayList<Integer> arrayList) {
        int leng = arrayList.size();
        System.out.println("Enter the expense you need to search: ");
        Scanner scanner = new Scanner(System.in);
        int expenseToSearch = scanner.nextInt();

        boolean found = false;

        for (int i = 0; i < leng; i++) {
            if (arrayList.get(i) == expenseToSearch) {
                System.out.println("Expense found at index " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Expense not found in the list.");
        }
    }

    private static void sortExpenses(ArrayList<Integer> arrayList) {
        int n = arrayList.size();
        for (int i = 1; i < n; i++) {
            int key = arrayList.get(i);
            int j = i - 1;

            while (j >= 0 && arrayList.get(j) > key) {
                arrayList.set(j + 1, arrayList.get(j));
                j--;
            }

            arrayList.set(j + 1, key);
        }
    }

    }

