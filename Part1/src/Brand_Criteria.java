public class Brand_Criteria implements FilteringProviderIF{

    @Override
    public Product[] runFiltering(Product[] products, String filter) {
        //create an array to store products size is equal to products.length for worst case scenario of all products meeting criteria
        Product[] filteredProducts = new Product[products.length];
        //create a count variable to store the current position in the array
        int count = 0;
        //loop through the product array
        for (int i = 0; i < products.length; i++) {
            //if the product brand is the same add the product to the filtered products list
            //ignore case sensitivity with equalsIgnoreCase()
            if (products[i].getBrand().equalsIgnoreCase(filter)) {
                filteredProducts[count] = products[i];
                count++;
            }
        }
        //if count is 0 return null symbolizing that the array is empty
        if (count == 0) {
            return null;
        }
        //return the array of filtered products
        return filteredProducts;
    }
}
