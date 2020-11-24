import java.util.List;

public interface IDirector extends IFisier {
    List<IFisier> getSubfiles();
    void addFile(IFisier fisier);

    // Returneaza dimensiunea totala a fisierelor din director
    int getTotalSize();
}
