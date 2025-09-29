
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Game extends Application {
    private final int width = 30;
    private final int height = 20;
    private final int tileSize = 32; // pixels

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(width * tileSize, height * tileSize);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        AbstractMap map = new CityMap(width, height);
        //AbstractMap map = new WildernessMap(width, height);
        map.render(gc, tileSize);

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("RPG Map Generator with Flyweight");
        stage.show();
    }

}
