import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args){

      /*  Below line is loading spring and loading our configuration file into the application context.
         So when below line is execute then it will go and create a basic registry with 2 beans in it .*/
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);

       /* Without spring

          SpeakerService speakerService = new SpeakerServiceImpl();
          */

        //When we call the speakerService Bean it will inject the speakerRepository Bean in it as well.
        SpeakerService speakerService = applicationContext.getBean("speakerService",SpeakerService.class);
        System.out.println(speakerService);

        SpeakerService speakerService2 = applicationContext.getBean("speakerService",SpeakerService.class);
        System.out.println(speakerService2);


        System.out.println(speakerService.findAll().get(0).getFirstName());
    }
}
