package amllado.test.jsf;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import amllado.test.cdi.services.CDITestInterface;
import amllado.test.ejb.services.EJBTestService;
import amllado.test.models.TestEntity;

@ManagedBean(name="testManagedBean")
public class TestManagedBean {
    
    @Inject
    CDITestInterface cdiTestInterface;
    
    @EJB
    EJBTestService ejbTestService;
    
    private TestEntity test;

    /**
     * @return the test
     */
    public TestEntity getTest() {
        return test;
    }

    /**
     * @param test the test to set
     */
    public void setTest(TestEntity test) {
        this.test = test;
    }
    
    @PostConstruct
    public void init() {
        this.test = new TestEntity();
    }
    
    public String getTextoTest() {
        
        StringBuilder test = new StringBuilder();
        
        try {
            test.append(cdiTestInterface.test(ejbTestService.getItemName(1)));
            test.append("<br/>");
            test.append(ejbTestService.test(ejbTestService.getItemName(1)));
            throw new RuntimeException("Error controlado de prueba");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
        }
        
        return test.toString();
        
    }
    
    public String getItemName(Integer id) {
        String name = null;
        try {
            name = ejbTestService.getItemName(id);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
        }
        return name;
    }

}
