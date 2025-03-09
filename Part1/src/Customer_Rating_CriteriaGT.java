public class Customer_Rating_CriteriaGT implements FilteringProviderIF{
    @Override
    public Product[] runFiltering(Product[] products, String filter) {
        //create an array to store products size is equal to products.length for worst case scenario of all products meeting criteria
        Product[] filteredProducts = new Product[products.length];
        //create count to store current position in filtered array
        int count = 0;
        //convert the filter given to a double value
        double filterRating = Double.parseDouble(filter);
        //loop through the array of products
        for (int i = 0; i < products.length; i++) {
            //check if the products rating is greater than or equal to the rating to filter
            if (products[i].getCustomerRating() >= filterRating) {
                //add product that fits criteria to the filtered products list
                filteredProducts[count] = products[i];
                count++;
            }
        }
        //if count = 0 return null
        if (count == 0) {
            return null;
        }
        return filteredProducts;
    }
}
