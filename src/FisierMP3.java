public class FisierMP3 implements IFisier {
    private final String filePath;

    public FisierMP3(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getPath() {
        return filePath;
    }

    @Override
    public int getFileSize() {
        return 3*1024;
    }
}
