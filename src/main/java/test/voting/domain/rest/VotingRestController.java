/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.voting.domain.rest;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import test.voting.domain.Option;
import test.voting.domain.Voting;
import test.voting.domain.VotingState;
import test.voting.repository.VoitingRepository;

/**
 *
 * @author Dima
 */
@RestController
@RequestMapping("/voting")
public class VotingRestController {

    private final VoitingRepository voitingRepository;

    @Autowired
    VotingRestController(VoitingRepository voitingRepository) {
        this.voitingRepository = voitingRepository;
    }
    
    //get voting list
    @RequestMapping(method = RequestMethod.GET, value = "/")
    List<Voting> showAllVotings() {
        return voitingRepository.findAll();
    }
    
    //get voting by id 
    @RequestMapping(method = RequestMethod.GET, value = "/{votingId}")
    Voting saveVoting(@PathVariable Long votingId) {
        return voitingRepository.findOne(votingId);
    }
    
    //new or update voting   Admin
    @RequestMapping(method = RequestMethod.PUT, value = "/")
    Voting addVoting(@RequestBody Voting input) {
        return  voitingRepository.save(input);
    }
    
    //vote
    @RequestMapping(method = RequestMethod.PUT, value = "/{votingId}")
    boolean vote(@PathVariable Long votingId, @RequestBody Option input) {
        Voting voting = voitingRepository.findOne(votingId);
        //vote if voting is started
        if (voting.getState() == VotingState.START) {
            Optional<Option> opt = voting.getOptions().
                stream().filter(in -> input.equals(in)).findFirst();
            //inc voting option
            if (opt.isPresent()) {
                opt.get().setVoices(opt.get().getVoices()+1);
                voitingRepository.save(voting);
                return true;
            } 
        }
        return false;
    }
    
    //delete voting   Admin
    @RequestMapping(method = RequestMethod.DELETE, value = "/{votingId}")
    boolean addVoting(@PathVariable Long votingId) {
        voitingRepository.delete(votingId);
        return true;
    }

}
