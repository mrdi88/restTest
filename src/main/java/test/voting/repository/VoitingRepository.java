/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.voting.domain.Voting;

/**
 *
 * @author Dima
 */
public interface VoitingRepository extends JpaRepository<Voting, Long> {
    Voting findById(long id);
}