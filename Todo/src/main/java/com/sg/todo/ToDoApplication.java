package com.sg.todo;

import com.sg.todo.dao.ToDoSQLDao;
import com.sg.todo.dao.ToDoSQLTemplateDao;
import java.sql.SQLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(ToDoSQLDao.class, args);
	}

}
