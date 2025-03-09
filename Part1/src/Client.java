import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        //create a scanner for user input
        Scanner scanner = new Scanner(System.in);
        //create products for filter testing
        Product one = new Product("123", "Dish Soap", 2.99, "Dawn", "Cleaning", 4.38);
        Product two = new Product("124", "Laundry Detergent", 7.99, "Tide", "Cleaning", 3.47);
        Product three = new Product("125", "Tide Pods", 12.99, "Tide", "Cleaning", 4.24);
        Product four = new Product("126" , "Double Chunk Chocolate Cookie", 3.99, "Kirkland", "Food", 0.68);
        Product five = new Product("127", "Chicken Bake", 4.99, "Kirkland", "Food", 2.56);
        Product six = new Product("128", "Boom", 0.00, "Kirkland", "Boom", 5.00);
        //put products into an array
        Product[] products = {one, two, three, four, five, six};
        //create a filteringProviderIF to filter products
        FilteringProviderIF filter;
        //create an array of filtered products to store the filtered products into
        Product[] filteredProducts;
        //ask user to enter what criteria they would like to use
        System.out.print("Enter the number of what criteria you would like to sort the products with\n" +
                "1. Brand\n" +
                "2. Category\n" +
                "3. Customer Rating\n" +
                "4. Price\n" +
                "Enter the number of what criteria you would like to sort by: ");
        int choice = scanner.nextInt();
        //using cases perform the operation the user requested
        switch(choice){
            //case 1 brand
            case 1:
                //set filter to brand criteria ask user for the name of the brand and run the filtering process
                filter = new Brand_Criteria();
                System.out.print("Enter the name of the brand: ");
                String brand = scanner.next();
                filteredProducts = filter.runFiltering(products, brand);
                break;
            case 2:
                //set filter to category criteria ask the user for a category name and run the filtering process
                filter = new Category_Criteria();
                System.out.print("Enter the name of the category: ");
                String category = scanner.next();
                filteredProducts = filter.runFiltering(products, category);
                break;
            case 3:
                //ask user if they would like to find products with customer ratings greater than or equal to or less than or equal to the rating given
                System.out.print("Should the customer rating be greater or less than the value you will enter\n"
                + "1. Greater than or equal to\n"
                + "2. Less than or equal to\n");
                int brandDecision = scanner.nextInt();
                //if user wants greater than create a gt version of customer rating else create lt version of customer rating
                if(brandDecision == 1){
                    filter = new Customer_Rating_CriteriaGT();
                }
                else{
                    filter = new Customer_Rating_CriteriaLT();
                }
                //prompt the user for the customer rating they would like filtered and set filtered products to the result of the filtering
                System.out.print("Enter the customer rating to run the filter on: ");
                String rating = scanner.next();
                filteredProducts = filter.runFiltering(products, rating);
                break;
            case 4:
                //ask user if they would like to find products with prices greater than or equal to or less than or equal to the price given
                System.out.print("Should the price be greater or less than the value you will enter\n"
                        + "1. Greater than or equal to\n"
                        + "2. Less than or equal to\n");
                int priceDecision = scanner.nextInt();
                //if user wants greater than create a gt version of price criteria else create lt version of price criteria
                if(priceDecision == 1){
                    filter = new Price_CriteriaGT();
                }
                else{
                    filter = new Price_CriteriaLT();
                }
                //prompt the user for the price they would like filtered and set filtered products to the result of the filtering
                System.out.print("Enter the price to run the filter on: ");
                String price = scanner.next();
                filteredProducts = filter.runFiltering(products, price);
                break;
            default:
                //if user enters an invalid choice print a message to them and show that filtered products is null
                System.out.println("Invalid choice");
                filteredProducts = null;
                break;
        } //exit case switch
        //check that the user made a valid choice for the first menu
        if(filteredProducts != null){
            //print all products matching the criteria by sifting through the array for nonnull elements
            System.out.println("Products matching the criteria: ");
            for(Product product : filteredProducts){
                if(product != null){
                    System.out.println(product.getName());
                }
            }
        }
        else{
            System.out.println("No products found matching the criteria");
        }
    }
}