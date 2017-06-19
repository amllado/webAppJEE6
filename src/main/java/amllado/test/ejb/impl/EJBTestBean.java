package amllado.test.ejb.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import amllado.test.ejb.services.EJBTestService;

@Stateless
@EJB(beanInterface = EJBTestService.class, beanName="EJBTestBean", name="EJBTestBean")
public class EJBTestBean implements EJBTestService {

	@Override
	public String test(String s) {
		return "(EJB) Hello, " + s;
	}

}
