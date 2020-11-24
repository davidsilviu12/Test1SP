public class Main {

    public static void main(String[] args) {
        // a. Directoare si fisiere
        Director principal = new Director("data/");
        Director secundar = new Director("sub/");

        FisierMP3 fisierMP3 = new FisierMP3("fisier.mp3");
        FisierSVG fisierSVG = new FisierSVG("fisier.svg");
        FisierText fisierText = new FisierText("fisier.txt");
        fisierText.setAlignStrategy(new AlignRight());
        FisierText fisierText2 = new FisierText("fisier2.txt");
        fisierText2.setAlignStrategy(new AlignLeft());

        principal.addFile(fisierMP3);
        principal.addFile(fisierSVG);
        principal.addFile(fisierText2);
        principal.addFile(secundar);

        secundar.addFile(fisierText);

        // b. Printarea directoarelor folosind un AlignStrategy
        //
        // OUTPUT
        // <<<<<./data/fisier.mp3>>>>>
        // <<<<<./data/fisier.svg>>>>>
        // <<<<<./data/fisier2.txt>>>>>
        // <<<<<./data/sub/fisier.txt>>>>>
        printDirector("./", principal, new AlignCenter());

        // c. Calcul total al dimensiunii
        //
        // Folosind structura creata la a) avem
        // 1 fisierMP3 + 1 fisierSVG + 2 fisierText
        // 3072Kb (3Mb) + 45Kb + 2*5Kb = 3127Kb
        //
        // OUTPUT
        // Marime totala: 3127Kb
        int marimeTotala = principal.getTotalSize();
        System.out.println("Marime totala: " + marimeTotala + "Kb");
    }

    private static void printDirector(String initialPath, Director director, AlignStrategy alignStrategy) {
        for (IFisier fisier : director.getSubfiles()) {
            if (fisier instanceof Director) {
                printDirector(initialPath + director.getPath(), (Director) fisier, alignStrategy);
            } else {
                alignStrategy.render(initialPath + director.getPath() + fisier.getPath());
            }
        }
    }

}