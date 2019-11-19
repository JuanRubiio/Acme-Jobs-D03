
package acme.features.administrator.investorrecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investorRecord.InvestorRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorInvestorRecordRepository extends AbstractRepository {

	@Query("select ua from InvestorRecord ua")
	Collection<InvestorRecord> findAllInvestorRecords();

	@Query("select ua from InvestorRecord ua where ua.id = ?1")
	InvestorRecord findOneById(int id);

}
