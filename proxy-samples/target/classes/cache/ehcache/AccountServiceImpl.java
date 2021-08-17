package cache.ehcache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Component
public class AccountServiceImpl implements AccountService {
	@PersistenceContext
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see cache.AccountService#findAccountCached(long)
	 */
	@Override
	@Cacheable(value="accounts", key="#id")
	public Account findAccountCached(long id) {
		Query query = entityManager.createQuery("from Account a where a.id=:id").setParameter("id", id);
		return (Account) query.getSingleResult();
	}
	

	
	/* (non-Javadoc)
	 * @see cache.AccountService#findAccountNotCached(long)
	 */
	@Override
	public Account findAccountNotCached(long id) {
		Query query = entityManager.createQuery("from Account a where a.id=:id").setParameter("id", id);
		return (Account) query.getSingleResult();
	}
	

}