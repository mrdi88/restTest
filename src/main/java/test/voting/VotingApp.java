package test.voting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import test.voting.domain.Option;
import test.voting.domain.Voting;
import test.voting.repository.VoitingRepository;

@SpringBootApplication
@ComponentScan
public class VotingApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(VotingApp.class, args);
    }
    
    @Bean
    CommandLineRunner init(VoitingRepository voitingRepository) {
		return (evt) -> Arrays.asList(
				"dsyer dsa?,pweb bd?,ogie sarke?,rwinc sash?,mfis sher?,mpollack?,jlong long?".split(","))
				.forEach(
                                            a -> {
                                                List<Option> options = new ArrayList<>();
                                                options.add(new Option("op1"));
                                                options.add(new Option("op2"));
                                                options.add(new Option("op3"));
						Voting voting = voitingRepository.save(new Voting(a,options));
                                            });
    }
}