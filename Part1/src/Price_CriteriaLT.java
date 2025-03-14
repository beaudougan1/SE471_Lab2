public class Price_CriteriaLT implements FilteringProviderIF{

    @Override
    public Product[] runFiltering(Product[] products, String filter) {
        //create an array to store products size is equal to products.length for worst case scenario of all products meeting criteria
        Product[] filteredProducts = new Product[products.length];
        //create count variable to store current position in filtered array
        int count = 0;
        //convert the filter given to a double value
        double filterPrice = Double.parseDouble(filter);
        //loop through the array of products
        for (int i = 0; i < products.length; i++) {
            //check if the product price is less than or equal to the price to filter
            if (products[i].getPrice() <= filterPrice) {
                //add product that fits criteria to the filtered products list
                filteredProducts[count] = products[i];
                count++;
            }
        }
        //return null if nothing added to array
        if(count == 0){
            return null;
        }
        return filteredProducts;
    }
}
