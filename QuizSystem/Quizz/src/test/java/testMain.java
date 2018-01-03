/**
 * Created by User on 9/7/2017.
 */
public class testMain {
    public static void main(String args[]){
        try {
            String controllerName = "home";
            String out = (String) Class.forName("com.ben.quiz.domain.common.constant.QuizTrasitionConst$TEMPLATE").getDeclaredField(controllerName).get(null);
            System.out.println(out);
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}
