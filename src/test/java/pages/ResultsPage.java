package pages;


import Base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends BaseUtil{

    public ResultsPage(WebDriver driver) {
        super(driver);
    }
    public ArrayList<Item> items = new ArrayList<Item>();
    private Connection connection;
    private static Statement statement;
    private static ResultSet rs;


    @FindAll({@FindBy(xpath = "//i[contains(@class,'middle-popularity')]//ancestor::div[3]//div[@class='g-price-uah']")})
    private List<WebElement> prices_top_sales;
    @FindAll({@FindBy(xpath = "//i[contains(@class,'middle-popularity')]//ancestor::div[3]//div[contains(@class,'i-title')]/a")})
    private List<WebElement> names_top_sales;
    @FindAll({@FindBy(xpath = "//a[@class='novisited paginator-catalog-l-link']")})
    private List<WebElement> link_next_page;




    public void  addToArray() {
        for (int i = 0; i < prices_top_sales.size(); i++) {
            items.add( new Item( prices_top_sales.get(i).getText(), names_top_sales.get(i).getText()));
        }
    }
    public void addToArrayFromResult(int pages){
        for (int p=0; p<pages-1; p++){
            addToArray();
            link_next_page.get(p).click();
        }
        addToArray();
    }

    public void setUpDataBase() {
        String databaseURL = "jdbc:mysql://localhost:3306/rozetka";
        String user = "root";
        String password = "root";
        connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to Database...");
            connection = DriverManager.getConnection(databaseURL, user, password);
            if (connection != null) {
                System.out.println("Connected to the Database...");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
     public void tearDownDataBase() {
        if (connection != null) {
            try {
                System.out.println("Closing Database Connection...");
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void save() throws SQLException {
        try {
            String query = "INSERT INTO top_sellers (name, price) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            System.out.println("Inserting to DB started...");
            for (Item item : items) {
                ps.setString(1, item.getName());
                ps.setString(2, item.getPrice());
                ps.addBatch();
            }
            ps.executeBatch();
            System.out.println("Inserting to DB finished...");
        } catch(BatchUpdateException b) {

        }
    }


}
