/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.voting.domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dima
 */
@Controller
public class VotingController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("votingList");

        return mav;
    }
    
    @RequestMapping(value = "/v", method = RequestMethod.GET)
    public ModelAndView voting() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("voting");

        return mav;
    }

}