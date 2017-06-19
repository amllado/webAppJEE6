package amllado.test.cdi.impl;

import amllado.test.cdi.services.CDITestInterface;

public class CDITestImpl implements CDITestInterface {

	@Override
	public String test(String s) {
		return "(CDI) Hello, " + s;
	}

}
