import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;
import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //Why we create reference variale of Impl because we are calling setter which is present only in class and not in interface
    //Here by doing this we are wiring the Bean of repo inside our service.
    //Why we created a setter to inject instace rather than new HibernateSpeakerRepositoryImpl() because we have created a Bean of
    // speakerRepository and bean is always singelton no matter how many times we call getSpeakerService and only one of speakerRepository
    //will be created.
    @Bean(name="speakerService")
    public SpeakerService getSpeakerService(){
        SpeakerServiceImpl speakerServiceImpl = new SpeakerServiceImpl();
        speakerServiceImpl.setSpeakerRepository(getSpeakerRepository());
        return speakerServiceImpl;
    }


    //This bean will be registered to spring application context as soon as AppConfig is initiated.
    // This is a singleton,object will be created once
    @Bean(name="speakerRepository")
    public SpeakerRepository getSpeakerRepository()
    {
        return new HibernateSpeakerRepositoryImpl();
    }
}