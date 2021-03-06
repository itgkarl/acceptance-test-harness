package org.jenkinsci.test.acceptance.plugins.deploy;

import org.jenkinsci.test.acceptance.po.*;
import org.openqa.selenium.WebElement;

/**
 * @author Kohsuke Kawaguchi
 */
@Describable("Deploy war/ear to a container")
public class DeployPublisher extends AbstractStep implements PostBuildStep {
    public DeployPublisher(Job parent, String path) {
        super(parent, path);
    }

    public final Control war = control("war");
    public final Control contextPath = control("contextPath");
    public final Control user = control("adapter/userName");
    public final Control password = control("adapter/password");
    public final Control url = control("adapter/url");

    // one control that has a really strange path.
    public final Control container = new Control(this) {
        @Override
        public WebElement resolve() {
            return find(by.path("/publisher/"));
        }
    };
}
