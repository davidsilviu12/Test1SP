public class FisierSVG implements IFisier {
    private final String filePath;

    public FisierSVG(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getPath() {
        return filePath;
    }

    @Override
    public int getFileSize() {
        return 45;
    }
}
