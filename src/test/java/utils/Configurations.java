package utils;

import lombok.SneakyThrows;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Configurations {

    private final File pomFile;

    public Configurations(String path) {
        this.pomFile = new File(path);
    }

    @SneakyThrows
    public List<Dependency> getDependencies() {
        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model = reader.read(new FileReader(pomFile));
        return model.getDependencies();
    }

}

