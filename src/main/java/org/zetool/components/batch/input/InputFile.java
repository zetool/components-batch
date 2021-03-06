
package org.zetool.components.batch.input;

import org.zetool.components.batch.input.reader.InputFileReader;
import org.zetool.components.batch.output.TreeListItem;
import java.io.File;
import java.util.Objects;
import javax.swing.Icon;

/**
 *
 * @author Martin Groß
 */
public class InputFile implements TreeListItem {

    private File file;
    //private FileFormatEnum format;
    private InputFileReader reader;
    private FileFormat format;

    public InputFile(File file, FileFormats fileFormats) {
        if (!file.exists() || !file.canRead()) {
            throw new IllegalArgumentException(file + " cannot be read.");
        }
        this.file = file;
        this.format = fileFormats.determineFileFormat( file );
        //FileFormatEnum.determineFileFormat(file);
        try {
            this.reader = format.getReader().newInstance();
            reader.setFile(file);
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new AssertionError("Reader could not be initialized.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InputFile other = (InputFile) obj;
        if (!Objects.equals(this.file, other.file)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.file);
        return hash;
    }

    public File getFile() {
        return file;
    }

    public FileFormat getFormat() {
        return format;
    }

    public ProblemType getProblemType() {
        return format.getProblemType();
    }

    public String[] getPropertyNames() {
        return format.getProblemType().getPropertyNames();
    }

    public String[] getProperties() {
        return reader.getProperties();
    }

    public InputFileReader<ProblemType> getReader() {
        return reader;
    }

    @Override
    public String toString() {
        return file.getName();
    }

  @Override
  public String getDescription() {
    return file.getPath();
  }

  @Override
  public String getTitle() {
    return toString();
  }

  @Override
  public Icon getIcon() {
    return format.getIcon();
  }
}
