package com.sg.booktracker;

import com.sg.booktracker.controller.BookController;
import com.sg.booktracker.dao.BookDao;
import com.sg.booktracker.dao.BookDaoMemoryImpl;
import com.sg.booktracker.service.BookService;
import com.sg.booktracker.ui.BookView;
import com.sg.booktracker.ui.UserIO;
import com.sg.booktracker.ui.UserIOConsoleImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Kyle David Rudy
 */
public class App {

    public static void main(String[] args) {
//        UserIO io = new UserIOConsoleImpl();
//        BookView view = new BookView(io);
//        
//        BookDao dao = new BookDaoMemoryImpl();
//        BookService service = new BookService(dao);
//        
//        BookController controller = new BookController(service, view);
        ApplicationContext appContext = new ClassPathXmlApplicationContext(
                "classpath:applicationContext.xml");
        BookController controller = appContext.getBean("controller", BookController.class);
        controller.run();
    }
}
