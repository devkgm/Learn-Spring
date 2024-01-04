package com.devkgm.app;

import static org.junit.Assert.*;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DBConnectTest extends Mytest{

	@Autowired
	private DataSource dataSource;
	
	@Test
	public void connectTest() throws Exception{
		Connection connection = dataSource.getConnection();
		assertNotNull(connection);
	}
}
