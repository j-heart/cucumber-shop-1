package ku.shop;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyStepdefs {

    private ProductCatalog catalog;
    private Order order;

    @Before
    public void setup() {
        catalog = new ProductCatalog();
        order = new Order();
    }
    @Given("a product {string} with price {float} exists")
    public void a_product_with_price_exists(String name, double price) {
        catalog.addProduct(name, price);
    }

    @Given("a product {string} with price {float} and {int} quantity exists")
    public void a_product_with_price_and_quantity_exists(String name, double price, int quantity) {
        catalog.addProduct(name, price, quantity);
    }

    @When("I buy {string} with quantity {int}")
    public void i_buy_with_quantity(String name, int quantity) throws NotEnough {
        Product prod = catalog.getProduct(name);
        order.addItem(prod, quantity);
    }

    @Then("total should be {float}")
    public void total_should_be(double total) {
        assertEquals(total, order.getTotal());
    }

    @Then("{string} quantity should be {int}")
    public void stock_should_be(String product, int quantity) {assertEquals(quantity, catalog.getProduct(product).getQuantity());}
}