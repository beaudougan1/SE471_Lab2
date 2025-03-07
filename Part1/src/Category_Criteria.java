public class Category_Criteria implements FilteringProviderIF{

    @Override
    public Product[] runFiltering(Product[] products, String filter) {
        //create an array to store products size is equal to products.length for worst case scenario of all products meeting criteria
        Product[] filteredProducts = new Product[products.length];
        //loop through the product array
        for (int i = 0; i < products.length; i++) {
            //if the product category is the same add the product to the filtered products list
            //ignore case sensitivity with equalsIgnoreCase()
            if (products[i].getCategory().equalsIgnoreCase(filter)) {
                filteredProducts[i] = products[i];
            }
        }
        //return the array of filtered products
        return filteredProducts;
    }
}
