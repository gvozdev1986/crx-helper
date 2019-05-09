package by.hvozdzeu.crxhelper;

import com.sun.javafx.webkit.WebConsoleListener;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import static by.hvozdzeu.crxhelper.constants.CrxHelperConstants.*;

public class Main extends Application {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    @Override
    public void start(final Stage stage) throws Exception {

        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();

        getConsoleLog();
        loadWebPage(webEngine);
        AnchorPane root = getAnchorPane(browser);
        getScene(stage, root);

        stage.show();
    }

    private void getConsoleLog() {
        WebConsoleListener.setDefaultListener((webView, message, lineNumber, sourceId) -> {
            LOGGER.info(message + "[at " + lineNumber + "]");
        });
    }

    private void getScene(Stage stage, AnchorPane root) {
        Scene scene = new Scene(root);
        stage.setTitle(APP_NAME);
        stage.setScene(scene);
        stage.getIcons().add(new Image(APP_LOGO_PATH));
        stage.setMaximized(true);
    }

    private AnchorPane getAnchorPane(WebView browser) {
        AnchorPane root = new AnchorPane();
        root.setPadding(new Insets(PATTERN_PADDING));
        root.getChildren().addAll(browser);
        AnchorPane.setTopAnchor(browser, PATTERN_ANCHOR);
        AnchorPane.setLeftAnchor(browser, PATTERN_ANCHOR);
        AnchorPane.setRightAnchor(browser, PATTERN_ANCHOR);
        AnchorPane.setTopAnchor(browser, PATTERN_ANCHOR);
        AnchorPane.setBottomAnchor(browser, PATTERN_ANCHOR);
        return root;
    }

    private void loadWebPage(WebEngine webEngine) throws MalformedURLException {
        File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(WEB_PATH)).getFile());
        URL url = file.toURI().toURL();
        webEngine.setJavaScriptEnabled(true);
        webEngine.load(url.toString());
    }

    public static void main(String[] args) {
        launch(args);
    }

}
