package tests;

import helper.DataOfProject;
import helper.DataOfUser;
import org.apache.maven.model.Dependency;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.Configurations;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class TestTask extends TestInit {
    Logger logger = Logger.getLogger(TestTask.class.getName());

    @Test
    public void checkLibraries() throws IOException, XmlPullParserException {

        String pathToFile = System.getProperty("user.home") + "/Downloads/pom.xml";

        LoginPage loginPage = new LoginPage(driver);
        Configurations configurations = new Configurations(pathToFile);

        loginPage
                .signInUser(DataOfUser.EMAIL_USER, DataOfUser.PASSWORD_USER)
                .searchProject(DataOfProject.PROJECT_NAME + "\n")
                .selectProject()
                .selectPomFile()
                .open();

        List<Dependency> dependencies = configurations.getDependencies();
        dependencies
                .forEach(dependency -> logger.info(dependency.getArtifactId() + " : " + dependency.getVersion()));
        boolean dependencyTestNg = dependencies.stream()
                .anyMatch(dependency -> dependency.getArtifactId().equals("testng") && dependency.getVersion().equals("7.4.0"));

        Assert.assertTrue(dependencyTestNg);
    }

}



