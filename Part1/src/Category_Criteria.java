public class Category_Criteria implements FilteringProviderIF{

    @Override
    public Product[] runFiltering(Product[] products, String filter) {
        //create an array to store products size is equal to products.length for worst case scenario of all products meeting criteria
        Product[] filteredProducts = new Product[products.length];
        //create a count variable to store current position in the array
        int count = 0;
        //loop through the product array
        for (int i = 0; i < products.length; i++) {
            //if the product category is the same add the product to the filtered products list
            //ignore case sensitivity with equalsIgnoreCase()
            if (products[i].getCategory().equalsIgnoreCase(filter)) {
                filteredProducts[count] = products[i];
                count++;
            }
        }
        //if count is 0 no objects match return a null array
        if (count == 0) {
            return null;
        }
        //return the array of filtered products
        return filteredProducts;
    }
}
