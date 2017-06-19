package amllado.test.ejb.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import amllado.test.ejb.services.EJBTestService;
import amllado.test.models.TestEntity;

@Stateless
@EJB(beanInterface = EJBTestService.class, beanName="EJBTestBean", name="EJBTestBean")
public class EJBTestBean implements EJBTestService {
    
    @PersistenceContext
    private EntityManager entityManager;

	@Override
	public String test(String s) {
		return "(EJB) Hello, " + s;
	}

    @Override
    public String getItemName(Integer id) {
        Query q = entityManager.createQuery("select test from TestEntity test where test.id = :id");
        return ((TestEntity)q.setParameter("id", id).getSingleResult()).getName();
    }	

}
