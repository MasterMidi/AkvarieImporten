package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import db.DBConnection;
import env.ENV;
import exception.DataAccessException;
import util.DateValidator;

public class TestCreateFishPack {
	
	@BeforeClass
	public static void before() throws DataAccessException {
		DBConnection.startConnection(ENV.db_host, ENV.db_port, ENV.db_name, ENV.db_username, ENV.db_password);
	}

	@Test
	public void testValidDate() {
		// arrange
		String date = "2021-01-01";
		
		// act
		boolean res = DateValidator.validateDate(date);
		
		// assert
		assertEquals(res, true);
	}
	
	@Test
	public void testInvalidFormat() {
		// arrange
		String date = "2021.01.01";
		
		// act
		boolean res = DateValidator.validateDate(date);
		
		// assert
		assertEquals(res, false);
	}
	
	@Test
	public void testInvalidYearLong() {
		// arrange
		String date = "20211-01-01";
		
		// act
		boolean res = DateValidator.validateDate(date);
		
		// assert
		assertEquals(res, false);
	}
	
	@Test
	public void testInvalidYearShort() {
		// arrange
		String date = "202-01-01";
		
		// act
		boolean res = DateValidator.validateDate(date);
		
		// assert
		assertEquals(res, false);
	}
	
	@Test
	public void testInvalidYearFuture() {
		// arrange
		String date = "2100-01-01";
		
		// act
		boolean res = DateValidator.validateDate(date);
		
		// assert
		assertEquals(res, false);
	}
	
	@Test
	public void testInvalidYearPast() {
		// arrange
		String date = "1899-01-01";
		
		// act
		boolean res = DateValidator.validateDate(date);
		
		// assert
		assertEquals(res, false);
	}
	
	@Test
	public void testInvalidMonthLong() {
		// arrange
		String date = "2021-111-01";
		
		// act
		boolean res = DateValidator.validateDate(date);
		
		// assert
		assertEquals(res, false);
	}
	
	@Test
	public void testInvalidMonthShort() {
		// arrange
		String date = "2021-1-01";
		
		// act
		boolean res = DateValidator.validateDate(date);
		
		// assert
		assertEquals(res, false);
	}
	
	@Test
	public void testInvalidMonthUnder() {
		// arrange
		String date = "2021-00-01";
		
		// act
		boolean res = DateValidator.validateDate(date);
		
		// assert
		assertEquals(res, false);
	}
	
	@Test
	public void testInvalidMonthOver() {
		// arrange
		String date = "2021-13-01";
		
		// act
		boolean res = DateValidator.validateDate(date);
		
		// assert
		assertEquals(res, false);
	}
	
	@Test
	public void testInvalidDayLong() {
		// arrange
		String date = "2021-01-123";
		
		// act
		boolean res = DateValidator.validateDate(date);
		
		// assert
		assertEquals(res, false);
	}
	
	@Test
	public void testInvalidDayShort() {
		// arrange
		String date = "2021-01-1";
		
		// act
		boolean res = DateValidator.validateDate(date);
		
		// assert
		assertEquals(res, false);
	}
	
	@Test
	public void testInvalidDayOver() {
		// arrange
		String date = "2021-01-32";
		
		// act
		boolean res = DateValidator.validateDate(date);
		
		// assert
		assertEquals(res, false);
	}
	
	@Test
	public void testInvalidDayUnder() {
		// arrange
		String date = "2021-01-00";
		
		// act
		boolean res = DateValidator.validateDate(date);
		
		// assert
		assertEquals(res, false);
	}

}
