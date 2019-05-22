package application;

import application.model.Account;
import application.model.Book;
import application.model.BorrowedBooks;
import application.service.AccountService;
import application.service.BookService;
import application.service.BorrowedBookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

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
