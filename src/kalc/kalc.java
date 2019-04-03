package kalc;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 *
 * @author Badaev - II
 */
public class kalc extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Создание надписей и форм, для вбивания входных данных
        Label txt0 = new Label("Первоначальный вклад, рубли");        
        TextField input0 = new TextField();
        
        Label txt1 = new Label("Время вклада, месяц");        
        TextField input1 = new TextField();
        
        Label txt2 = new Label("Процент вклада, %");        
        TextField input2 = new TextField();          
        
        Label txt3 = new Label("Сумма вклада");  
        TextField output = new TextField();
        
        Button btn = new Button();
        btn.setText("Рассчитать");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                int months = 0;
                double initSum,proc = 0;
                try {
                    initSum = Double.parseDouble(input0.getText());
                    months = Integer.parseInt(input1.getText());
                    proc = Double.parseDouble(input2.getText()) / 100.0;
                    if (initSum < 0 || months < 0 || proc < 0)  {                        
                        output.setText("Неверные данные");
                        return;
                    }
                    int sum = (int)Math.round(kalc.calcSumProc(initSum, months, proc));
                    
                    output.setText(Integer.toString(sum));
                } catch (NumberFormatException e) {
                    output.setText("Неверные данные");
                }
            }
        });
        
        Button clr = new Button();
        clr.setText("Очистить");
        clr.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                input0.clear();
                input1.clear();
                input2.clear();
                output.clear();
            }
        });
        
        TilePane root = new TilePane(Orientation.VERTICAL, txt0, input0, txt1, input1, txt2, input2, txt3, output, btn, clr);  
        root.setPrefTileWidth(500);
        root.setPrefTileHeight(35);
        
        Scene scene = new Scene(root, 500, 350);
        
        primaryStage.setTitle("Депозитный калькулятор");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static double calcSumProc(double initSum, int months, double proc){
        double sum = initSum;
        LocalDate nowDate = LocalDate.now();        
        LocalDate procDate = LocalDate.now().plusMonths(1);
        for (int i = 0; i < months; i++){
            int days = nowDate.lengthOfMonth() - nowDate.getDayOfMonth() + procDate.getDayOfMonth();
            nowDate = nowDate.plusMonths(1);
            procDate = procDate.plusMonths(1);
            sum += initSum * proc * days / procDate.lengthOfYear();
        }
        return sum;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}