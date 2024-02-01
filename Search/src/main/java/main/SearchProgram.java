
package main;

import view.MenuView;
import controller.Algorithm;


public class SearchProgram {
    public static void main(String[] args) {
        MenuView menuView = new MenuView();
        Algorithm searchController = new Algorithm();

        int[] arr = {2, 4, 6, 8, 10, 12, 142, 16, 18, 20}; 

        while (true) {
            int choice = menuView.showMainMenu();

            switch (choice) {
                case 1:
                    int target1 = menuView.getInputValue();
                    int binarySearchResult = searchController.binarySearch(arr, target1);
                    if (binarySearchResult != -1) {
                        System.out.println("Tim thay gia tri " + target1 + " tai vi tri " + binarySearchResult);
                    } else {
                        System.out.println("Khong tim thay gia tri " + target1);
                    }
                    break;

                case 2:
                    int target2 = menuView.getInputValue();
                    int linearSearchResult = searchController.linearSearch(arr, target2);
                    if (linearSearchResult != -1) {
                        System.out.println("Tim thay gia tri " + target2 + " tai vi tri " + linearSearchResult);
                    } else {
                        System.out.println("Khong tim thay gia tri " + target2);
                    }
                    break;

                case 3:
                    System.out.println("Exit.");
                    System.exit(0);

                default:
                    System.out.println("Lua chon khong hop le, chon lai !1"
                            + "");
            }
        }
    }
}
    

