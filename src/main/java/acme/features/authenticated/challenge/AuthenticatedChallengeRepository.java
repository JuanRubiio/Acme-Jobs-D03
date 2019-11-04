/*
 * AnonymousUserAccountRepository.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.authenticated.challenge;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.challenges.Challenge;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedChallengeRepository extends AbstractRepository {

	/* Cuidado con meter en el sample-data ejemplos para el deadline, ya que tienen que ser futuros al actual */
	@Query("select c from Challenge c where c.deadline > now()")
	Collection<Challenge> findActivesChallenges();

	@Query("select c from Challenge c")
	Collection<Challenge> findAllChallenges();

	@Query("select c from Challenge c where c.id = ?1")
	Challenge findOneById(int id);

}
