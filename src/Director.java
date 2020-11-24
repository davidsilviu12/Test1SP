import java.util.ArrayList;
import java.util.List;

public class Director implements IDirector {
    private final List<IFisier> fisiere = new ArrayList<>();
    private final String filePath;

    public Director(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<IFisier> getSubfiles() {
        return fisiere;
    }

    @Override
    public void addFile(IFisier fisier) {
        fisiere.add(fisier);
    }

    @Override
    public int getTotalSize() {
        int marime = 0;

        for (IFisier fisier : this.getSubfiles()) {
            if (fisier instanceof Director) {
                marime += fisier.getFileSize() + ((Director) fisier).getTotalSize();
            } else {
                marime += fisier.getFileSize();
            }
        }

        return marime;
    }

    @Override
    public String getPath() {
        return filePath;
    }

    @Override
    public int getFileSize() {
        return 0;
    }
}
