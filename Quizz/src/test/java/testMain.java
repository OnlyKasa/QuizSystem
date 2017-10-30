/**
 * Created by User on 9/7/2017.
 */
public class testMain {
    public static void main(String args[]){
        try {
            String controllerName = "AM22";
            String out = (String) Class.forName("com.ominext.gooval.domain.common.constant.QuizTrasitionConst$TEMPLATE").getDeclaredField(controllerName).get(null);
            System.out.println(out);
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}
