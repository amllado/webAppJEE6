package amllado.test.ejb.services;

import javax.ejb.Local;

@Local
public interface EJBTestService {

	String test(String s);
	String getItemName(Integer id);
	
}
