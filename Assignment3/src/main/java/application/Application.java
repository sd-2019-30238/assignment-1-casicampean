package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        /*ApplicationContext context =*/ SpringApplication.run(Application.class, args);
        /*AccountService accountService = context.getBean(AccountService.class);
        BookService bookService = context.getBean(BookService.class);
        BorrowedBookService borrowedBookService = context.getBean(BorrowedBookService.class);
        borrowedBookService.printAccounts();
        borrowedBookService.printAccounts();

        //accountService.printAccounts();
       // accountService.deleteAccount(24);

        //accountService.updateAccountType(4, "staff");
        //accountService.printAccounts();
        //System.out.println(accountService.existsAccount(2));

*/
    }

}
