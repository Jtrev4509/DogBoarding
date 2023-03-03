package view;

import dao.DogDao;
import dao.JdbcDogDao;
import dao.JdbcOwnerDao;
import dao.OwnerDao;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class BoardingCLI {

    private final DogDao dogDoa;
    private final OwnerDao ownerDao;
    private Menu menu = new Menu();
    private static DataSource dataSource;

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/DogBoarding");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        BoardingCLI application = new BoardingCLI(dataSource);
        application.run();
    }

    public BoardingCLI(DataSource dataSource){
        dogDoa = new JdbcDogDao(dataSource);
        ownerDao =  new JdbcOwnerDao(dataSource);
    }

    public void run() {
        menu.homeScreenWelcome();
        while (true) {
            String userInput = menu.menuOne();
            if(userInput.equalsIgnoreCase("register dog")){
                menu.addDogDisplay();
            } else if(userInput.equalsIgnoreCase("check existing registration")){
                menu.checkRegistrationDisplay();
            } else if(userInput.equalsIgnoreCase("exit")){
                menu.displayMessage("Thank you!");
                break;
            }
        }
    }
}
