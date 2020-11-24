public class FisierText implements IFisier {
    private final String filePath;
    private AlignStrategy alignStrategy = new AlignLeft();

    public FisierText(String filePath) {
        this.filePath = filePath;
    }

    public AlignStrategy getAlignStrategy() {
        return alignStrategy;
    }

    public void setAlignStrategy(AlignStrategy alignStrategy) {
        this.alignStrategy = alignStrategy;
    }

    @Override
    public String getPath() {
        return filePath;
    }

    @Override
    public int getFileSize() {
        return 5;
    }

}
