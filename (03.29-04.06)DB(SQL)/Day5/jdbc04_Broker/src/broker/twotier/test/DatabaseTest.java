package broker.twotier.test;

import java.util.ArrayList;
import java.util.Vector;

import broker.twotier.dao.Database;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.SharesRec;
import broker.twotier.vo.StockRec;

public class DatabaseTest {

	public static void main(String[] args)throws Exception{
		
		Database db = new Database("127.0.0.1");
//		db.addCustomer(new CustomerRec("999-999", "라바리", "다매동"));
//		db.deleteCustomer("777-777");
//		db.updateCustomer(new CustomerRec("777-777", "하바리1", "약수동1"));
//		
//		ArrayList<SharesRec> v = db.getPortfolio("999-999");
//		for(SharesRec sr : v)System.out.println(v);
		ArrayList<StockRec> v = db.getAllStocks();
		
	}

}
