package italia.company;

import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Milleaccendini extends Stage {

    public Milleaccendini(Stage milleaccendinisStage) {
        WebView webview = new WebView();
        webview.getEngine().load(
                "http://www.youtube.com/embed/59L51yWUFiQ?autoplay=1&hl=en&cc_lang_pref=en&cc=1"
        );
        webview.setPrefSize(640, 390);

        milleaccendinisStage.setScene(new Scene(webview));
        milleaccendinisStage.show();
    }
}
